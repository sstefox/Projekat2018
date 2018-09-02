package com.booking.model;

public class UserRequest {
	private Long id;
	  private String firstName;
	  private String lastName;
	  private String email;
	  private String phoneNumber;
	  private String address;
	  private int role;
	  private String bNumber;
	  private String username;
	  private int status;
	  private String password;
	  
	  public String getPassword()
	  {
	    return this.password;
	  }
	  
	  public void setPassword(String password)
	  {
	    this.password = password;
	  }
	  
	  public Long getId()
	  {
	    return this.id;
	  }
	  
	  public void setId(Long id)
	  {
	    this.id = id;
	  }
	  
	  public String getFirstName()
	  {
	    return this.firstName;
	  }
	  
	  public void setFirstName(String firstName)
	  {
	    this.firstName = firstName;
	  }
	  
	  public String getLastName()
	  {
	    return this.lastName;
	  }
	  
	  public void setLastName(String lastName)
	  {
	    this.lastName = lastName;
	  }
	  
	  public String getEmail()
	  {
	    return this.email;
	  }
	  
	  public void setEmail(String email)
	  {
	    this.email = email;
	  }
	  
	  public String getPhoneNumber()
	  {
	    return this.phoneNumber;
	  }
	  
	  public void setPhoneNumber(String phoneNumber)
	  {
	    this.phoneNumber = phoneNumber;
	  }
	  
	  public String getAddress()
	  {
	    return this.address;
	  }
	  
	  public void setAddress(String address)
	  {
	    this.address = address;
	  }
	  
	  public int getRole()
	  {
	    return this.role;
	  }
	  
	  public void setRole(int role)
	  {
	    this.role = role;
	  }
	  
	  public String getbNumber()
	  {
	    return this.bNumber;
	  }
	  
	  public void setbNumber(String bNumber)
	  {
	    this.bNumber = bNumber;
	  }
	  
	  public String getUsername()
	  {
	    return this.username;
	  }
	  
	  public void setUsername(String username)
	  {
	    this.username = username;
	  }
	  
	  public int getStatus()
	  {
	    return this.status;
	  }
	  
	  public void setStatus(int status)
	  {
	    this.status = status;
	  }

}
