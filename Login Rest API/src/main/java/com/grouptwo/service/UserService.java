package com.grouptwo.service;

import com.grouptwo.entity.User;

public interface UserService {
	
	public User loginUser(int userID, String Password);
	
	public boolean signUpUser(String fname, String lname, String Password);

	public boolean changeBalance(int userId, double increment);

}
