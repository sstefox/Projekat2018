package com.booking.dao;

import com.booking.entities.AccommodationCategory;
import org.springframework.data.repository.CrudRepository;

public  interface AccommodationCategoryRepository
  extends CrudRepository<AccommodationCategory, Long>
{}