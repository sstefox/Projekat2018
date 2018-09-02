package com.agent.model;

import java.sql.Date;

import com.agent.main.entities.Accommodation;

public class MessageResponse {

	private Long id;
	private String fromname;
	private String message;
	private String toname;
	private String entryDate;
	private String accommodationUser;
	private Long accId;
	private int status;
	
	
	public Long getAccId() {
		return accId;
	}
	public void setAccId(Long accId) {
		this.accId = accId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFromname() {
		return fromname;
	}
	public void setFromname(String fromname) {
		this.fromname = fromname;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getToname() {
		return toname;
	}
	public void setToname(String toname) {
		this.toname = toname;
	}
	
	public String getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}
	public String getAccommodationUser() {
		return accommodationUser;
	}
	public void setAccommodationUser(String accommodationUser) {
		this.accommodationUser = accommodationUser;
	}
	
}
