package com.booking.service.impl;

import com.booking.dao.AdditionalServiceRepository;
import com.booking.entities.AdditionalServices;
import com.booking.model.AdditionalServicesRequest;
import com.booking.service.AdditionalServeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdditionalServeServiceImpl
  implements AdditionalServeService
{
  Logger logger = LoggerFactory.getLogger(AdditionalServeService.class);
  @Autowired
  private AdditionalServiceRepository additionalServiceRepository;
  
  public AdditionalServeServiceImpl() {}
  
  public boolean addNewAdditionalService(AdditionalServicesRequest additionalServiceRequest) { boolean result = false;
    try {
      AdditionalServices additionalService = new AdditionalServices();
      additionalService.setServiceName(additionalServiceRequest.getServiceName());
      additionalServiceRepository.save(additionalService);
      result = true;
    } catch (Exception ex) {
      logger.error("Exception while adding new service", ex); }
    return result;
  }
  
  public String viewAllAdditionalServices()
  {
    String jsonArray = null;
    try {
      List<AdditionalServices> additionalServicesList = (List)additionalServiceRepository.findAll();
      ObjectMapper mapper = new ObjectMapper();
      jsonArray = mapper.writeValueAsString(additionalServicesList);
    } catch (Exception ex) {
      logger.error("Exception while fetching all service", ex);
    }
    return jsonArray;
  }
}
