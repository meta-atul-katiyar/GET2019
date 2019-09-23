package com.metacube.demo.service;


import java.util.ArrayList;
import java.util.List;

import com.metacube.demo.model.User;

/*
 * Interface of service layer.
 */
public interface IUserService {

	//Method to add student in the database.
	public void addUser(User student);
	
	//Method to get student list from database.
	public List<User> getAllUsers();
	
	ArrayList<User> getUser(String username);
}