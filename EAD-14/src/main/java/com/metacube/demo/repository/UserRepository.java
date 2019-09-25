package com.metacube.demo.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.metacube.demo.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	public List<User> findByusername(String username);
}