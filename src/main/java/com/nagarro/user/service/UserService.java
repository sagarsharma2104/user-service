package com.nagarro.user.service;

import com.nagarro.user.entity.User;

import io.opentracing.Span;

public interface UserService {
	
	User getUserById(long id, Span rootSpan);

	User saveUserById(User user, Span rootSpan);

}
