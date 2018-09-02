package com.booking.model;

public class AccommodationTypeRequest {

	private Long id;
	  private String accommodationTypeName;
	  
	  public Long getId()
	  {
	    return this.id;
	  }
	  
	  public void setId(Long id)
	  {
	    this.id = id;
	  }
	  
	  public String getAccommodationTypeName()
	  {
	    return this.accommodationTypeName;
	  }
	  
	  public void setAccommodationTypeName(String accommodationTypeName)
	  {
	    this.accommodationTypeName = accommodationTypeName;
	  }
}
