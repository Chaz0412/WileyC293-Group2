package com.grouptwo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.grouptwo.entity.User;
import com.grouptwo.service.UserService;

@Controller
@SessionAttributes({"user"})
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public ModelAndView getLoginPage() {
		return new ModelAndView("Login","command",new User());
	}
	
	@RequestMapping("/loginUser")
	public ModelAndView loginCheck(@ModelAttribute("command") User user/*,HttpSession session*/) {
		ModelAndView modelAndView=new ModelAndView();
		User usr=userService.loginUser(user);
		if(usr!=null) {
			modelAndView.addObject("user", usr);  //request Scope
//			session.setAttribute("user", user);
			modelAndView.setViewName("Menu");
		}
		else {
			modelAndView.addObject("message", "Login Failed!");
			modelAndView.setViewName("Login");
		}
		return modelAndView;
	}
	
	@RequestMapping("/signUpPage")
	public ModelAndView getSignUpPage() {
		return new ModelAndView ("SignUp", "command", new User());
	}
	
	@RequestMapping("/addUser")
	public ModelAndView insertUser(@ModelAttribute("command") User user) {
		
		ModelAndView modelAndView=new ModelAndView();
		String message=null;
		
		if(userService.addUser(user)) {
			message="User Added";
		}
		else {
			message="User Not Added";
		}
		modelAndView.addObject("message", message);
		
		modelAndView.setViewName("Login");
		
		return modelAndView;
	}
}
