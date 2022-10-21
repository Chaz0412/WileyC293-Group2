package com.grouptwo.service;


import com.grouptwo.entity.User;

public interface UserService {
	
	public User loginUser(User user);
	public Boolean addUser(User user);
	Boolean changeBalance(int userId, double increment);
}
