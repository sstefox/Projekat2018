package com.booking.model;

public class AuthToken {

	private String token;
	  
	  public AuthToken() {}
	  
	  public AuthToken(String token)
	  {
	    this.token = token;
	  }
	  
	  public String getToken()
	  {
	    return this.token;
	  }
	  
	  public void setToken(String token)
	  {
	    this.token = token;
	  }
}
