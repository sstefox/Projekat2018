package com.agent.main.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import javax.transaction.Transactional;

import com.agent.main.entities.Accommodation;
import com.agent.main.entities.Reservations;

public interface ReservationRepository extends CrudRepository<Reservations,Long>{

	List<Reservations> findAllByAccommodationId(Accommodation accommodationId);
	@Modifying
	@Query("update Reservations a set a.status=1 where a.id=?1")
	@Transactional
	void updateStatusById(Long id);
}
