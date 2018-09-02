package com.booking.controller;

import com.booking.model.AccommodationCategoryRequest;
import com.booking.model.AccommodationTypeRequest;
import com.booking.model.AdditionalServicesRequest;
import com.booking.model.UserRequest;
import com.booking.service.AccommodationCategoryService;
import com.booking.service.AccommodationService;
import com.booking.service.AccommodationTypeService;
import com.booking.service.AdditionalServeService;
import com.booking.service.ReviewsService;
import com.booking.service.UserService;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.booking.config.JwtTokenUtil;
import com.booking.entities.User;
import com.booking.model.AuthToken;
import com.booking.model.LoginUser;
import com.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/token"})
@CrossOrigin
public class AuthenticationController
{
  @Autowired
  private AuthenticationManager authenticationManager;
  @Autowired
  private JwtTokenUtil jwtTokenUtil;
  @Autowired
  private UserService userService;
  
  
	@PostMapping({ "/register" })
	public ResponseEntity<String> registerNewUser(@RequestBody UserRequest userRequest) {
		ResponseEntity<String> responseEntity = null;
		String status = userService.addNewUser(userRequest, 0);
		responseEntity = new ResponseEntity<String>(status, HttpStatus.OK);
		return responseEntity;
	}

  
  @PostMapping({ "/forgetPassword" })
	public ResponseEntity<String> forgetPassword(@RequestBody UserRequest userRequest) {
		ResponseEntity<String> responseEntity = null;
		String response = userService.forgetPassword(userRequest);
		responseEntity = new ResponseEntity<String>(response, HttpStatus.OK);
		return responseEntity;
	}
  
  @RequestMapping(value={"/generate-token"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ResponseEntity<?> register(@RequestBody LoginUser loginUser)
    throws AuthenticationException
  {
    Authentication authentication = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser
    
      .getUsername(), loginUser
      .getPassword()));
    
    SecurityContextHolder.getContext().setAuthentication(authentication);
    User user = this.userService.findOne(loginUser.getUsername());
    if (user != null)
    {
      String token = this.jwtTokenUtil.generateToken(user);
      return ResponseEntity.ok(new AuthToken(token));
    }
    return new ResponseEntity<String>("User Not Found", HttpStatus.NOT_FOUND);
  }
}
