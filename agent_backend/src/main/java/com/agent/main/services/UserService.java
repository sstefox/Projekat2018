package com.agent.main.services;

import com.agent.main.entities.User;

public interface UserService {

	public String getAllUsernames();
	
	User findOne(String username);

	User findById(Long id);
	
	void delete(Long id);
}
