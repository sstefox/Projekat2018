package com.booking.dao;


import com.booking.entities.Message;
import com.booking.entities.User;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long>
{
	List<Message> findMessageByFromUser(User fromUser);

	List<Message> findMessageByToUser(User toUser);
}