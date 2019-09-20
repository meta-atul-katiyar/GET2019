package com.metacube.demo.service;


import java.util.List;

import com.metacube.demo.model.Student;

/*
 * Interface of service layer.
 */
public interface IStudentService {

	//Method to add student in the database.
	public void addStudnet(Student student);
	
	//Method to get student list from database.
	public List<Student> getAllStudent();
	
}