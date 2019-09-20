package com.metacube.demo.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.demo.model.Student;
import com.metacube.demo.dao.IStudentDao;
import com.metacube.demo.service.IStudentService;

/*
 * Class to implement servics layer method.
 */
@Service
public class StudentService implements IStudentService {

	@Autowired
	private IStudentDao dao;
	
	//Method to add student in the database.
	@Override
	public void addStudnet(Student student) {
		dao.addStudnet(student);
	}
	
	//Method to get student list from database.
	@Override
	public List<Student> getAllStudent() {
		return dao.getAllStudent();
	}

}
