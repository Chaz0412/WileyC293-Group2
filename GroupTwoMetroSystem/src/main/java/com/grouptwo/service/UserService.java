package com.grouptwo.service;

import com.grouptwo.entity.User;

public interface UserService {
	
	public User loginUser(User user);
	public User addFunds(int userId, double addFunds);
	public User removeFunds(int userId, double removeFunds);

}
