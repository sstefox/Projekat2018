package com.booking.service;


import com.booking.entities.User;
import com.booking.model.UserRequest;
import java.util.HashMap;
import java.util.List;

public  interface UserService
{
  public  User save(User paramUser);
  
  public  List<User> findAll();
  
  public  void delete(Long paramLong);
  
  public  User findOne(String paramString);
  
  public  User findById(Long paramLong);
  
  public  String addNewUser(UserRequest paramUserRequest, int role);
  
  public  String viewAllUsers();
  
  public  boolean updateUserStatus(HashMap<String, String> paramHashMap);
  
  public  String forgetPassword(UserRequest paramUserRequest);
}