package com.metacube.demo.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.metacube.demo.dto.SearchStudentDto;
import com.metacube.demo.dto.StudentDto;
import com.metacube.demo.entity.StudentEntity;
import com.metacube.demo.services.StudentService;
import com.metacube.demo.util.DtoUtil;


@Controller
public class Home {
	
	@Autowired
	private StudentService studentObj;
	
	
	public void getBean(StudentService sobj) {
		this.studentObj = sobj;
	}
	
	
	@Value("${home.message}")
	private String message;

	/**
	 * request come from web server /Home then page redirect is home.jsp
	 * @param model
	 * @return
	 */
	@GetMapping("/home")
	public String getHome(Model model) {
		model.addAttribute("message" ,message);
		return "home";
	}

	/**
	 * when web server request /showStudent then page showStudent.jsp will show
	 * @param model
	 * @return
	 */
	@GetMapping("/showStudent")
	public String displayStudent(Model model) {
		model.addAttribute("studentDetails", studentObj.getAll());
		return "showStudent";
		
	}
	

	/**
	 * when web server signUp page is refect then it return addStudent
	 * @param model
	 * @return
	 */
	@GetMapping("/signUp")
	public String doSignUp(Model model) {
		model.addAttribute("studentCommand", new StudentDto());
		System.out.println("go to add student details");
		return "addStudent";
	}
	
	/**
	 * when user request as post method then this function is called
	 * @param student
	 * @param errorResult
	 * @param model
	 * @return
	 */
	@PostMapping("/signUp")
	public String doSignupByPost(@ModelAttribute("studentCommand") @Validated StudentDto student , BindingResult errorResult , Model model) {
		if(errorResult.hasErrors()) {
			ObjectError oe = new  ObjectError("Email","Fill The Form");
			errorResult.addError(oe);
			return "addStudent";
		} else {

				
//				model.addAttribute("success", "Student Email Exist");
//				return "addStudent";
			try {
			studentObj.insertData(DtoUtil.map(student,StudentEntity.class));
			}
			catch(Exception o) {
				System.out.println("Student Email Exist");
				model.addAttribute("success", "Student Email Exist");
				return "addStudent";
			}
			model.addAttribute("success", "Student Added Successfuly");
			return "addStudent";
		}
	}

	@GetMapping("/searchStudent") 
	public String searchStudentByGet(Model model) {
		model.addAttribute("SearchCommand", new SearchStudentDto());
		return "Search";
	}
	
	
	@PostMapping("/searchStudent") 
	public String searchStudentByPost(@ModelAttribute("SearchCommand") @Validated SearchStudentDto student , BindingResult errorResult , Model model) {
		List<StudentEntity> studentData = studentObj.findByName(student.getFirstName());
		if(studentData.size()>0) {
			System.out.println(studentData.get(0).getEmail());
			model.addAttribute("studentData", studentData);
			return "Search";
		}
		model.addAttribute("success", "No Student  Find");
		return "Search";
	}
}
