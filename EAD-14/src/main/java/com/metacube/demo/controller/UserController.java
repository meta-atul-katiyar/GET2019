package com.metacube.demo.controller;

import java.util.ArrayList;
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

import com.metacube.demo.model.User;
import com.metacube.demo.passwordEncryption.UpdatableBCrypt;
import com.metacube.demo.service.IUserService;

/**
 * Controller class.
 */
@Controller
public class UserController {

	@Autowired
	IUserService userService;
	@Value("${welcome.message}")
	private String message;

	private static final UpdatableBCrypt bcrypt = new UpdatableBCrypt(10);

	/**
	 * Method to mapped home page.
	 * 
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
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/AddUser")
	public String userDetail(Model model) {
		
		List<String> roleList = new ArrayList<>();

		roleList.add("admin");
		roleList.add("user");
		model.addAttribute("roleList", roleList);
		model.addAttribute(new User());
		return "addUser";
	}

	/**
	 * Method to get data from studentDetailsForm page. show the data on console.
	 * 
	 * @param student
	 * @param bindingResult
	 * @return
	 */
	@PostMapping("/AddUser")
	public String addStudentDetail(@Validated User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "addUser";
		} else {
			user.setPassword(bcrypt.hash(user.getPassword()));
			System.out.println(user);
			userService.addUser(user);
			return "redirect:/showUser";
		}
	}

	/**
	 * Method to mapped showStduent page and show the student list.
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/showUser")
	public String showStudent(Model model) {
		List<User> allUsers = (List<User>) userService.getAllUsers();
		model.addAttribute("users", allUsers);
		return "showAllUsers";
	}

	/**
	 * Method to mapped login page.
	 * 
	 * @param error
	 * @param model
	 * @return
	 */
	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		String userName = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
			model.addAttribute("username", userName);
		} else {
			userName = principal.toString();
		}
		System.out.println("user: " + userName);
		if (error != null) {
			model.addAttribute("errorMsg", "Authentication Failed");
		} else if (logout != null) {
			model.addAttribute("errorMsg", "Logged out successfully.");
		}

		return "login";
	}

	@GetMapping("/UserHome")
	public String userHome(Model model) {
		List<User> allUsers;
		String username = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}

		System.out.println("user: " + username);
		allUsers = userService.findByUserName(username);

		model.addAttribute("users", allUsers);
		return "userHome";
	}

	@GetMapping("/EditUserDetails")
	public String editUser(@RequestParam("userName") String userName, Model model) {
		System.out.println("euname: " + userName);
		if (userName.equals("")) {
			User user = null;
			String username = "";
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal instanceof UserDetails) {
				username = ((UserDetails) principal).getUsername();
			} else {
				username = principal.toString();
			}
			for (User u : userService.findByUserName(username)) {
				user = u;
			}
			System.out.println("user: " + user.getEmail());

			model.addAttribute("user", user);
		} else {
			User user = null;
			for (User u : userService.findByUserName(userName)) {
				user = u;
			}
			model.addAttribute("user", user);
		}
		
		List<String> roleList = new ArrayList<>();

		roleList.add("admin");
		roleList.add("user");
		model.addAttribute("roleList", roleList);

		return "editUser";
	}

	@PostMapping("/EditUserDetails")
	public String editUserPost(@RequestParam("userName") String userName, @Validated User user,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "editUser";
		}

		User userTemp = null;
		String username = "";
		if (userName.equals("")) {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal instanceof UserDetails) {
				username = ((UserDetails) principal).getUsername();
			} else {
				username = principal.toString();
			}
		}
		else {
			username=userName;
		}
		
		for (User u : userService.findByUserName(username)) {
			userTemp = u;
		}

		userTemp.setContactNumber(user.getContactNumber());
		userTemp.setEmail(user.getEmail());
		userTemp.setFatherName(user.getFatherName());
		userTemp.setFirstName(user.getFirstName());
		userTemp.setLastName(user.getLastName());
		userTemp.setUsername(user.getUsername());

		System.out.println(user.getFirstName());
		userService.addUser(userTemp);
		if (userName.equals("")) {
			return "redirect:/UserHome";
		}
		else {
			return "redirect:/showUser";
		}
		
	}
	
	@GetMapping("/accessDenied")
	public String accessDenied(Model model) {
		return "accessDenied";
	}

}