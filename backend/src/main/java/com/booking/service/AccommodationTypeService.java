package com.booking.service;

import com.booking.model.AccommodationTypeRequest;

public  interface AccommodationTypeService
{
  public  boolean addNewAccommodationType(AccommodationTypeRequest paramAccommodationTypeRequest);
  
  public  String viewAllAccommodationTypes();
}