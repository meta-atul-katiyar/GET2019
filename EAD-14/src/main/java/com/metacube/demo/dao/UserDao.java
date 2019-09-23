package com.metacube.demo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.metacube.demo.model.User;

/*
 * Class to implement dao interface method.
 */
@Transactional
@Component
public class UserDao implements IUserDao{

	//create object of HibernateTemplate
	@Autowired
	HibernateTemplate sqlHandler;
	public static ModelMapper mapper;
	
	//Method to add student in the database.
	@Override
	public void addUser(User user) {
		sqlHandler.save(user);	
	}
	
	//Method to get student list from database.
	@Override
	public List<User> getAllUsers() {
		return sqlHandler.loadAll(User.class);
	}

	@Override
	public ArrayList<User> getUser(String username) {
		
		User user1 = new User(null,null,null,null,null,null,null);
		user1.setUsername(username);
		System.out.println("userDao: "+username+user1.getUsername()+"--");
		ArrayList<User> user = (ArrayList<User>) sqlHandler.findByExample(user1);
		
		return user;
	}
}