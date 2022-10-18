package com.grouptwo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grouptwo.entity.User;
import com.grouptwo.persistence.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User loginUser(int userID, String Passowrd) {
		
		return userDao.getUserByUserIdAndPassword(userID, Passowrd);
	}

}
