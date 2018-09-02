package com.booking.model;

public class AdvanceSearchRequest {

	private String fromDate;
	private String toDate;
	private int capacity;
	private String location;
	private long type;
	private String[] serviceList;
	private String category;
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	

	public long getType() {
		return type;
	}

	public void setType(long type) {
		this.type = type;
	}

	public String[] getServiceList() {
		return serviceList;
	}

	public void setServiceList(String[] serviceList) {
		this.serviceList = serviceList;
	}

	public String getFromDate() {
		return this.fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return this.toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public int getCapacity() {
		return this.capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
