package com.booking.controller;


import com.booking.model.AdvanceSearchRequest;
import com.booking.model.MessageRequest;
import com.booking.model.ReservationRequest;
import com.booking.model.SearchRequest;
import com.booking.service.AccommodationService;
import com.booking.service.ReviewsService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "/client" })
@CrossOrigin
public class ClientController {
	@Autowired
	private AccommodationService accommodationService;
	@Autowired
	private ReviewsService reviewService;

	public ClientController() {
	}



	@GetMapping({ "/saveMessage/{message}/{accId}" })
	public ResponseEntity<String> saveUserMessage(@PathVariable String message, @PathVariable Long accId) {
		accommodationService.saveMessageFromUser(message, accId);
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}

	@PostMapping({ "/rateAccommodation/{rating}/{commentVal}/{accId}" })
	public ResponseEntity<String> rateAccommodation(@PathVariable Double rating, @PathVariable String commentVal,
			@PathVariable Long accId) {
		reviewService.saveReview(rating, commentVal, accId);
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}

	@GetMapping({ "/getReviewsById/{id}"})
	public ResponseEntity<String> getReviewsById(@PathVariable Long id) {
		String str = accommodationService.getReviewsById(id);
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}

	@GetMapping({ "/getImages/{id}" })
	public ResponseEntity<java.util.List<String>> getImageInfo(@PathVariable Long id) {
		return new ResponseEntity<java.util.List<String>>(accommodationService.getImagesForAccommodation(id), HttpStatus.OK);
	}

	@GetMapping({ "/getImages/{accid}/{id}" })
	public ResponseEntity<String> getImagesForAccommodation(@PathVariable Long accid, @PathVariable Long id)
			throws IOException {
		String strList = accommodationService.getImageForAccommodationAndId(accid, id);
		return new ResponseEntity<String>(strList, HttpStatus.OK);
	}

	@PostMapping({ "/saveReservation/" })
	public ResponseEntity<String> saveReservation(@RequestBody ReservationRequest reservationRequest) {
		boolean status = accommodationService.saveReservation(reservationRequest);
		if (status) {
			return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("ERROR", HttpStatus.OK);
		}
	}

	@PostMapping({ "/cancelBookings" })
	public ResponseEntity<String> cancelBookings(@RequestBody String[] array) {
		boolean status = accommodationService.deleteReservations(array);
		if (status) {
			return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("ERROR", HttpStatus.OK);
		}
	}

	@PostMapping({ "/sendClientMessage" })
	public ResponseEntity<String> sendClientMessage(@RequestBody MessageRequest message) {
		accommodationService.saveMessage(message);
		String response = accommodationService.getReservationsByUserId();
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	@GetMapping("/getMessagesByUserId")
	public ResponseEntity<String> getMessagesByUserId(){
		String response = accommodationService.getMessagesFromUserId();
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	@GetMapping("/getMessagesToUserId")
	public ResponseEntity<String> getMessagesToUserId(){
		String response = accommodationService.getMessagesToUserId();
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
}