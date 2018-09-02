package com.booking.controller;

import com.booking.model.AccommodationCategoryRequest;
import com.booking.model.AccommodationTypeRequest;
import com.booking.model.AdditionalServicesRequest;
import com.booking.model.UserRequest;
import com.booking.service.AccommodationCategoryService;
import com.booking.service.AccommodationService;
import com.booking.service.AccommodationTypeService;
import com.booking.service.AdditionalServeService;
import com.booking.service.ReviewsService;
import com.booking.service.UserService;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AdminController {
	@Autowired
	private AdditionalServeService additionalServeService;
	@Autowired
	private AccommodationTypeService accommodationTypeService;
	@Autowired
	private AccommodationCategoryService accommodationCategoryService;
	@Autowired
	private AccommodationService accommodationService;
	@Autowired
	private ReviewsService reviewsService;
	@Autowired
	private UserService userService;

	public AdminController() {
	}

	@PostMapping({ "/admin/addNewAdditionalService" })
	public ResponseEntity<String> addNewAdditionalService(
			@RequestBody AdditionalServicesRequest additionalServiceRequest) {
		ResponseEntity<String> responseEntity = null;
		if (additionalServeService.addNewAdditionalService(additionalServiceRequest)) {
			responseEntity = new ResponseEntity<String>(HttpStatus.OK);
		}
		return responseEntity;
	}

	

	@GetMapping({ "/admin/viewAllAdditionalServices", "/get/viewAllAdditionalServices" })
	public ResponseEntity<String> viewAllAdditionalServices() {
		String jsonArray = additionalServeService.viewAllAdditionalServices();
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(jsonArray, HttpStatus.OK);
		return responseEntity;
	}

	@PostMapping({ "/admin/addNewAccommodationType" })
	public ResponseEntity<String> addNewAccommodationType(
			@RequestBody AccommodationTypeRequest accommodationTypeRequest) {
		ResponseEntity<String> responseEntity = null;
		if (accommodationTypeService.addNewAccommodationType(accommodationTypeRequest)) {
			responseEntity = new ResponseEntity<String>(HttpStatus.OK);
		}
		return responseEntity;
	}

	@GetMapping({ "/admin/viewAllAccommodationTypes", "/get/viewAllAccommodationTypes" })
	public ResponseEntity<String> viewAllAccommodationTypes() {
		String jsonArray = accommodationTypeService.viewAllAccommodationTypes();
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(jsonArray, HttpStatus.OK);
		return responseEntity;
	}

	@PostMapping({ "/admin/addNewAccommodationCategory" })
	public ResponseEntity<String> addNewAccommodationCategory(
			@RequestBody AccommodationCategoryRequest accommodationCategoryRequest) {
		ResponseEntity<String> responseEntity = null;
		if (accommodationCategoryService.addNewAccommodationCategory(accommodationCategoryRequest)) {
			responseEntity = new ResponseEntity<String>(HttpStatus.OK);
		}
		return responseEntity;
	}

	@GetMapping({ "/admin/viewAllAccommodationCategories", "/get/viewAllAccommodationCategories" })
	public ResponseEntity<String> viewAllAccommodationCategories() {
		String jsonArray = accommodationCategoryService.viewAllAccommodationCategories();
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(jsonArray, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping({ "/admin/viewAllAccommodations" })
	public ResponseEntity<String> viewAllAccommodations() {
		String jsonArray = accommodationService.viewAllAccommodations();
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(jsonArray, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping({  "/get/viewAllAccommodations" })
	public ResponseEntity<String> viewAllDummyAccommodations() {
		String jsonArray = accommodationService.viewAllAccommodationsDummy();
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(jsonArray, HttpStatus.OK);
		return responseEntity;
	}

	@PostMapping({ "/admin/addNewUser" })
	public ResponseEntity<String> addNewUser(@RequestBody UserRequest userRequest) {
		ResponseEntity<String> responseEntity = null;
		String status = userService.addNewUser(userRequest, 0);
		responseEntity = new ResponseEntity<String>(status, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping({ "/admin/viewAllUsers" })
	public ResponseEntity<String> viewAllUsers() {
		String jsonArray = userService.viewAllUsers();
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(jsonArray, HttpStatus.OK);
		return responseEntity;
	}

	@PostMapping({ "/admin/updateAccommodationStatus" })
	public ResponseEntity<String> updateAccommodationStatus(@RequestBody String array) {
		boolean status = accommodationService.updateAccommodationStatus(array);
		ResponseEntity<String> responseEntity = null;
		if (status) {
			responseEntity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<String>("ERROR", HttpStatus.OK);
		}
		return responseEntity;
	}

	@GetMapping({ "/admin/viewAllComments" })
	public ResponseEntity<String> getReviews() {
		String str = reviewsService.getAllReviews();
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}

	@PostMapping({ "/admin/updateCommentStatus" })
	public ResponseEntity<String> updateCommentStatus(@RequestBody String[] array) {
		reviewsService.updateReviewStatus(array);
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}

	@PostMapping({ "/admin/updateUserStatus" })
	public ResponseEntity<String> updateUserStatus(@RequestBody HashMap<String, String> hashMap) {
		userService.updateUserStatus(hashMap);
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}

	@GetMapping({ "/admin/getReviewsById/{id}" })
	public ResponseEntity<String> getReviewsById(@PathVariable Long id) {
		String str = accommodationService.getReviewsById(id);
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}

	@GetMapping({ "/admin/getAccommodationById/{id}", "/get/getAccommodationById/{id}" })
	public ResponseEntity<String> getAccommodationById(@PathVariable Long id) {
		ResponseEntity<String> response = null;
		String str = accommodationService.getAccommodationById(id);
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}

	@GetMapping({ "/client/getReservationsByUserId/" })
	public ResponseEntity<String> getReservationsByUserId() {
		String str = accommodationService.getReservationsByUserId();
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
}
