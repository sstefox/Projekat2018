package com.booking.service.impl;

import com.booking.dao.AccommodationTypeRepository;
import com.booking.entities.AccommodationType;
import com.booking.model.AccommodationTypeRequest;
import com.booking.service.AccommodationTypeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccommodationTypeServiceImpl implements AccommodationTypeService
{
  Logger logger = LoggerFactory.getLogger(AccommodationTypeServiceImpl.class);
  
  public AccommodationTypeServiceImpl() {}
  
  public boolean addNewAccommodationType(AccommodationTypeRequest accommodationTypeReqeuest) {
    boolean result = false;
    try {
      AccommodationType accommodationType = new AccommodationType();
      accommodationType.setTypeName(accommodationTypeReqeuest.getAccommodationTypeName());
      accommodationTypeRepository.save(accommodationType);
    } catch (Exception ex) {
      logger.error("Exception while adding new accommodationType", ex); }
    return result; }
  
  @Autowired
  private AccommodationTypeRepository accommodationTypeRepository;
  public String viewAllAccommodationTypes() { String accommodationTypes = null;
    try {
      List<AccommodationType> accommodationTypeList = (List)accommodationTypeRepository.findAll();
      ObjectMapper mapper = new ObjectMapper();
      accommodationTypes = mapper.writeValueAsString(accommodationTypeList);
    } catch (Exception ex) {
      logger.error("Exception while fetching accommodation types", ex);
    }
    return accommodationTypes;
  }
}
 
