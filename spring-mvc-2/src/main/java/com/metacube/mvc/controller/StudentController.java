package com.metacube.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.metacube.mvc.model.Student;

import javax.validation.Valid;

@Controller
public class StudentController {

	@GetMapping("/a")
	public String a() {
		return "studentForm";
	}

//	@GetMapping("/studentForm")
//	public String formGet(Model model) {
//		model.addAttribute("student", new Student());
//		return "studentForm";
//	}
//
//	@PostMapping("/studentForm")
//	public String formPost(@Valid Student student, BindingResult bindingResult, Model model) {
//		if (!bindingResult.hasErrors()) {
//			model.addAttribute("noErrors", true);
//		}
//		model.addAttribute("student", student);
//		return "studentForm";
//	}
}
