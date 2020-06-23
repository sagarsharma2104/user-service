package com.nagarro.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}