package com.booking.dao;

import com.booking.entities.User;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface UserRepository
  extends CrudRepository<User, Long>
{
  @Modifying
  @Query("update User a set a.status=?1 where a.id=?2")
  @Transactional
  public  void updateStatusByUserId(int paramInt, Long paramLong);
  
  public  User findByUsernameAndStatus(String paramString, int paramInt);
  
  public  User findByUsername(String paramString);
  
  public  User findUserById(Long paramLong);
  
  @Modifying
  @Query("update User a set a.password=?2 where a.username=?1")
  @Transactional
  public  void updatePasswordByUsername(String paramString1, String paramString2);
}
