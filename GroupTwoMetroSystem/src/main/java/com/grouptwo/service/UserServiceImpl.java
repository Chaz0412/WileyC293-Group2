package com.grouptwo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.grouptwo.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public User loginUser(User user) {
		try {
			return restTemplate.getForObject(
					"http://localhost:8082/login/" + user.getUserId() + "/" + user.getPassword(), User.class);
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public Boolean addUser(User user) {
		try {
			return restTemplate.getForEntity("http://localhost:8082/signUp/" + user.getFirstName() + "/"
					+ user.getLastName() + "/" + user.getPassword(), boolean.class).getBody();
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public Boolean changeBalance(int userId, double increment) {
		try {
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<User> entity = new HttpEntity<User>(headers);
			return restTemplate.exchange("http://localhost:8082/AddFunds/"+userId+"/"
					+increment, HttpMethod.PUT, entity, boolean.class).getBody();
		} catch (Exception e) {
			return false;
		}

	}

}
