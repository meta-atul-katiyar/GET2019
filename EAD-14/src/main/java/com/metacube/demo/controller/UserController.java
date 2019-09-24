package com.metacube.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.metacube.demo.model.User;
import com.metacube.demo.service.IUserService;


/**
 * Controller class.
 */
@Controller
@SessionAttributes({"username"})
public class UserController {

	@Autowired
	IUserService userService;
	@Value("${welcome.message}")
	private String message;

	/**
	 * Method to mapped home page.
	 * @param model
	 * @return
	 */
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("message", message);
		return "home";
	}

	/**
	 * Method to map studentDetailsForm page. 
	 * @param model
	 * @return
	 */
	@GetMapping("/AddUser")
	public String userDetail(Model model) {
		model.addAttribute(new User());
		return "addUser";
	}

	/**
	 * Method to get data from studentDetailsForm page. show the data on console. 
	 * @param student
	 * @param bindingResult
	 * @return
	 */
	@PostMapping("/AddUser")
	public String addStudentDetail(@Validated User user,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "addUser";
		} else {
			System.out.println(user);
				userService.addUser(user);
			return "redirect:/home";
		}
	}

	/**
	 * Method to mapped showStduent page and show the student list. 
	 * @param model
	 * @return
	 */
	@GetMapping("/showUser")
	public String showStudent(Model model) {
		List<User> allUsers = userService.getAllUsers();
		model.addAttribute("users",allUsers);
		return "showAllUsers";
	}
	
	/**
	 * Method to mapped login page.
	 * @param error
	 * @param model
	 * @return
	 */
	@GetMapping("/login")
	public String login(@RequestParam(value="error",required=false) String error,
			@RequestParam(value = "logout",	required = false) String logout, Model model){
		String username="";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
		   username = ((UserDetails)principal).getUsername();
		} else {
		   username = principal.toString();
		}
		System.out.println("user: "+username);
		if(error != null){
			model.addAttribute("errorMsg","Authentication Failed");
		}
		else if (logout != null) {
			model.addAttribute("errorMsg", "Logged out successfully.");
		}
		
		return "login";
	}
	
	@GetMapping("/UserHome")
	public String userHome(Model model) {
		List<User> allUsers ;
		String username="";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
		   username = ((UserDetails)principal).getUsername();
		} else {
		   username = principal.toString();
		}
		
		System.out.println("user: "+username);
		allUsers = userService.getUser(username);
		for(User u : allUsers) {
			System.out.println("ushome: "+u.getContactNumber());
		}
		model.addAttribute("user",allUsers);
		return "userHome";
	}
	
}