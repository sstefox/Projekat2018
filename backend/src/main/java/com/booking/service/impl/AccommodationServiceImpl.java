package com.booking.service.impl;

import com.booking.dao.AccommodationCategoryRepository;
import com.booking.dao.AccommodationImageRepository;
import com.booking.dao.AccommodationRepository;
import com.booking.dao.AccommodationTypeRepository;
import com.booking.dao.AdditionalServiceRepository;
import com.booking.dao.MessageRepository;
import com.booking.dao.ReservationRepository;
import com.booking.dao.ReviewRepository;
import com.booking.dao.UserRepository;
import com.booking.entities.Accommodation;
import com.booking.entities.AccommodationCategory;
import com.booking.entities.AccommodationImages;
import com.booking.entities.AccommodationType;
import com.booking.entities.AdditionalServices;
import com.booking.entities.Message;
import com.booking.entities.Reservations;
import com.booking.entities.Reviews;
import com.booking.entities.User;
import com.booking.model.AccommodationResponse;
import com.booking.model.AdvanceSearchRequest;
import com.booking.model.MessageRequest;
import com.booking.model.ReservationRequest;
import com.booking.model.ReservationResponse;
import com.booking.model.ReviewResponse;
import com.booking.model.SearchRequest;
import com.booking.service.AccommodationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AccommodationServiceImpl implements AccommodationService {
	Logger logger = LoggerFactory.getLogger(AccommodationServiceImpl.class);

	@Autowired
	private AccommodationRepository accommodationRepository;

	@Autowired
	private AdditionalServiceRepository additionalServiceRepository;
	
	@Autowired
	private AccommodationCategoryRepository accommodationCategoryRepository;

	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private AccommodationTypeRepository accommodationTypeRepository;

	public AccommodationServiceImpl() {
	}

	public String viewAllAccommodations() {
		String jsonArray = null;
		try {
			List<Accommodation> accommodationList = (List) accommodationRepository.findAll();
			List<AccommodationResponse> accList = new ArrayList();
			for (Accommodation acc : accommodationList) {
				AccommodationResponse res = new AccommodationResponse();
				res.setCapacity(acc.getCapacity());
				res.setDescription(acc.getDescription());
				res.setId(acc.getId());
				res.setLocation(acc.getLocation());
				res.setPrice(acc.getPrice());
				res.setRating(acc.getRating());
				List<String> servicelist = new ArrayList<String>();
				for(AdditionalServices src:acc.getServices()) {
					servicelist.add(src.getServiceName());				
				}
				res.setServices(servicelist);
				res.setStatus(acc.getStatus());
				res.setType(acc.getType());
				res.setUsername(acc.getUsername());
				res.setTitle(acc.getTitle());
				String str = Integer.toString(acc.getCategory());
				res.setCategory(((AccommodationCategory) accommodationCategoryRepository
						.findById(Long.valueOf(Long.parseLong(str))).get()).getCategoryName());
				accList.add(res);
			}
			ObjectMapper mapper = new ObjectMapper();
			jsonArray = mapper.writeValueAsString(accList);

		} catch (Exception ex) {
			logger.error("Exception while view all accommodations", ex);
		}
		return jsonArray;
	}

	public String viewAllAccommodationsDummy() {
		String jsonArray = null;
		List<AccommodationResponse> accList = new ArrayList();
		try {
			List<Accommodation> accommodationList = (List) accommodationRepository.findAll();
			for (Accommodation acc : accommodationList) {
				AccommodationResponse res = new AccommodationResponse();
				res.setCapacity(acc.getCapacity());
				res.setDescription(acc.getDescription());
				res.setId(acc.getId());
				res.setLocation(acc.getLocation());
				res.setPrice(acc.getPrice());
				res.setRating(acc.getRating());
				List<String> servicelist = new ArrayList<String>();
				for(AdditionalServices src:acc.getServices()) {
					servicelist.add(src.getServiceName());				
				}
				res.setServices(servicelist);
				res.setStatus(acc.getStatus());
				res.setType(acc.getType());
				res.setUsername(acc.getUsername());
				res.setTitle(acc.getTitle());
				String str = Integer.toString(acc.getCategory());
				res.setCategory(((AccommodationCategory) accommodationCategoryRepository
						.findById(Long.valueOf(Long.parseLong(str))).get()).getCategoryName());
				accList.add(res);
			}
			ObjectMapper mapper = new ObjectMapper();
			jsonArray = mapper.writeValueAsString(accList);
		} catch (Exception ex) {
			logger.error("Exception while view all accommodations", ex);
		}
		return jsonArray;
	}

	@Autowired
	private AccommodationImageRepository accommodationImageRepository;
	@Autowired
	private ReservationRepository reservationRepository;

	public boolean updateAccommodationStatus(String array) {
		boolean status = false;
		try {
			String arr = array.substring(1, array.length() - 1);
			String[] strarr = arr.split(",");
			for (String str : strarr) {
				str = str.trim();
				str = str.replaceAll("\"", "");
				String[] sarr = str.split(" ");
				int stat = Integer.parseInt(sarr[1].trim());
				if (stat == 1) {
					stat = 2;
				} else {
					stat = 1;
				}
				accommodationRepository.updateStatusByAccommodationId(stat, Long.valueOf(Long.parseLong(sarr[0])));
			}
			status = true;
		} catch (Exception ex) {
			logger.error("Exception while update  accommodations", ex);
		}
		return status;
	}
	public String advanceSearchAccommodation(AdvanceSearchRequest advanceSearchRequest) {
		String accList = "";
		try {
			List<Accommodation> accLst = new ArrayList();
			java.sql.Date fromDate = new java.sql.Date(new java.util.Date(advanceSearchRequest.getFromDate()).getTime());
			java.sql.Date toDate = new java.sql.Date(new java.util.Date(advanceSearchRequest.getToDate()).getTime());
			int capacity = advanceSearchRequest.getCapacity();
			String location = advanceSearchRequest.getLocation();
			List<Long> serviceList = new ArrayList<Long>();
			for(String str : advanceSearchRequest.getServiceList()) {
				serviceList.add(Long.parseLong(str));
			}
			AccommodationType type = accommodationTypeRepository.findById(advanceSearchRequest.getType()).get();
			AccommodationCategory category = accommodationCategoryRepository.findById(Long.parseLong(advanceSearchRequest.getCategory())).get();
			List<Object[]> arr = accommodationRepository.advanceSearchResults(capacity, location, fromDate, toDate, serviceList, type.getId(),category.getId() );
		}catch (Exception ex) {
			logger.error("Exception while doing advance search", ex);
		}
		return accList;
	}

	public String searchAccommodation(SearchRequest searchRequest) {
		String accList = "";
		try {
			List<Accommodation> accLst = new ArrayList();

			java.sql.Date fromDate = new java.sql.Date(new java.util.Date(searchRequest.getFromDate()).getTime());
			java.sql.Date toDate = new java.sql.Date(new java.util.Date(searchRequest.getToDate()).getTime());
			int capacity = searchRequest.getCapacity();
			String location = searchRequest.getLocation();

			List<Object[]> accommodationList = accommodationRepository.searchResults(capacity, location, fromDate,
					toDate);
			for (Object[] object : accommodationList) {
				Accommodation accObj = new Accommodation();
				accObj.setId((Long) object[0]);
				accObj.setType((String) object[1]);
				accObj.setPrice(((Double) object[2]).doubleValue());
				accObj.setTitle((String) object[3]);
				accObj.setRating((Double) object[4]);
				accObj.setCategory(((Integer) object[5]).intValue());

				accLst.add(accObj);
			}
			ObjectMapper mapper = new ObjectMapper();
			accList = mapper.writeValueAsString(accLst);
		} catch (Exception ex) {
			logger.error("Exception while doing search", ex);
		}
		return accList;
	}

	@Autowired
	private UserRepository userRepository;

	public String getReviewsById(Long id) {
		String resultStr = "";
		try {
			Accommodation accommodation = accommodationRepository.findAccommodationById(id);
			List<Reviews> reviewList = reviewRepository.findReviewsByAccommodation(accommodation);
			List<ReviewResponse> reviewResponseList = new ArrayList();
			if ((reviewList != null) && (reviewList.size() > 0)) {
				for (Reviews review : reviewList) {
					ReviewResponse reviewResponse = new ReviewResponse();
					reviewResponse.setComment(review.getComment());
					reviewResponse.setEntryDate(review.getEntryDate());
					reviewResponse.setId(review.getId());
					reviewResponse.setUser(review.getUser().getFirstName());
					reviewResponse.setRating(review.getRating());
					reviewResponse.setStatus(review.getStatus());
					java.util.Date date=new java.util.Date(review.getEntryDate().getTime());
			        SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yy");
			        String dateText = df2.format(date);
					reviewResponse.setEntryDateStr(dateText);
					reviewResponseList.add(reviewResponse);
				}
			}

			ObjectMapper mapper = new ObjectMapper();
			resultStr = mapper.writeValueAsString(reviewResponseList);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultStr;
	}

	@Autowired
	private MessageRepository messageRepository;

	public String getAccommodationById(Long id) {
		String str = null;
		try {
			Accommodation accommodation = accommodationRepository.findAccommodationById(id);
			ObjectMapper mapper = new ObjectMapper();
			str = mapper.writeValueAsString(accommodation);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return str;
	}

	public List<String> getImagesForAccommodation(Long id) {
		List<String> base64Images = new ArrayList();
		try {
			Accommodation acc = accommodationRepository.findAccommodationById(id);
			List<AccommodationImages> accommodationImages = accommodationImageRepository
					.findAccommodationImagesByAccommodationId(acc);
			if ((accommodationImages != null) && (accommodationImages.size() > 0)) {
				for (AccommodationImages accImage : accommodationImages) {
					base64Images.add(Long.toString(accImage.getId().longValue()));
				}
			}
		} catch (Exception ex) {
			logger.error("Exception while fetching images", ex);
		}
		return base64Images;
	}

	public String getImageForAccommodationAndId(Long accId, Long id) {
		String str = null;
		try {
			Accommodation acc = accommodationRepository.findAccommodationById(accId);
			AccommodationImages accImage = accommodationImageRepository
					.findAccommodationImagesByAccommodationIdAndId(acc, id);
			if (accImage != null) {
				InputStream inputImage = new FileInputStream(accImage.getPath());
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte['Ѐ'];
				int l = inputImage.read(buffer);
				while (l >= 0) {
					outputStream.write(buffer, 0, l);
					l = inputImage.read(buffer);
				}
				str = Base64.getEncoder().encodeToString(outputStream.toByteArray());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return str;
	}

	public boolean saveReservation(ReservationRequest reservationRequest) {
		boolean status = false;
		try {
			Reservations reservation = new Reservations();
			reservation.setCapacity(Double.valueOf(reservationRequest.getCapacity()));
			reservation.setAccommodationId(
					accommodationRepository.findAccommodationById(reservationRequest.getAccommodationId()));
			reservation.setPrice(Double.valueOf(reservationRequest.getPrice()));

			java.sql.Date fromDate = new java.sql.Date(new java.util.Date(reservationRequest.getFromDate()).getTime());
			reservation.setFromDate(fromDate);
			java.sql.Date toDate = new java.sql.Date(new java.util.Date(reservationRequest.getToDate()).getTime());
			reservation.setToDate(toDate);
			reservation.setUserId(userRepository.findUserById(Long.valueOf(Long.parseLong("1"))));
			reservationRepository.save(reservation);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}

	public String getReservationsByUserId() {
		String resultStr = "";
		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String name = auth.getName();
			List<ReservationResponse> responseList = new ArrayList();
			User user = userRepository.findByUsername(name);
			List<Reservations> reservationsList = reservationRepository.findReservationsByUserId(user);
			if (reservationsList != null) {
				for (Reservations reservation : reservationsList) {
					ReservationResponse response = new ReservationResponse();
					response.setAccommodationId(reservation.getAccommodationId().getTitle());
					response.setCapacity(reservation.getCapacity().toString());
					response.setFromDate(reservation.getFromDate().toString());
					response.setToDate(reservation.getToDate().toString());
					response.setStatus(reservation.getStatus());
					response.setPrice(reservation.getPrice().toString());
					response.setId(reservation.getId());
					responseList.add(response);
				}
			}
			ObjectMapper mapper = new ObjectMapper();
			resultStr = mapper.writeValueAsString(responseList);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultStr;
	}

	public boolean deleteReservations(String[] array) {
		boolean status = false;
		try {
			for (String str : array) {
				reservationRepository.deleteReservationById(Long.valueOf(Long.parseLong(str)));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}

	public boolean saveMessage(MessageRequest messagereq) {
		boolean status = false;
		try {
			Message message = new Message();
			message.setComment(messagereq.getMessage());
			message.setFromUser(userRepository.findUserById(Long.valueOf(Long.parseLong("1"))));
			message.setToUser(userRepository.findUserById(Long.valueOf(Long.parseLong("2"))));
			message.setAccommodation(accommodationRepository.findAccommodationById(messagereq.getAccommodationId()));
			message.setStatus(0);
			message.setEntryDate(new java.sql.Date(new java.util.Date().getTime()));
			messageRepository.save(message);
			status = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}

	public boolean saveMessageFromUser(String message, Long id) {
		boolean status = false;
		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String name = auth.getName();
			Message msg = new Message();
			Accommodation acc = accommodationRepository.findAccommodationById(id);
			String toUsername = acc.getUsername();
			msg.setComment(message);
			msg.setEntryDate(new java.sql.Date(new java.util.Date().getTime()));
			msg.setFromUser(userRepository.findByUsername(name));
			msg.setAccommodation(acc);
			msg.setToUser(userRepository.findByUsername(toUsername));
			messageRepository.save(msg);
			status = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}

	@Override
	public String getMessagesToUserId() {
		String jsonArray = "";
		try {
			List<MessageRequest> msgReqList = new ArrayList<MessageRequest>();
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String name = auth.getName();
			List<Message> msgs = messageRepository.findMessageByToUser(userRepository.findByUsername(name));
			for (Message ms : msgs) {
				MessageRequest req = new MessageRequest();
				req.setAccommodation(ms.getAccommodation().getTitle());
				req.setDate(ms.getEntryDate().toString());
				req.setMessage(ms.getComment());
				req.setSentBy(ms.getFromUser().getUsername());
				req.setSentTo(ms.getToUser().getUsername());
				msgReqList.add(req);
			}
			ObjectMapper mapper = new ObjectMapper();
			jsonArray = mapper.writeValueAsString(msgReqList);
		} catch (Exception ex) {
			logger.error("Excetpion in to user messages {}", ex);
		}
		return jsonArray;
	}

	@Override
	public String getMessagesFromUserId() {
		String jsonArray = "";
		try {
			List<MessageRequest> msgReqList = new ArrayList<MessageRequest>();
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String name = auth.getName();
			List<Message> msgs = messageRepository.findMessageByFromUser(userRepository.findByUsername(name));
			for (Message ms : msgs) {
				MessageRequest req = new MessageRequest();
				req.setAccommodation(ms.getAccommodation().getTitle());
				req.setDate(ms.getEntryDate().toString());
				req.setMessage(ms.getComment());
				req.setSentBy(ms.getFromUser().getUsername());
				req.setSentTo(ms.getToUser().getUsername());
				msgReqList.add(req);
			}
			ObjectMapper mapper = new ObjectMapper();
			jsonArray = mapper.writeValueAsString(msgReqList);
		} catch (Exception ex) {
			logger.error("Excetpion in from user messages {}", ex);
		}
		return jsonArray;
	}
}
