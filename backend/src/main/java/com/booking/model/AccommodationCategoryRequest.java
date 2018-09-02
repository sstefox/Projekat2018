package com.booking.model;

public class AccommodationCategoryRequest {

	private Long id;
	  private String accommodationCategoryName;
	  
	  public Long getId()
	  {
	    return this.id;
	  }
	  
	  public void setId(Long id)
	  {
	    this.id = id;
	  }
	  
	  public String getAccommodationCategoryName()
	  {
	    return this.accommodationCategoryName;
	  }
	  
	  public void setAccommodationCategoryName(String accommodationCategoryName)
	  {
	    this.accommodationCategoryName = accommodationCategoryName;
	  }
}
