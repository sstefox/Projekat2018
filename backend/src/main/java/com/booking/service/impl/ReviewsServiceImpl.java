package com.booking.service.impl;

import com.booking.dao.AccommodationRepository;
import com.booking.dao.ReviewRepository;
import com.booking.dao.UserRepository;
import com.booking.entities.Accommodation;
import com.booking.entities.Reviews;
import com.booking.entities.User;
import com.booking.model.ReviewResponse;
import com.booking.service.ReviewsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;



@Service
public class ReviewsServiceImpl
  implements ReviewsService
{
  Logger logger = LoggerFactory.getLogger(ReviewsServiceImpl.class);
  @Autowired
  private ReviewRepository reviewRepository;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private AccommodationRepository accommodationRepository;
  
  public ReviewsServiceImpl() {}
  
  public String getAllReviews() { String strResponse = null;
    try {
      List<ReviewResponse> lst = new ArrayList();
      List<Reviews> reviewList = (List)reviewRepository.findAll();
      if ((reviewList != null) && (reviewList.size() > 0)) {
        for (Reviews reviews : reviewList) {
          ReviewResponse reviewResponse = new ReviewResponse();
          reviewResponse.setId(reviews.getId());
          reviewResponse.setRating(reviews.getRating());
          reviewResponse.setComment(reviews.getComment());
          reviewResponse.setStatus(reviews.getStatus());
          reviewResponse.setUser(reviews.getUser().getUsername());
          reviewResponse.setAccommodationId(reviews.getAccommodation().getId());
          reviewResponse.setUserId(reviews.getUser().getId());
          reviewResponse.setAccommodationTitle(reviews.getAccommodation().getTitle());
          reviewResponse.setEntryDate(reviews.getEntryDate());
          lst.add(reviewResponse);
        }
      }
      ObjectMapper mapper = new ObjectMapper();
      strResponse = mapper.writeValueAsString(lst);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return strResponse;
  }
  
  public boolean updateReviewStatus(String[] array)
  {
    boolean status = false;
    try {
      for (String str : array) {
        String[] temp = str.split(" ");
        int t = Integer.parseInt(temp[1]);
        if (t == 1) {
          t = 0;
        } else {
          t = 1;
        }
        reviewRepository.updateStatusByReviewId(t, Long.valueOf(Long.parseLong(temp[0])));
      }
      status = true;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return status;
  }
  
  public boolean saveReview(Double rating, String comment, Long id)
  {
    boolean status = false;
    try {
      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  String name = auth.getName(); 
	  User user = userRepository.findByUsername(name);
      Accommodation accommodation = accommodationRepository.findAccommodationById(id);
      Reviews reviews = new Reviews();
      reviews.setAccommodation(accommodation);
      reviews.setUser(user);
      reviews.setRating(rating.doubleValue());
      reviews.setComment(comment);
      reviews.setEntryDate(new java.sql.Date(new java.util.Date().getTime()));
      reviews.setStatus(0);
      reviewRepository.save(reviews);
      updateReviewStatusInAccommodation(accommodation, id);
      status = true;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return status;
  }
  
  private void updateReviewStatusInAccommodation(Accommodation accommodation, Long id) {
    try { Object temp = reviewRepository.getAverageRatingForAccommodation(accommodation);
      Double rating = (Double)temp;
      int category = 0;
      if (rating.doubleValue() == 0.0D) {
        category = 0;
      }
      else if ((rating.doubleValue() > 0.0D) && (rating.doubleValue() <= 1.0D)) {
        category = 1;
      } else if ((rating.doubleValue() > 1.0D) && (rating.doubleValue() <= 2.0D)) {
        category = 2;
      } else if ((rating.doubleValue() > 2.0D) && (rating.doubleValue() <= 3.0D)) {
        category = 3;
      } else if ((rating.doubleValue() > 3.0D) && (rating.doubleValue() <= 4.0D)) {
        category = 4;
      } else {
        category = 5;
      }
      accommodationRepository.updateCategoryAndRatingByAccommodationId(category, rating, id);
      logger.info("Going to update category and rating by accommodation id");
    } catch (Exception ex) {
      ex.printStackTrace();
      logger.error("Error while updating review status for accommodation", ex);
    }
  }
}
 
