package com.booking.dao;
import com.booking.entities.Reservations;
import com.booking.entities.User;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository
  extends CrudRepository<Reservations, Long>
{
  public abstract List<Reservations> findReservationsByUserId(User paramUser);
  
  @Modifying
  @Transactional
  @Query("delete from Reservations r where r.id = ?1")
  public abstract void deleteReservationById(Long paramLong);
}

