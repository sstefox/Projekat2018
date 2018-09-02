package com.booking.dao;


import com.booking.entities.Accommodation;
import com.booking.entities.Reviews;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public  interface ReviewRepository
  extends CrudRepository<Reviews, Long>
{
  @Modifying
  @Query("update Reviews a set a.status=?1 where a.id=?2")
  @Transactional
  public abstract void updateStatusByReviewId(int paramInt, Long paramLong);
  
  @Query("select round(avg(rating)) from Reviews where accommodation=?1 group by accommodation")
  public abstract Object getAverageRatingForAccommodation(Accommodation paramAccommodation);
  
  public abstract List<Reviews> findReviewsByAccommodation(Accommodation paramAccommodation);
}
