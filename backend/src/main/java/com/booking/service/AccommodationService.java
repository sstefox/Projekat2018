package com.booking.service;

import com.booking.model.AdvanceSearchRequest;
import com.booking.model.MessageRequest;
import com.booking.model.ReservationRequest;
import com.booking.model.SearchRequest;
import java.util.List;

public interface AccommodationService {
	public String viewAllAccommodations();

	public boolean updateAccommodationStatus(String paramString);

	public String searchAccommodation(SearchRequest paramSearchRequest);

	public String advanceSearchAccommodation(AdvanceSearchRequest advanceSearchRequest);

	public String getReviewsById(Long paramLong);

	public String getAccommodationById(Long paramLong);

	public List<String> getImagesForAccommodation(Long paramLong);

	public String getImageForAccommodationAndId(Long paramLong1, Long paramLong2);

	public boolean saveReservation(ReservationRequest paramReservationRequest);

	public String getReservationsByUserId();

	public boolean deleteReservations(String[] paramArrayOfString);

	public boolean saveMessage(MessageRequest paramMessageRequest);

	public String viewAllAccommodationsDummy();

	public boolean saveMessageFromUser(String paramString, Long paramLong);

	public String getMessagesToUserId();

	public String getMessagesFromUserId();
}
