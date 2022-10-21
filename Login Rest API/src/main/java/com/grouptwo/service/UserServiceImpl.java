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

	@Override
	public boolean signUpUser(String fname, String lname, String Password) {
		try {
			int rows = userDao.insertUser(fname, lname, Password, 100.0);
			if (rows > 0) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	@Override
	public boolean changeBalance(int userId, double increment) {
		User user = userDao.getById(userId);
		userDao.updateBalance(userId, user.getSalary() + increment);
		if(user !=null) {
			if (userDao.updateBalance(userId, user.getSalary() + increment)>0) {
				return true;
			}
		}
		return false;
	}

}
