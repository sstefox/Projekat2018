package com.booking.model;

import java.sql.Date;
public class ReviewResponse {
	private Long id;
	  private double rating;
	  private String comment;
	  private String user;
	  private Date entryDate;
	  private int status;
	  private Long accommodationId;
	  private String accommodationTitle;
	  private Long userId;
	  private String entryDateStr;
	  
	  public String getEntryDateStr() {
		return entryDateStr;
	}

	public void setEntryDateStr(String entryDateStr) {
		this.entryDateStr = entryDateStr;
	}

	public Long getAccommodationId()
	  {
	    return this.accommodationId;
	  }
	  
	  public void setAccommodationId(Long accommodationId)
	  {
	    this.accommodationId = accommodationId;
	  }
	  
	  public String getAccommodationTitle()
	  {
	    return this.accommodationTitle;
	  }
	  
	  public void setAccommodationTitle(String accommodationTitle)
	  {
	    this.accommodationTitle = accommodationTitle;
	  }
	  
	  public Long getUserId()
	  {
	    return this.userId;
	  }
	  
	  public void setUserId(Long userId)
	  {
	    this.userId = userId;
	  }
	  
	  public Long getId()
	  {
	    return this.id;
	  }
	  
	  public void setId(Long id)
	  {
	    this.id = id;
	  }
	  
	  public double getRating()
	  {
	    return this.rating;
	  }
	  
	  public void setRating(double rating)
	  {
	    this.rating = rating;
	  }
	  
	  public String getComment()
	  {
	    return this.comment;
	  }
	  
	  public void setComment(String comment)
	  {
	    this.comment = comment;
	  }
	  
	  public String getUser()
	  {
	    return this.user;
	  }
	  
	  public void setUser(String user)
	  {
	    this.user = user;
	  }
	  
	  public Date getEntryDate()
	  {
	    return this.entryDate;
	  }
	  
	  public void setEntryDate(Date entryDate)
	  {
	    this.entryDate = entryDate;
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
