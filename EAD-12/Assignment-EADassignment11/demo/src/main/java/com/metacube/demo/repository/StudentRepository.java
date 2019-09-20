package com.metacube.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.metacube.demo.entity.StudentEntity;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {

	public List<StudentEntity> findByFirstNameContainingIgnoreCase(String name);
}
