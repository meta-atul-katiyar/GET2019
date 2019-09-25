package com.metacube.demo.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Example;

import com.metacube.demo.dto.UserDto;
import com.metacube.demo.model.User;

/*
 * Interface of service layer.
 */
public interface IUserService {

	//Method to add student in the database.
	public void addUser(User user);
	
	//Method to get student list from database.
	public Iterable<User> getAllUsers();
	
	List<User> findByUserName(String username);
}