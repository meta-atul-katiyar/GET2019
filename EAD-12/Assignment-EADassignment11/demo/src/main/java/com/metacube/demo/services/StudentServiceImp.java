package com.metacube.demo.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.demo.entity.StudentEntity;
import com.metacube.demo.repository.StudentRepository;

@Service
public class StudentServiceImp implements StudentService{
	
	@Autowired
	StudentRepository studentRepoObj;
	
	
	@Override
	public void insertData(StudentEntity sObj) {
		studentRepoObj.save(sObj);
		
	}
	@Override
	public Iterable<StudentEntity> getAll() {
		return studentRepoObj.findAll();
	}
	@Override
	public List<StudentEntity> findByName(String name) {
		return studentRepoObj.findByFirstNameContainingIgnoreCase(name);
	}
	



}
