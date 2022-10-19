package com.grouptwo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
		try {
			return restTemplate.getForObject("http://localhost:8082/login/" + user.getUserId() + "/" + user.getPassword(),
					User.class);
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public Boolean addUser(User user) {
		try {
			return restTemplate.getForEntity("http://localhost:8082/signUp/" + user.getFirstName() + "/" + user.getLastName() 
			+ "/" + user.getPassword(), boolean.class).getBody();
		} catch (Exception e) {
			return false;
		}
	
	}

}
