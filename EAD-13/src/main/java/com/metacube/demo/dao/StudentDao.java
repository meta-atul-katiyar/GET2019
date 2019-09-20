package com.metacube.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.metacube.demo.model.Student;
import com.metacube.demo.dao.IStudentDao;

/*
 * Class to implement dao interface method.
 */
@Transactional
@Component
public class StudentDao implements IStudentDao{

	//create object of HibernateTemplate
	@Autowired
	HibernateTemplate sqlHandler;
	
	//Method to add student in the database.
	@Override
	public void addStudnet(Student student) {
		sqlHandler.save(student);	
	}
	
	//Method to get student list from database.
	@Override
	public List<Student> getAllStudent() {
		return sqlHandler.loadAll(Student.class);
	}

}