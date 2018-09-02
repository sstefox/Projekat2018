package com.booking.service;

public  interface ReviewsService
{
  public  String getAllReviews();
  
  public  boolean updateReviewStatus(String[] paramArrayOfString);
  
  public  boolean saveReview(Double paramDouble, String paramString, Long paramLong);
}
