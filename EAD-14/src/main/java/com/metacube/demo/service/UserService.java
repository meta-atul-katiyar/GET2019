package com.metacube.demo.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.metacube.demo.model.User;
import com.metacube.demo.repository.UserRepository;

import com.metacube.demo.dto.UserDto;
import com.metacube.demo.service.IUserService;

/*
 * Class to implement service layer method.
 */
@Service
public class UserService implements IUserService {

	@Autowired
	UserRepository userRepoObj;
	
	//Method to add student in the database.
	@Override
	public void addUser(User user) {
		userRepoObj.save(user);
	}
	
	//Method to get student list from database.
	@Override
	public Iterable<User> getAllUsers() {
		return userRepoObj.findAll();
	}

	@Override
	public List<User> findByUserName(String username) {
		return userRepoObj.findByusername(username);
	}

}
