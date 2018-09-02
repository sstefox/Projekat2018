package com.booking.dao;

import com.booking.entities.Accommodation;
import com.booking.entities.AccommodationCategory;
import com.booking.entities.AccommodationType;
import com.booking.entities.AdditionalServices;

import java.sql.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public  interface AccommodationRepository
  extends CrudRepository<Accommodation, Long>
{
  public  List<Accommodation> findByStatus(int paramInt);
  
  @Modifying
  @Query("update Accommodation a set a.status=?1 where a.id=?2")
  @Transactional
  public  void updateStatusByAccommodationId(int paramInt, Long paramLong);
  
  @Query("select id,type,price,title,rating,category from Accommodation where id not in (select acc.id from Accommodation acc join Reservations r on acc.id = r.accommodationId  where r.fromDate<=?3 and r.toDate>=?4) and capacity>=?1 and location=?2")
  @Transactional
  public  List<Object[]> searchResults(int paramInt, String paramString, Date paramDate1, Date paramDate2);
  
  @Modifying
  @Query("update Accommodation a set a.category=?1, a.rating=?2 where a.id=?3")
  @Transactional
  public  void updateCategoryAndRatingByAccommodationId(int paramInt, Double paramDouble, Long paramLong);
  
  public  Accommodation findAccommodationById(Long paramLong);
  
  @Query("select a.id,a.type,a.price,a.title,a.rating,a.category from Accommodation a join AdditionalServices s where a.id not in (select acc.id from Accommodation acc join Reservations r on acc.id = r.accommodationId  where r.fromDate<=?3 and r.toDate>=?4) and a.capacity>=?1 and a.location=?2 and a.category=?7 and s.id in (?5) and a.type=?6")
  @Transactional
  public  List<Object[]> advanceSearchResults(int paramInt, String paramString, Date paramDate1, Date paramDate2,List<Long> services,Long types,Long category);
  
  
  
}
