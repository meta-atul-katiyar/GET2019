package com.metacube.demo.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.demo.model.User;
import com.metacube.demo.dao.IUserDao;
import com.metacube.demo.service.IUserService;

/*
 * Class to implement service layer method.
 */
@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDao dao;
	
	//Method to add student in the database.
	@Override
	public void addUser(User user) {
		dao.addUser(user);
	}
	
	//Method to get student list from database.
	@Override
	public List<User> getAllUsers() {
		return dao.getAllUsers();
	}

	@Override
	public ArrayList<User> getUser(String username) {
		return dao.getUser(username);
	}

}
