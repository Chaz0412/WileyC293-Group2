package com.grouptwo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grouptwo.entity.User;
import com.grouptwo.service.UserService;

@RestController
public class UserResource {

	@Autowired
	private UserService userService;
	
	@GetMapping(path = "/login/{uname}/{password}",produces = MediaType.APPLICATION_JSON_VALUE)
	public User loginResource(@PathVariable("uname") int userID,@PathVariable("password") String pwd) {
		return userService.loginUser(userID, pwd);
	}
	
	@GetMapping(path = "/signUp/{fname}/{lname}/{password}",produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean signUpResource(@PathVariable("fname") String userFName,@PathVariable("lname") String userSName, 
			@PathVariable("password") String userPass ) {
		return userService.signUpUser(userFName, userSName, userPass);
	}
	
	@PutMapping(path = "/AddFunds/{id}/{val}", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean balanceResource(@PathVariable("id") int userId ,@PathVariable("val") double increment) {
		return userService.changeBalance(userId, increment);
	}
}
