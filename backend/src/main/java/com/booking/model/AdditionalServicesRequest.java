package com.booking.model;

public class AdditionalServicesRequest {


	  private Long id;
	  private String serviceName;
	  
	  public Long getId()
	  {
	    return this.id;
	  }
	  
	  public void setId(Long id)
	  {
	    this.id = id;
	  }
	  
	  public String getServiceName()
	  {
	    return this.serviceName;
	  }
	  
	  public void setServiceName(String serviceName)
	  {
	    this.serviceName = serviceName;
	  }
}
