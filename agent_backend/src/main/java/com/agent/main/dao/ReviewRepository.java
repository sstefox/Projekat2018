package com.agent.main.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.agent.main.entities.Accommodation;
import com.agent.main.entities.Reviews;

public interface ReviewRepository  extends CrudRepository<Reviews,Long> {

	List<Reviews> findReviewsByAccommodation(Accommodation accommodation);
}
