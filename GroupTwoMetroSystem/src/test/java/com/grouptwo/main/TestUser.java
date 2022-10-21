package com.grouptwo.main;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.grouptwo.entity.User;
import com.grouptwo.service.UserServiceImpl;



@SpringBootTest
class TestUser {
	
	User user;
	
	@Autowired
	RestTemplate rest;
	
	@BeforeEach
	public void testLogin() {
		user = rest.getForObject("http://localhost:8082/login/" + 1 + "/1234", User.class);
		assertEquals(user.getFirstName(), "Albert");
		//assertEquals(user.getFirstName(), "l");
	}
	
	@Test
	public void testChangeBalance() {
		System.out.println(user.getSalary());
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<User> entity = new HttpEntity<User>(headers);
		assertEquals(rest.exchange("http://localhost:8082/AddFunds/"+user.getUserId()+"/"
				+10, HttpMethod.PUT, entity, boolean.class).getBody(), true);
		System.out.println(user.getSalary());
	}
	
	@Test
	void testSignUp() {
		User userSignUp = new User(7, "Bruce", "Wayne", "batman", 100);
		assertEquals(rest.getForEntity("http://localhost:8082/signUp/" + userSignUp.getFirstName() + "/" + userSignUp.getLastName() + "/" + userSignUp.getPassword(), boolean.class).getBody(), true);
		
	}
}
