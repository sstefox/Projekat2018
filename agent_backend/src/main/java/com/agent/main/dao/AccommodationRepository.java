package com.agent.main.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.agent.main.entities.Accommodation;


public interface AccommodationRepository extends CrudRepository<Accommodation, Long>{

	public Accommodation findAccommodationById(Long id);
	
	public List<Accommodation> findAccommodationByUsername(String username);
	
}
