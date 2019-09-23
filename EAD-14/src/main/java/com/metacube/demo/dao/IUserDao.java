package com.metacube.demo.dao;


import java.util.ArrayList;
import java.util.List;

import com.metacube.demo.model.User;

/*
 * Interface of Dao layer.
 */
public interface IUserDao {

	//Method to add student in the database.
	public void addUser(User user);
	
	//Method to get student list from database.
	public List<User> getAllUsers();


	ArrayList<User> getUser(String username);
}