package com.booking.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.booking.model.AdvanceSearchRequest;
import com.booking.model.SearchRequest;
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


@CrossOrigin
public class MainController {

	@Autowired
	private AccommodationService accommodationService;
	@PostMapping({ "/search/searchAccommodation" })
	public ResponseEntity<String> searchAccommodation(@RequestBody SearchRequest searchRequest) {
		ResponseEntity<String> responseEntity = null;
		String result = accommodationService.searchAccommodation(searchRequest);
		responseEntity = new ResponseEntity<String>(result, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping({"/get/getReviewsById/{id}" })
	public ResponseEntity<String> getReviewsById(@PathVariable Long id) {
		String str = accommodationService.getReviewsById(id);
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
	@GetMapping({"/get/getImages/{id}" })
	public ResponseEntity<java.util.List<String>> getImageInfo(@PathVariable Long id) {
		return new ResponseEntity<java.util.List<String>>(accommodationService.getImagesForAccommodation(id), HttpStatus.OK);
	}
	@GetMapping({ "/getImages/{accid}/{id}" })
	public ResponseEntity<String> getImagesForAccommodation(@PathVariable Long accid, @PathVariable Long id)
			throws IOException {
		String strList = accommodationService.getImageForAccommodationAndId(accid, id);
		return new ResponseEntity<String>(strList, HttpStatus.OK);
	}
	
	@PostMapping({ "/search/advanceSearchAccommodation" })
	public ResponseEntity<String> advanceSearchAccommodation(@RequestBody AdvanceSearchRequest advanceSearchRequest) {
		ResponseEntity<String> responseEntity = null;
		String result = accommodationService.advanceSearchAccommodation(advanceSearchRequest);
		responseEntity = new ResponseEntity<String>(result,HttpStatus.OK);
		return responseEntity;
	}
}
