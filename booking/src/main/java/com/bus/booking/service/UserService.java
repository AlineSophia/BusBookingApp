package com.bus.booking.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.bus.booking.dto.UserRegistrationDto;
import com.bus.booking.entity.CardDetails;
import com.bus.booking.entity.User;

public interface UserService extends UserDetailsService {
	
	User save(UserRegistrationDto registrationDto);

	void updateUserDetails(User user);

	void addCard(CardDetails card, User currentUser);

	List<CardDetails> getListOfUserCards(Long id);

	void deleteUserCard(Long id);
	
	

}
