package com.grouptwo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.grouptwo.entity.User;
import com.grouptwo.persistence.UserDao;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public User loginUser(User user) {
		
//		return userDao.getUserByUserNameAndPassword(user.getUserName(), user.getPassword());
		return restTemplate.getForObject("http://localhost:8082/login/"+user.getUserId()+"/"+user.getPassword(), User.class);
	}
	@Override
	public User addFunds(int userId, double addFunds) {
		// TODO Auto-generated method stub
		return userDao.addFunds(userId, addFunds);
	}
	@Override
	public User removeFunds(int userId, double removeFunds) {
		// TODO Auto-generated method stub
		return userDao.removeFunds(userId, removeFunds);
	}

}
