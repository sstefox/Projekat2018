package com.agent.main.services.impl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.agent.main.dao.UserRepository;
import com.agent.main.entities.User;
import com.agent.main.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService,UserService{
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserRepository userRepository;
	@Override
	public String getAllUsernames() {
		String usernames =null;
		try {
			List<User> userList = (List<User>) userRepository.findAll();
			List<String> str = new ArrayList<String>();
			for(User usr:userList) {
				str.add(usr.getUsername());
			}
			ObjectMapper mapper = new ObjectMapper();
			usernames = mapper.writeValueAsString(str);
		}catch(Exception ex) {
			logger.error("Exception while fetching usernames",ex);
		}
		return usernames;
	}
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		User user = userRepository.findUserByUsername(userId);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
	}

	private List<SimpleGrantedAuthority> getAuthority(User user) {
		int role = user.getRole();
		String roleStr = "";
		if(role==1) {
			roleStr = "ROLE_ADMIN";
		}else if(role==2) {
			roleStr = "ROLE_AGENT";
		}else if(role==3){
			roleStr = "ROLE_USER";
		}
		return Arrays.asList(new SimpleGrantedAuthority(roleStr));
	}
	
	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public User findOne(String username) {
		return userRepository.findByUsername(username);
	}
	@Override
	public User findById(Long id) {
		return userRepository.findById(id).get();
	}
	
}
