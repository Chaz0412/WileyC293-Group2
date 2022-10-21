package com.sujata.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.grouptwo.entity.User;
import com.grouptwo.persistence.UserDao;
import com.grouptwo.service.UserService;
import com.grouptwo.service.UserServiceImpl;

@SpringBootTest()
@SpringBootConfiguration
class UserSpringbootRestApiProjectApplicationTests {

//	private UserService userService;
//	
//	@BeforeEach
//	void contructObjects(){
//		userService = new UserServiceImpl();
//	}
//	
//	@Test
//	void contextLoads() {
//	}
//	
//	@BeforeEach
//	
//	@Test
//	public void testGetBalance() {
//		User user = new User();
//		user.setSalary(100);
//		assertEquals(user.getSalary(), 100, "Balance has been set to 0");
//	}
//	
//	@Test
//	public void testGetUser() {
//		User user = userService.loginUser(1, "1234");
//		assertEquals(user.getFirstName(),"Albert", "Login uses user already on db");
//		
//	}

}
