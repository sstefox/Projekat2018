package com.agent.main.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.agent.main.entities.Accommodation;
import com.agent.main.entities.AccommodationImages;


public interface AccommodationImageRepository extends CrudRepository<AccommodationImages, Long>{

	public List<AccommodationImages> findAccommodationImagesByAccommodationId(Accommodation accommodationId);
	
	public AccommodationImages findAccommodationImagesByAccommodationIdAndId(Accommodation accommodationId,Long Id);
}
