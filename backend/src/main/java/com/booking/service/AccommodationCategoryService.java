package com.booking.service;

import com.booking.model.AccommodationCategoryRequest;

public interface AccommodationCategoryService
{
  public  boolean addNewAccommodationCategory(AccommodationCategoryRequest paramAccommodationCategoryRequest);
  
  public  String viewAllAccommodationCategories();
}