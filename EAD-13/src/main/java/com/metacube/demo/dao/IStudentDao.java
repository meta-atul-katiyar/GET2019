package com.metacube.demo.dao;


import java.util.List;

import com.metacube.demo.model.Student;

/*
 * Interface of Dao layer.
 */
public interface IStudentDao {

	//Method to add student in the database.
	public void addStudnet(Student student);
	
	//Method to get student list from database.
	public List<Student> getAllStudent();
}