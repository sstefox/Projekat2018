package com.booking.dao;


import com.booking.entities.AccommodationType;
import org.springframework.data.repository.CrudRepository;

public  interface AccommodationTypeRepository
  extends CrudRepository<AccommodationType, Long>
{}