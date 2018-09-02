package com.agent.main.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.agent.model.AccommodationRequest;
import com.agent.model.ReservationRequest;

public interface AccommodationService {

	public String viewAllAdditionalServices();
	
	public String viewAllAccommodationTypes();
	
	public boolean saveNewAccommodation(AccommodationRequest accommodationRequest);
	
	public String viewAllAccommodations();
	
	public boolean saveAccommodationImages(List<MultipartFile> files,int accommodation);
	
	public List<String> getImagesForAccommodation(Long id);

	String getImageForAccommodationAndId(Long accId, Long id);

	public boolean saveReservation(ReservationRequest reservationRequest);
	
	public String getAccommodationById(Long id);
	
	public String getReviewsById(Long id);
	
	public String getAllReservationsById(Long id);
	
	public boolean updateReservationStatus(String[] array);
	
	public String getMessagesForCurrentUser();
	
	public boolean saveMessages(String data,String id,Long accId,Long msgId);
	
}


