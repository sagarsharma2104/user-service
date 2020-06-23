package com.nagarro.user.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.user.entity.User;
import com.nagarro.user.repository.UserRepository;
import com.nagarro.user.service.UserService;

import io.opentracing.Span;
import io.opentracing.Tracer;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private Tracer tracer;

	@Autowired
	UserServiceImpl(UserRepository userRepository, Tracer tracer) {
		this.userRepository = userRepository;
		this.tracer = tracer;
	}

	@Override
	public User getUserById(long id, Span rootSpan) {
		Span span = tracer.buildSpan("User Service --> getUserById").asChildOf(rootSpan).start();
		span.setTag("http.status_code", 200);
		return userRepository.findById(id).get();
	}
	

	@Override
	public User saveUserById(User user, Span rootSpan) {
		Span span = tracer.buildSpan("User Service --> saveUserById").asChildOf(rootSpan).start();
		User newUser = userRepository.save(user);
		if (Objects.nonNull(newUser)) {
			span.setTag("http.status_code", 201);
		} else { 
			span.setTag("http.status_code", 409);
		}
		return newUser;
	}

}
