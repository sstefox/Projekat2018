package com.booking.model;

public class ReservationRequest {
	private String fromDate;
	  private String toDate;
	  private double capacity;
	  private double price;
	  private Long accommodationId;
	  
	  public Long getAccommodationId()
	  {
	    return this.accommodationId;
	  }
	  
	  public void setAccommodationId(Long accommodationId)
	  {
	    this.accommodationId = accommodationId;
	  }
	  
	  public double getPrice()
	  {
	    return this.price;
	  }
	  
	  public void setPrice(double price)
	  {
	    this.price = price;
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
	  
	  public double getCapacity()
	  {
	    return this.capacity;
	  }
	  
	  public void setCapacity(double capacity)
	  {
	    this.capacity = capacity;
	  }
}
