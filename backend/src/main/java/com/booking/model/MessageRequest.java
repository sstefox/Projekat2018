package com.booking.model;

public class MessageRequest {
	private Long fromUser;
	  private Long toUser;
	  private String date;
	  private Long accommodationId;
	  private String message;
	  private String accommodation;
	  private String sentBy;
	  private String sentTo;
	  
	  public String getAccommodation() {
		return accommodation;
	}

	public void setAccommodation(String accommodation) {
		this.accommodation = accommodation;
	}

	public String getSentBy() {
		return sentBy;
	}

	public void setSentBy(String sentBy) {
		this.sentBy = sentBy;
	}

	public String getSentTo() {
		return sentTo;
	}

	public void setSentTo(String sentTo) {
		this.sentTo = sentTo;
	}

	public Long getFromUser()
	  {
	    return this.fromUser;
	  }
	  
	  public void setFromUser(Long fromUser)
	  {
	    this.fromUser = fromUser;
	  }
	  
	  public Long getToUser()
	  {
	    return this.toUser;
	  }
	  
	  public void setToUser(Long toUser)
	  {
	    this.toUser = toUser;
	  }
	  
	  public String getDate()
	  {
	    return this.date;
	  }
	  
	  public void setDate(String date)
	  {
	    this.date = date;
	  }
	  
	  public Long getAccommodationId()
	  {
	    return this.accommodationId;
	  }
	  
	  public void setAccommodationId(Long accommodationId)
	  {
	    this.accommodationId = accommodationId;
	  }
	  
	  public String getMessage()
	  {
	    return this.message;
	  }
	  
	  public void setMessage(String message)
	  {
	    this.message = message;
	  }
}
