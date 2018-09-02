package com.booking.service.impl;

import com.booking.dao.AccommodationCategoryRepository;
import com.booking.entities.AccommodationCategory;
import com.booking.model.AccommodationCategoryRequest;
import com.booking.service.AccommodationCategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccommodationCategoryServiceImpl
  implements AccommodationCategoryService
{
  Logger logger = LoggerFactory.getLogger(AccommodationCategoryServiceImpl.class);
  
  public AccommodationCategoryServiceImpl() {}
  
  public boolean addNewAccommodationCategory(AccommodationCategoryRequest accommodationCategoryRequest) {
    boolean result = false;
    try {
      AccommodationCategory accommodationCategory = new AccommodationCategory();
      accommodationCategory.setCategoryName(accommodationCategoryRequest.getAccommodationCategoryName());
      accommodationCategoryRepository.save(accommodationCategory);
      result = true;
    } catch (Exception ex) {
      logger.error("Exception while adding accommodationCategory", ex);
    }
    return result; }
  @Autowired
  
  private AccommodationCategoryRepository accommodationCategoryRepository;
  public String viewAllAccommodationCategories() { String accommodationCategories = null;
    try {
      List<AccommodationCategory> accommodationCategoryList = (List)accommodationCategoryRepository.findAll();
      ObjectMapper mapper = new ObjectMapper();
      accommodationCategories = mapper.writeValueAsString(accommodationCategoryList);
    } catch (Exception ex) {
      logger.error("Exception while fetching all accommodationCategory", ex);
    }
    return accommodationCategories;
  }
}