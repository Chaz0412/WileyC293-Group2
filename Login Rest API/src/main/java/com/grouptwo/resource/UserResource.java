package com.grouptwo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.grouptwo.entity.User;
import com.grouptwo.service.UserService;

@RestController
public class UserResource {

	@Autowired
	private UserService userService;
	
	@GetMapping(path = "/login/{uname}/{password}",produces = MediaType.APPLICATION_JSON_VALUE)
	public User loginResource(@PathVariable("uname") int userID,@PathVariable("password") String pwd) {
		System.out.println(userID + " YOOOOOOOOOOO " + pwd);
		User test = userService.loginUser(userID, pwd);
		try {
			System.out.println(test.getFirstName() + " DOES THIS WROK?????");
		} catch (Exception e) {
			System.out.println(" AINT NUDDAH DEYA?????");
		}
		return test;
	}
	
}
