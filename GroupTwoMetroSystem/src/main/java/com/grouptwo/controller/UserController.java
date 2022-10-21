package com.grouptwo.controller;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.grouptwo.entity.Station;
import com.grouptwo.entity.Transactions;
import com.grouptwo.entity.User;
import com.grouptwo.service.StationService;
import com.grouptwo.service.TransactionService;
import com.grouptwo.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private StationService stationService;
	
	@Autowired
	private TransactionService transactionService;
	
	@ModelAttribute("stationNames")
	List<String> getStations(){
		return stationService.getAllStations().stream()
				.map(Station::getStationName)
				.distinct()
				.collect(Collectors.toList());
	}

	
	@RequestMapping("/")
	public ModelAndView getLoginPage() {
		return new ModelAndView("Login","command",new User());
	}
	
	@RequestMapping("/menu")
	public ModelAndView getMenuPage() {
		return new ModelAndView("Menu");
	}
	
	@RequestMapping("/loginUser")
	public ModelAndView loginCheck(@ModelAttribute("command") User user, HttpSession session) {
		ModelAndView modelAndView=new ModelAndView();
		User usr=userService.loginUser(user);
		if(usr!=null) {
			session.setAttribute("user", usr);
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
	
	@RequestMapping("/addFundsPage")
	public ModelAndView addFundsPage() {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("AddFunds");
		return modelAndView;
	}
	
	@RequestMapping("/addFundUser")
	public ModelAndView addFunds(HttpServletRequest request, HttpSession session) {
		ModelAndView modelAndView=new ModelAndView();
		String message=null;
		double money = Double.parseDouble(request.getParameter("funds"));
		User user = (User)session.getAttribute("user");
		
		if (userService.changeBalance(user.getUserId(), money)) {
			session.setAttribute("user", userService.loginUser(user));
			message = "Funds Added!";
			modelAndView.addObject("message", message);
			modelAndView.setViewName("Menu");
		} else {
			message = "Funds Not Added!";
			modelAndView.addObject("message", message);
			modelAndView.setViewName("AddFunds");
		}	
		return modelAndView;
	}
	
	@RequestMapping("/LogJourneyPage")
	public ModelAndView LogJourneyPage() {
		return new ModelAndView("LogJourney", "journey", new Station());
	}
	
	@RequestMapping("/LogJourney")
	public ModelAndView LogJourneyController(@ModelAttribute("journey") Station Station, HttpServletRequest request, HttpSession session) {
		ModelAndView modelAndView=new ModelAndView();
		String[] stations = request.getParameterValues("stationName");
		String message=null;
		User user = (User)session.getAttribute("user");
		
		if (transactionService.addTransaction(user.getUserId(), stations[0], stations[1])) {
			session.setAttribute("user", userService.loginUser(user));
			message = "Transaction Completed";
			modelAndView.addObject("message", message);
			modelAndView.setViewName("Menu");
		} else {
			message = "Transaction Failed";
			modelAndView.addObject("message", message);
			modelAndView.setViewName("Menu");
		}
		return modelAndView;
	}
	
	@RequestMapping("/showTransactions")
	public ModelAndView showAllEmployeesController(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		
		User user = (User)session.getAttribute("user");
		
		
		Collection<Transactions> transactionsList = 
				transactionService.getTransById(user.getUserId());
		
		
		modelAndView.addObject("transactions", transactionsList);
		modelAndView.setViewName("ShowTransactions");
		
		return modelAndView;
	}
	

}
