package com.booking.model;

public class SearchRequest {

	private String fromDate;
	private String toDate;
	private int capacity;
	private String location;
	private String[] typeList;
	private String[] serviceList;
	private String category;
	public String[] getTypeList() {
		return typeList;
	}

	public void setTypeList(String[] typeList) {
		this.typeList = typeList;
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
