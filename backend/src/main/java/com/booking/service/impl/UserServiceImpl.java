package com.booking.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.booking.dao.UserRepository;
import com.booking.entities.User;
import com.booking.model.UserRequest;
import com.booking.service.UserService;
import com.booking.utils.Utils;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("userService")
public class UserServiceImpl implements UserDetailsService,UserService{
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserRepository userRepository;
	@Autowired
	BCryptPasswordEncoder encoder;

	@Override
	public User save(User paramUser) {
		return userRepository.save(paramUser);
	}
	@Override
	public List<User> findAll() {	
		return (List<User>) userRepository.findAll();
	}
	@Override
	public void delete(Long paramLong) {
		userRepository.deleteById(paramLong);
	}
	@Override
	public User findOne(String paramString) {
		return userRepository.findByUsername(paramString);
	}
	@Override
	public User findById(Long paramLong) {
		return userRepository.findById(paramLong).get();
	}
	@Override
	public String addNewUser(UserRequest userRequest, int role) {
		String status = "ERROR";
		try {
			User user = new User();
			user.setAddress(userRequest.getAddress());
			user.setbNumber(userRequest.getbNumber());
			user.setEmail(userRequest.getEmail());
			user.setFirstName(userRequest.getFirstName());
			user.setLastName(userRequest.getLastName());
			user.setPhoneNumber(userRequest.getPhoneNumber());
			user.setRole(role);
			user.setStatus(0);
			user.setUsername(userRequest.getEmail());
			String otpwd =encoder.encode(userRequest.getPassword()); 
			user.setPassword(otpwd);
			userRepository.save(user);
			status = "SUCCESS";
		}catch(Exception ex) {
			logger.error("Error while adding new user {}",ex);
		}
		return status;
	}
	@Override
	public String viewAllUsers() {
		String jsonArray = "";
		try {
			List<UserRequest> userReq = new ArrayList<UserRequest>();
			List<User> userList = (List<User>) userRepository.findAll();
			for(User user:userList) {
				UserRequest req = new UserRequest();
				req.setAddress(user.getAddress());
				req.setbNumber(user.getbNumber());
				req.setEmail(user.getEmail());
				req.setFirstName(user.getFirstName());
				req.setId(user.getId());
				req.setLastName(user.getLastName());
				req.setPassword(user.getPassword());
				req.setPhoneNumber(user.getPhoneNumber());
				req.setRole(user.getRole());
				req.setStatus(user.getStatus());
				req.setUsername(user.getUsername());
				userReq.add(req);
			}
			ObjectMapper mapper = new ObjectMapper();
			jsonArray = mapper.writeValueAsString(userReq);
		}catch(Exception ex) {
			logger.error("Error while adding new user {}",ex);
		}
		return jsonArray;
	}
	@Override
	public boolean updateUserStatus(HashMap<String, String> paramHashMap) {
		boolean status = false;
		try {
			Set<String> keys = paramHashMap.keySet();
			for(String stats:keys) {
				String val = paramHashMap.get(stats);
				userRepository.updateStatusByUserId(Integer.parseInt(val), Long.parseLong(stats));
			}
			status= true;
		}catch(Exception ex) {
			logger.error("Error while adding new user {}",ex);
		}
		return status;
	}

	@Override
	public String forgetPassword(UserRequest paramUserRequest) {
		String status = "ERROR";
		try {
			userRepository.updatePasswordByUsername(paramUserRequest.getUsername(), encoder.encode(paramUserRequest.getPassword()));
			status = "SUCCESS";
		}catch(Exception ex) {
			logger.error("Error while adding new user {}",ex);
		}
		return status;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsernameAndStatus(username,1);
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
}
