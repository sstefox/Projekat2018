package com.booking.model;

import java.util.List;

public class AccommodationResponse {

	 private Long id;
	  private String location;
	  private String description;
	  private int capacity;
	  private String type;
	  private double price;
	  private int status;
	  private String username;
	  private List<String> services;
	  private String title;
	  private Double rating;
	  private String category;
	  
	  public Long getId()
	  {
	    return this.id;
	  }
	  
	  public void setId(Long id)
	  {
	    this.id = id;
	  }
	  
	  public String getLocation()
	  {
	    return this.location;
	  }
	  
	  public void setLocation(String location)
	  {
	    this.location = location;
	  }
	  
	  public String getDescription()
	  {
	    return this.description;
	  }
	  
	  public void setDescription(String description)
	  {
	    this.description = description;
	  }
	  
	  public int getCapacity()
	  {
	    return this.capacity;
	  }
	  
	  public void setCapacity(int capacity)
	  {
	    this.capacity = capacity;
	  }
	  
	  public String getType()
	  {
	    return this.type;
	  }
	  
	  public void setType(String type)
	  {
	    this.type = type;
	  }
	  
	  public double getPrice()
	  {
	    return this.price;
	  }
	  
	  public void setPrice(double price)
	  {
	    this.price = price;
	  }
	  
	  public int getStatus()
	  {
	    return this.status;
	  }
	  
	  public void setStatus(int status)
	  {
	    this.status = status;
	  }
	  
	  public String getUsername()
	  {
	    return this.username;
	  }
	  
	  public void setUsername(String username)
	  {
	    this.username = username;
	  }
	  
	  public List<String> getServices()
	  {
	    return this.services;
	  }
	  
	  public void setServices(List<String> services)
	  {
	    this.services = services;
	  }
	  
	  public String getTitle()
	  {
	    return this.title;
	  }
	  
	  public void setTitle(String title)
	  {
	    this.title = title;
	  }
	  
	  public Double getRating()
	  {
	    return this.rating;
	  }
	  
	  public void setRating(Double rating)
	  {
	    this.rating = rating;
	  }
	  
	  public String getCategory()
	  {
	    return this.category;
	  }
	  
	  public void setCategory(String category)
	  {
	    this.category = category;
	  }
}
