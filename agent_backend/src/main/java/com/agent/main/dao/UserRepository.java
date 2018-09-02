package com.agent.main.dao;

import org.springframework.data.repository.CrudRepository;

import com.agent.main.entities.User;


public interface UserRepository extends CrudRepository<User,Long>{

	User findUserByUsername(String username);
	
	User findByUsername(String username);
}
