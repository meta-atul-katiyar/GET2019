package com.metacube.SpringMVC.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.SpringMVC.data.ListStudent;
import com.metacube.SpringMVC.model.Student;

/**
 * Controller class.
 */
@Controller
public class StudentController {

	private static final Logger log = LoggerFactory
			.getLogger(StudentController.class);

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
	@GetMapping("/AddStudentDetails")
	public String studentDetail(Model model) {
		model.addAttribute(new Student());
		return "studentForm";
	}

	/**
	 * Method to get data from studentDetailsForm page. show the data on console. 
	 * @param student
	 * @param bindingResult
	 * @return
	 */
	@PostMapping("/AddStudentDetails")
	public String addStudentDetail(@Validated Student student,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "studentForm";
		} else {
			log.info(student.getFirstName());
			log.info(student.getLastName());
			log.info(student.getFatherName());
			log.info(student.getEmail());
			log.info(student.getStudentClass());
			log.info(student.getAge());
			return "redirect:/home";
		}
	}

	/**
	 * Method to mapped showStduent page. Add the student on list om model. 
	 * @param model
	 * @return
	 */
	@GetMapping("/showStudent")
	public ModelAndView  showStudent(Model model) {
		List<Student> students = new ArrayList<Student>();
		students.add(ListStudent.s1);
		students.add(ListStudent.s2);
		students.add(ListStudent.s3);
		students.add(ListStudent.s4);
		model.addAttribute("students", students);
		System.out.println(students);
		return new ModelAndView("showStudent", "students", students);
	
	}
}