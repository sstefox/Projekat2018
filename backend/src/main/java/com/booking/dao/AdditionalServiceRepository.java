package com.booking.dao;


import com.booking.entities.AdditionalServices;
import org.springframework.data.repository.CrudRepository;

public  interface AdditionalServiceRepository
extends CrudRepository<AdditionalServices, Long>
{}