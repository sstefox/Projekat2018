package com.booking.service;

import com.booking.model.AdditionalServicesRequest;

public  interface AdditionalServeService
{
  public  boolean addNewAdditionalService(AdditionalServicesRequest paramAdditionalServicesRequest);
  
  public  String viewAllAdditionalServices();
}