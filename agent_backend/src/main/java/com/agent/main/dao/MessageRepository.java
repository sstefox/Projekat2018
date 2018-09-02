package com.agent.main.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.agent.main.entities.Message;
import com.agent.main.entities.User;
public interface MessageRepository extends CrudRepository<Message,Long>{

	public List<Message> findMessageByToUserAndStatus(User toUser,int status);
	
	@Modifying
	@Query("update Message a set a.status=1 where a.id=?1")
	@Transactional
	public void updateStatusForMessageOfAccommodation(Long msgId);
}

