package com.agent.main.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.agent.main.services.AccommodationService;
import com.agent.main.services.UserService;
import com.agent.model.AccommodationRequest;
import com.agent.model.ReservationRequest;

@RestController
@CrossOrigin
@RequestMapping("/agent")
public class AgentController {

	@Autowired
	private AccommodationService accommodationService;

	@Autowired
	private UserService userService;

	@GetMapping("/viewAllAdditionalServices")
	public ResponseEntity<String> viewAllAdditionalServices() {
		String jsonArray = accommodationService.viewAllAdditionalServices();
		ResponseEntity<String> responseEntity = null;
		if (jsonArray != null) {
			responseEntity = new ResponseEntity<String>(jsonArray, HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<String>("No results", HttpStatus.OK);
		}
		return responseEntity;
	}
	@GetMapping("/getMessagesForUser")
	public ResponseEntity<String> getMessagesForUser(){
		String jsonArray = accommodationService.getMessagesForCurrentUser();
		return new ResponseEntity<String>(jsonArray,HttpStatus.OK);
	}
	
	@GetMapping("/viewAllAccommodationTypes")
	public ResponseEntity<String> viewAllAccommodationTypes() {
		String jsonArray = accommodationService.viewAllAccommodationTypes();
		ResponseEntity<String> responseEntity = null;
		if (jsonArray != null) {
			responseEntity = new ResponseEntity<String>(jsonArray, HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<String>("No results", HttpStatus.OK);
		}
		return responseEntity;
	}

	@GetMapping("/viewAllAccommodations")
	public ResponseEntity<String> viewAllAccommodations() {
		String jsonArray = accommodationService.viewAllAccommodations();
		ResponseEntity<String> responseEntity = null;
		if (jsonArray != null) {
			responseEntity = new ResponseEntity<String>(jsonArray, HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<String>("No results", HttpStatus.OK);
		}
		return responseEntity;
	}

	@PostMapping("/addNewAccommodation")
	public ResponseEntity<String> addNewAccommodation(@RequestBody AccommodationRequest accommodationRequest) {
		boolean status = accommodationService.saveNewAccommodation(accommodationRequest);
		ResponseEntity<String> responseEntity = null;
		if (status) {
			responseEntity = new ResponseEntity<String>("success", HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<String>("failed", HttpStatus.OK);
		}
		return responseEntity;
	}

	@GetMapping("/getAllUsers")
	public ResponseEntity<String> getAllUserNames() {
		String users = userService.getAllUsernames();
		ResponseEntity<String> responseEntity = null;
		responseEntity = new ResponseEntity<String>(users, HttpStatus.OK);
		return responseEntity;
	}

	@PostMapping("/upload")
	public ResponseEntity<String> singleFileUpload(@RequestParam("file[]") List<MultipartFile> fileList,
			@RequestParam("accommodationId") int accommodationId,
			RedirectAttributes redirectAttributes) {
		ResponseEntity<String> entity = null;
		if (fileList.isEmpty()) {
			entity = new ResponseEntity<String>("No File Found For Upload", HttpStatus.BAD_REQUEST);
			return entity;
		}
		try {
			boolean status = accommodationService.saveAccommodationImages(fileList, accommodationId);
			if (status) {
				entity = new ResponseEntity<String>("Success", HttpStatus.OK);
			}
		} catch (Exception e) {
			entity = new ResponseEntity<String>("Error", HttpStatus.OK);
		}

		return entity;
	}

	@GetMapping("/getAllReservations/{accId}")
	public ResponseEntity<String> getAllReservations(@PathVariable Long accId) {
		String str = accommodationService.getAllReservationsById(accId);
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}

	@GetMapping(value = "/getImages/{id}")
	public ResponseEntity<List<String>> getImageInfo(@PathVariable Long id) {
		return new ResponseEntity<List<String>>(accommodationService.getImagesForAccommodation(id), HttpStatus.OK);
	}

	@GetMapping(value = "/getImages/{accid}/{id}")
	public ResponseEntity<String> getImagesForAccommodation(@PathVariable Long accid, @PathVariable Long id)
			throws IOException {
		ResponseEntity<String> entity = null;
		try {
			String strList = accommodationService.getImageForAccommodationAndId(accid, id);
			entity = new ResponseEntity<String>(strList, HttpStatus.OK);
		} catch (Exception ex) {
			entity = new ResponseEntity<String>("ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return entity;
	}

	@PostMapping(value = "/addNewReservation")
	public ResponseEntity<String> addNewReservation(@RequestBody ReservationRequest reservationRequest) {
		ResponseEntity<String> entity = null;
		try {
			boolean status = accommodationService.saveReservation(reservationRequest);
			if (status) {
				entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			} else {
				entity = new ResponseEntity<String>("FAIL", HttpStatus.OK);
			}
		} catch (Exception e) {
			entity = new ResponseEntity<String>("ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return entity;

	}

	@GetMapping(value = "/getAccommodationById/{id}")
	public ResponseEntity<String> getAccommodationById(@PathVariable Long id) {
		ResponseEntity<String> entity = null;
		try {
			String str = accommodationService.getAccommodationById(id);
			if (str != null) {
				entity = new ResponseEntity<String>(str, HttpStatus.OK);
			} else {
				entity = new ResponseEntity<String>("NOT FOUND", HttpStatus.OK);
			}
		} catch (Exception ex) {
			entity = new ResponseEntity<String>("ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return entity;
	}

	@GetMapping(value = "/getReviewsById/{id}")
	public ResponseEntity<String> getReviewsById(@PathVariable Long id) {
		ResponseEntity<String> entity = null;
		try {
			String str = accommodationService.getReviewsById(id);
			if (str != null) {
				entity = new ResponseEntity<String>(str, HttpStatus.OK);
			} else {
				entity = new ResponseEntity<String>("FAIL", HttpStatus.OK);
			}
		} catch (Exception ex) {
			entity = new ResponseEntity<String>("ERROR", HttpStatus.OK);
		}
		return entity;
	}

	@PostMapping(value = "/updateReservationStatus")
	public ResponseEntity<String> updateReservationStatus(@RequestBody String[] array) {
		ResponseEntity<String> entity = null;
		try {
			boolean status = accommodationService.updateReservationStatus(array);
			if (status) {
				entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			} else {
				entity = new ResponseEntity<String>("FAILED", HttpStatus.OK);
			}
		} catch (Exception ex) {
			entity = new ResponseEntity<String>("ERROR", HttpStatus.OK);
		}
		return entity;
	}
	@GetMapping(value="/sendMessages/{data}/{id}/{accId}/{msgId}")
	public ResponseEntity<String> sendMessages(@PathVariable String data,@PathVariable String id,@PathVariable Long accId,@PathVariable Long msgId){
		ResponseEntity<String> entity = null;
		try {
			boolean status =accommodationService.saveMessages(data, id,accId,msgId);
			if(status) {
				entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			}else {
				entity = new ResponseEntity<String>("FAILED", HttpStatus.OK);
			}
		} catch (Exception ex) {
			entity = new ResponseEntity<String>("ERROR", HttpStatus.OK);
		}
		return entity;
	}
}
