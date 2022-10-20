package com.grouptwo.service;

import org.springframework.http.ResponseEntity;

import com.grouptwo.entity.User;

public interface UserService {
	
	public User loginUser(User user);
	public Boolean addUser(User user);
	Boolean changeBalance(User user, int increment);
}
