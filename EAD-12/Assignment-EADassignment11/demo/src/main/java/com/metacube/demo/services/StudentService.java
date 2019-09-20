package com.metacube.demo.services;


import java.util.List;

import org.springframework.stereotype.Service;
import com.metacube.demo.entity.StudentEntity;


@Service
public interface StudentService {

	void insertData(StudentEntity sObj);

	public Iterable<StudentEntity> getAll();

	List<StudentEntity> findByName(String name);


}
