package com.agent.main.services.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.agent.main.dao.AccommodationImageRepository;
import com.agent.main.dao.AccommodationRepository;
import com.agent.main.dao.AccommodationTypeRepository;
import com.agent.main.dao.AdditionalServiceRepository;
import com.agent.main.dao.MessageRepository;
import com.agent.main.dao.ReservationRepository;
import com.agent.main.dao.ReviewRepository;
import com.agent.main.dao.UserRepository;
import com.agent.main.entities.Accommodation;
import com.agent.main.entities.AccommodationImages;
import com.agent.main.entities.AccommodationType;
import com.agent.main.entities.AdditionalServices;
import com.agent.main.entities.Message;
import com.agent.main.entities.Reservations;
import com.agent.main.entities.Reviews;
import com.agent.main.entities.User;
import com.agent.main.services.AccommodationService;
import com.agent.model.AccommodationRequest;
import com.agent.model.MessageResponse;
import com.agent.model.ReservationRequest;
import com.agent.model.ReservationResponse;
import com.agent.model.ReviewResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AccommodationServiceImpl implements AccommodationService {
	Logger logger = LoggerFactory.getLogger(AccommodationServiceImpl.class);
	@Autowired
	private AccommodationTypeRepository accommodationTypeRepository;
	@Autowired
	private AdditionalServiceRepository additionalServiceRepository;
	@Autowired
	private AccommodationRepository accommodationRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private AccommodationImageRepository accommodationImageRepository;
	@Autowired
	private MessageRepository messageRepository;
	@Autowired
	private ReviewRepository reviewRepository;

	@Override
	public String viewAllAccommodationTypes() {
		String accommodationTypes = null;
		try {
			List<AccommodationType> accommodationTypeList = (List<AccommodationType>) accommodationTypeRepository
					.findAll();
			ObjectMapper mapper = new ObjectMapper();
			List<String> nameList = new ArrayList<String>();
			for (AccommodationType type : accommodationTypeList) {
				nameList.add(type.getTypeName());
			}
			accommodationTypes = mapper.writeValueAsString(nameList);
		} catch (Exception ex) {
			logger.error("Exception while fetching accommodation types", ex);
		}
		return accommodationTypes;
	}

	@Override
	public String viewAllAdditionalServices() {
		String jsonArray = null;
		try {
			List<AdditionalServices> additionalServicesList = (List<AdditionalServices>) additionalServiceRepository
					.findAll();
			ObjectMapper mapper = new ObjectMapper();
			List<String> nameList = new ArrayList<String>();
			for (AdditionalServices service : additionalServicesList) {
				nameList.add(service.getServiceName());
			}
			jsonArray = mapper.writeValueAsString(nameList);
		} catch (Exception ex) {
			logger.error("Exception while fetching all service", ex);
		}
		return jsonArray;
	}

	@Override
	public boolean saveNewAccommodation(AccommodationRequest accommodationRequest) {
		boolean status = false;
		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		    String name = auth.getName(); 
		    User user = userRepository.findByUsername(name);
			Accommodation accommodation = new Accommodation();
			accommodation.setLocation(accommodationRequest.getLocation());
			accommodation.setDescription(accommodationRequest.getDescription());
			accommodation.setPrice(accommodationRequest.getPrice());
			Set<AdditionalServices> serviceList = new HashSet<AdditionalServices>();
			for(String str: accommodationRequest.getServices()) {
				AdditionalServices service = additionalServiceRepository.findAdditionalServicesByServiceName(str);
				serviceList.add(service);
			}
			accommodation.setServices(serviceList);
			accommodation.setStatus(1);
			accommodation.setType(accommodationRequest.getAcctype());
			accommodation.setUsername(user.getUsername());
			accommodation.setCapacity(accommodationRequest.getCapacity());
			accommodation.setTitle(accommodationRequest.getTitle());
			accommodation.setCategory(1);
			accommodationRepository.save(accommodation);
			status = true;
		} catch (Exception ex) {
			logger.error("Exception while saving accommodation", ex);
		}
		return status;
	}

	@Override
	public String viewAllAccommodations() {
		String jsonArray = null;
		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String name = auth.getName(); 
			User user = userRepository.findByUsername(name);
			List<Accommodation> accommodationList = (List<Accommodation>) accommodationRepository.findAccommodationByUsername(user.getUsername());
			ObjectMapper mapper = new ObjectMapper();
			jsonArray = mapper.writeValueAsString(accommodationList);
		} catch (Exception ex) {
			logger.error("Exception while view all accommodations", ex);
		}
		return jsonArray;
	}

	@Override
	public boolean saveAccommodationImages(List<MultipartFile> files, int accommodationId) {
		boolean status = false;
		try {
			for (MultipartFile file : files) {
				byte[] bytes = file.getBytes();
				String str = "temp/" + accommodationId + "/";
				File sourceLocation = new File(str);
				if (!sourceLocation.exists()) {
					sourceLocation.mkdirs();
				}
				Path path = Paths.get(str + file.getOriginalFilename());
				File fileTOSave = new File(str + file.getOriginalFilename());
				AccommodationImages accImage = new AccommodationImages();
				Long id = Long.parseLong(Integer.toString(accommodationId));
				accImage.setAccommodationId(accommodationRepository.findAccommodationById(id));
				accImage.setPath(fileTOSave.getAbsolutePath());
				Files.write(path, bytes);
				accImage.setUploadDate(new Date(new java.util.Date().getTime()));
				accommodationImageRepository.save(accImage);
			}
			status = true;
		} catch (Exception ex) {
			logger.error("Exception while saving image", ex);
		}
		return status;
	}

	@Override
	public List<String> getImagesForAccommodation(Long id) {
		List<String> base64Images = new ArrayList<String>();
		try {
			Accommodation acc = accommodationRepository.findAccommodationById(id);
			List<AccommodationImages> accommodationImages = accommodationImageRepository
					.findAccommodationImagesByAccommodationId(acc);
			if (accommodationImages != null && accommodationImages.size() > 0) {
				for (AccommodationImages accImage : accommodationImages) {
					base64Images.add(Long.toString(accImage.getId()));
				}
			}
		} catch (Exception ex) {
			logger.error("Exception while fetching images", ex);
		}
		return base64Images;
	}

	@Override
	public String getImageForAccommodationAndId(Long accId, Long id) {
		String str = null;
		try {
			Accommodation acc = accommodationRepository.findAccommodationById(accId);
			AccommodationImages accImage = accommodationImageRepository
					.findAccommodationImagesByAccommodationIdAndId(acc, id);
			if (accImage != null) {
				InputStream inputImage = new FileInputStream(accImage.getPath());
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[1024];
				int l = inputImage.read(buffer);
				while (l >= 0) {
					outputStream.write(buffer, 0, l);
					l = inputImage.read(buffer);
				}
				str = Base64.getEncoder().encodeToString(outputStream.toByteArray());
			}
		} catch (Exception ex) {
			logger.error("Exception while retrieving image", ex);
		}
		return str;
	}

	@Override
	public boolean saveReservation(ReservationRequest reservationRequest) {
		boolean status = false;
		try {
			Reservations reservation = new Reservations();
			@SuppressWarnings("deprecation")
			Date fromDate = new Date(new java.util.Date(reservationRequest.getFromDate()).getTime());
			reservation.setFromDate(fromDate);
			Date toDate = new Date(new java.util.Date(reservationRequest.getToDate()).getTime());
			reservation.setToDate(toDate);
			reservation.setPrice(Double.parseDouble(reservationRequest.getPrice()));
			reservation.setStatus(0);
			reservation.setCapacity(Double.parseDouble(reservationRequest.getCapacity()));
			reservation.setAccommodationId(accommodationRepository
					.findAccommodationById(Long.parseLong(reservationRequest.getAccommodationId())));
			reservation.setUserId(userRepository.findUserByUsername(reservationRequest.getUsername()));
			reservationRepository.save(reservation);
			status = true;
		} catch (Exception ex) {
			logger.error("Exception while adding reservation", ex);
		}
		return status;
	}

	@Override
	public String getAccommodationById(Long id) {
		String str = null;
		try {
			Accommodation accommodation = accommodationRepository.findAccommodationById(id);
			ObjectMapper mapper = new ObjectMapper();
			str = mapper.writeValueAsString(accommodation);
		} catch (Exception ex) {
			logger.error("Exception while Getting accommodation", ex);
		}
		return str;
	}

	@Override
	public String getReviewsById(Long id) {
		String resultStr = "";
		try {
			Accommodation accommodation = accommodationRepository.findAccommodationById(id);
			List<Reviews> reviewList = reviewRepository.findReviewsByAccommodation(accommodation);
			List<ReviewResponse> reviewResponseList = new ArrayList<ReviewResponse>();
			if (reviewList != null && reviewList.size() > 0) {
				for (Reviews review : reviewList) {
					ReviewResponse reviewResponse = new ReviewResponse();
					reviewResponse.setComment(review.getComment());
					reviewResponse.setEntryDate(review.getEntryDate().toString());
					reviewResponse.setId(review.getId());
					reviewResponse.setUser(review.getUser().getFirstName());
					reviewResponse.setRating(review.getRating());
					reviewResponse.setStatus(review.getStatus());
					reviewResponseList.add(reviewResponse);

				}
			}
			ObjectMapper mapper = new ObjectMapper();
			resultStr = mapper.writeValueAsString(reviewResponseList);
		} catch (Exception ex) {
			logger.error("Exception while getting reviews", ex);
		}
		return resultStr;
	}

	@Override
	public String getAllReservationsById(Long id) {
		String resultStr = "";
		try {
			Accommodation accommodation = accommodationRepository.findAccommodationById(id);
			List<Reservations> reservationList = reservationRepository.findAllByAccommodationId(accommodation);
			List<ReservationResponse> responseList = new ArrayList<ReservationResponse>();
			if (reservationList != null) {
				for (Reservations reservation : reservationList) {
					ReservationResponse response = new ReservationResponse();
					response.setId(reservation.getId());
					response.setCapacity(reservation.getCapacity());
					response.setFromDate(reservation.getFromDate().toString());
					response.setToDate(reservation.getToDate().toString());
					response.setPrice(reservation.getPrice().toString());
					response.setStatus(reservation.getStatus());
					response.setUsername(reservation.getUserId().getFirstName());
					responseList.add(response);
				}
			}
			ObjectMapper mapper = new ObjectMapper();
			resultStr = mapper.writeValueAsString(responseList);
		} catch (Exception ex) {
			logger.error("Exception while getting reservations", ex);
		}
		return resultStr;
	}

	@Override
	public boolean updateReservationStatus(String[] array) {
		boolean status = false;
		try {
			for (String str : array) {
				Long id = Long.parseLong(str);
				reservationRepository.updateStatusById(id);
			}
			status = true;
		} catch (Exception ex) {
			logger.error("Exception while updating reservation", ex);
		}
		return status;
	}
	
	@Override
	public String getMessagesForCurrentUser() {
		String jsonArray = "";
		List<MessageResponse> messageResponse = new ArrayList<MessageResponse>();
		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		    String name = auth.getName(); 
		    User user = userRepository.findByUsername(name);
		    List<Message> messageList =  messageRepository.findMessageByToUserAndStatus(user, 0);
		    for(Message res:messageList) {
		    	MessageResponse response = new MessageResponse();
		    	response.setId(res.getId());
		    	User fromUser = res.getFromUser();
		    	response.setFromname(fromUser.getUsername());
		    	response.setMessage(res.getComment());
		    	response.setEntryDate(new java.sql.Date(res.getEntryDate().getTime()).toString());
		    	Accommodation acc = res.getAccommodation();
		    	response.setAccommodationUser(acc.getTitle());
		    	response.setAccId(acc.getId());
		    	response.setStatus(res.getStatus());
		    	messageResponse.add(response);
		    }
		    ObjectMapper mapper = new ObjectMapper();
		    jsonArray =  mapper.writeValueAsString(messageResponse);
		}catch(Exception ex) {
			logger.error("Exception while fetching messages", ex);
		}
		return jsonArray;
	}
	@Override
	public boolean saveMessages(String data,String id,Long accId,Long msgId) {
		boolean status = false;
		try {
			Message message = new Message();
			message.setComment(data);
			message.setToUser(userRepository.findByUsername(id));
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		    String name = auth.getName(); 
		    User user = userRepository.findByUsername(name);
		    message.setFromUser(user);
		    message.setStatus(1);
		    Accommodation acc = accommodationRepository.findAccommodationById(accId);
		    message.setEntryDate(new java.sql.Date(new java.util.Date().getTime()));
		    message.setAccommodation(acc);
		    messageRepository.updateStatusForMessageOfAccommodation(msgId);
		    messageRepository.save(message);
		    status = true;
		}catch(Exception ex) {
			logger.error("Exception while fetching messages", ex);
		}
		return status;
	}
}
