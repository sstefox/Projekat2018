package com.booking.dao;

import com.booking.entities.Accommodation;
import com.booking.entities.AccommodationImages;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public  interface AccommodationImageRepository
  extends CrudRepository<AccommodationImages, Long>
{
  public  List<AccommodationImages> findAccommodationImagesByAccommodationId(Accommodation paramAccommodation);
  
  public  AccommodationImages findAccommodationImagesByAccommodationIdAndId(Accommodation paramAccommodation, Long paramLong);
}