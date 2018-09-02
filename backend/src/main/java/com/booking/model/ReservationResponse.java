package com.booking.model;

public class ReservationResponse {
	private String fromDate;
	  private String toDate;
	  private String capacity;
	  private String price;
	  private String username;
	  private String accommodationId;
	  private int status;
	  private Long id;
	  
	  public Long getId()
	  {
	    return this.id;
	  }
	  
	  public void setId(Long id)
	  {
	    this.id = id;
	  }
	  
	  public int getStatus()
	  {
	    return this.status;
	  }
	  
	  public void setStatus(int status)
	  {
	    this.status = status;
	  }
	  
	  public String getCapacity()
	  {
	    return this.capacity;
	  }
	  
	  public void setCapacity(String capacity)
	  {
	    this.capacity = capacity;
	  }
	  
	  public String getAccommodationId()
	  {
	    return this.accommodationId;
	  }
	  
	  public void setAccommodationId(String accommodationId)
	  {
	    this.accommodationId = accommodationId;
	  }
	  
	  public String getFromDate()
	  {
	    return this.fromDate;
	  }
	  
	  public void setFromDate(String fromDate)
	  {
	    this.fromDate = fromDate;
	  }
	  
	  public String getToDate()
	  {
	    return this.toDate;
	  }
	  
	  public void setToDate(String toDate)
	  {
	    this.toDate = toDate;
	  }
	  
	  public String getPrice()
	  {
	    return this.price;
	  }
	  
	  public void setPrice(String price)
	  {
	    this.price = price;
	  }
	  
	  public String getUsername()
	  {
	    return this.username;
	  }
	  
	  public void setUsername(String username)
	  {
	    this.username = username;
	  }
}
