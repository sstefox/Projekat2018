package com.agent.model;

public class ReservationRequest {

	private String fromDate;
	private String toDate;
	private String capacity;
	private String price;
	private String username;
	private String accommodationId;
	
	
	
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public String getAccommodationId() {
		return accommodationId;
	}
	public void setAccommodationId(String accommodationId) {
		this.accommodationId = accommodationId;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
