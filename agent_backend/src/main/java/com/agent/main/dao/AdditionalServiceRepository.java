package com.agent.main.dao;

import org.springframework.data.repository.CrudRepository;

import com.agent.main.entities.AdditionalServices;


public interface AdditionalServiceRepository extends CrudRepository<AdditionalServices,Long> {

	AdditionalServices findAdditionalServicesByServiceName(String serviceName);
}
