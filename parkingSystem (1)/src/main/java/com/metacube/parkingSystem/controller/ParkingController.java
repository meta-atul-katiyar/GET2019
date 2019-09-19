package com.metacube.parkingSystem.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.metacube.parkingSystem.model.Employee;
import com.metacube.parkingSystem.model.EmployeeDB;
import com.metacube.parkingSystem.model.FriendsDB;
import com.metacube.parkingSystem.model.PassDetailDB;
import com.metacube.parkingSystem.model.PassJoinVehicle;
import com.metacube.parkingSystem.model.Vehicle;
import com.metacube.parkingSystem.service.IEmployeeSevice;



@Controller
@SessionAttributes({"employeeId", "gender"})
public class ParkingController {

	@Autowired
	private IEmployeeSevice employeeService;

	private static final Logger log = LoggerFactory.getLogger(ParkingController.class);

	@GetMapping("/")
	public String registration(Model model) {
		model.addAttribute(new Employee());
		List<String> organizationList = new ArrayList<>();

		organizationList.add("abc");
		organizationList.add("def");
		organizationList.add("ghi");
		organizationList.add("jkl");

		model.addAttribute("organizationList", organizationList);
		return "employeeRegister";
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute(new Employee());
		return "login";
	}
	 
	@PostMapping("/login")
	public String redirectLogin(Employee employee, Model model) {
		EmployeeDB emp = employeeService.getEmployeeDetail(employee.getEmail(), employee.getPassword());
		if(emp.getID() > 0){
			model.addAttribute("employeeId", emp.getID());
			model.addAttribute("gender", emp.getGender());
			return "redirect:/UserHome";
		}
		else {
			return "login";
		}
		
	}
	
	@PostMapping("/")
	public String addEmployeeDetail(@Validated Employee employee, BindingResult bindingResult, Model model,  RedirectAttributes attribute) {
		
		if (bindingResult.hasErrors()) {

		
			log.info(employee.getFullName());
			List<String> organizationList = new ArrayList<>();

			organizationList.add("abc");
			organizationList.add("def");
			organizationList.add("ghi");
			organizationList.add("jkl");

			model.addAttribute("organizationList", organizationList);
			return "employeeRegister";
		} else {

			log.info(employee.getFullName());
			log.info(employee.getGender());
			log.info(employee.getEmail());
			log.info(employee.getPassword());
			log.info(String.valueOf(employee.getContactNumber()));
			log.info(employee.getOrganization());
			model.addAttribute("gender", employee.getGender());
			if(employeeService.addEmployee(employee) == true) {
				attribute.addFlashAttribute("ID" , employeeService.getEmployeeId(employee.getEmail()));
				return "redirect:/vehicleForm";
			}
			else {
				List<String> organizationList = new ArrayList<>();

				organizationList.add("abc");
				organizationList.add("def");
				organizationList.add("ghi");
				organizationList.add("jkl");

				model.addAttribute("organizationList", organizationList);
				return "employeeRegister";
			}
		}
	}

	@GetMapping("/vehicleForm")
	public String vehicle(Model model) {
		model.addAttribute(new Vehicle());
		return "vehicleForm";
	}

	@PostMapping("/vehicleForm")
	public String addVehicle(@Validated Vehicle vehicle, BindingResult result, 
			Model model, RedirectAttributes attribute) {

		if (result.hasErrors()) {
			return "vehicleForm";
		} else {
			model.addAttribute("employeeId", vehicle.getEmployeeId());
			log.info(Integer.toString(vehicle.getEmployeeId()));
			if(employeeService.addVehicle(vehicle) == true) {
				
				attribute.addAttribute("vehicleType", vehicle.getType());
				attribute.addAttribute("vehicleId", employeeService.getVehicleId(vehicle.getVehicleNumber()));
				attribute.addAttribute("employeeId", vehicle.getEmployeeId());

				return "redirect:/PassDetails";
			}
			else {
				return "vehicleForm";
			}
		}
	}

	@GetMapping("/PassDetails")
	public String priceDetails(@RequestParam("vehicleType") String vehicleType, 
			@RequestParam("vehicleId") int vehicleId, @RequestParam("employeeId") int employeeId,
			Model model, RedirectAttributes attribute) {
		PassDetailDB passDetailDB = new PassDetailDB();
		
		List<String> currencyList = new ArrayList<>();

		currencyList.add("USD");
		currencyList.add("INR");
		currencyList.add("YEN");

		model.addAttribute("currencyList", currencyList);
		
		passDetailDB.setVehicleId(vehicleId);
		model.addAttribute(passDetailDB);
		model.addAttribute("priceList",employeeService.getPriceList(vehicleType));
		attribute.addAttribute("employeeId", employeeId);
		model.addAttribute("vehicleType", vehicleType);
		return "PassDetails";
	}
	
	@PostMapping("/PassDetails")
	public String passDetails(PassDetailDB passDetailDB,  @RequestParam("employeeId") int employeeId,
			RedirectAttributes attribute) {
		if(employeeService.addPassDetail(passDetailDB) == true) {
			attribute.addAttribute("employeeId", employeeId);
			return "redirect:/UserHome";
		}
		else {
			return "PassDetails";
		}
	}
	
	@GetMapping("/UserHome")
	public String userHomePost(@SessionAttribute("employeeId") int employeeId,
			@SessionAttribute("gender") String gender, Model model) {
		ArrayList<PassJoinVehicle> passList = (employeeService.getPassDetail(employeeId));

		if(gender.equals("male")) {
			model.addAttribute("imageName", "default-profile-picture.jpg");
		}
		else {
			model.addAttribute("imageName", "user_profile_female.jpg");
		}
		model.addAttribute("passList", passList);
		return "userHome";
		
	}
	
	@GetMapping("/About")
	public String aboutUser(@SessionAttribute("employeeId") int employeeId, 
			@SessionAttribute("gender") String gender,Model model) {
		EmployeeDB emp = employeeService.getEmployeeDetail(employeeId);
		if(gender.equals("male")) {
			model.addAttribute("imageName", "default-profile-picture.jpg");
		}
		else {
			model.addAttribute("imageName", "user_profile_female.jpg");
		}
		model.addAttribute("emp", emp);
		return "about";
		
	}
	
	@GetMapping("/Friends")
	public String friendsList(@SessionAttribute("employeeId") int employeeId, 
			@SessionAttribute("gender") String gender,Model model,
			RedirectAttributes attribute) {
		System.out.println(employeeId);
		ArrayList<FriendsDB> friendList = employeeService.getFriendsDetail(employeeId);
		System.out.println(friendList.isEmpty());
		if(gender.equals("male")) {
			model.addAttribute("imageName", "default-profile-picture.jpg");
		}
		else {
			model.addAttribute("imageName", "user_profile_female.jpg");
		}
		model.addAttribute("friendList", friendList);
		return "friends";
		
	}
	
	@GetMapping("/FriendHome")
	public String friendHome(@RequestParam("friendId") int friendId,  Model model,
			RedirectAttributes attribute) {
		System.out.println(friendId);
		FriendsDB friend = employeeService.getFriendDetail(friendId);
		
		model.addAttribute("friend", friend);
		return "friendHome";
		
	}
	
	@GetMapping("/AddVehicle")
	public String addVehicle(@SessionAttribute("employeeId") int employeeId,  Model model,
			RedirectAttributes attribute) {
		attribute.addFlashAttribute("ID" , employeeId);
		return "redirect:/vehicleForm";
	}
	
	@GetMapping("/EditUser")
	public String editUser(@SessionAttribute("employeeId") int employeeId,  Model model) {
		EmployeeDB employee = employeeService.getEmployeeDetail(employeeId);
		List<String> organizationList = new ArrayList<>();

		organizationList.add("abc");
		organizationList.add("def");
		organizationList.add("ghi");
		organizationList.add("jkl");

		model.addAttribute("organizationList", organizationList);
		model.addAttribute("employee", employee);
		
		return "editUser";
		
	}
	
	@PostMapping("/EditUser")
	public String editUserPost(@Validated Employee employee, BindingResult bindingResult,
			@SessionAttribute("employeeId") int employeeId,  Model model) {

			if(employeeService.updateEmployee(employee, employeeId) == true) {
				model.addAttribute("gender", employee.getGender());
				return "redirect:/UserHome";
			}
			else {
				List<String> organizationList = new ArrayList<>();

				organizationList.add("abc");
				organizationList.add("def");
				organizationList.add("ghi");
				organizationList.add("jkl");

				model.addAttribute("organizationList", organizationList);
				model.addAttribute("employee", employee);
				return "editUser";
		}
	}
	
	
	
	@GetMapping("/Logout")	
	public String logout(@SessionAttribute("employeeId") int employeeId,  Model model) {
		model.addAttribute("employeeId", 0);
		model.addAttribute("gender", "");
		String msg = "successfully logout";
		model.addAttribute("logoutMessage", msg);
		model.addAttribute(new Employee());
		return "redirect:/login";
	}
	
}
