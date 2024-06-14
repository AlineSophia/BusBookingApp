package com.bus.booking.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bus.booking.dto.UserRegistrationDto;
import com.bus.booking.entity.CardDetails;
import com.bus.booking.entity.Role;
import com.bus.booking.entity.User;
import com.bus.booking.repository.CardDetailsRepository;
import com.bus.booking.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private CardDetailsRepository cardDetailsRepository;
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
	
	@Override
	public User save(UserRegistrationDto registrationDto) {
		String role = "ROLE_USER";
		if(registrationDto.getRole().toLowerCase().equals("travels")) {
			role = "ROLE_TRAVELS";
		}
		User user = new User(registrationDto.getFirstName(), registrationDto.getLastName(), 
				registrationDto.getEmail(),  passwordEncoder.encode(registrationDto.getPassword()),
				Arrays.asList(new Role(role)));
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(), mapRolesToAuthorities(user.getRoles()));
	}

	@Transactional
	public void updateUserDetails(User user) {
		userRepository.updateUserDetails(user.getFirstName(),user.getLastName(), user.getEmail(), 
				 user.getGender(),
				user.getPhoneNumber(), user.getCity(), user.getState(), user.getId());
		
	}

	@Override
	public void addCard(CardDetails card, User currentUser) {
		CardDetails cardDetails = new CardDetails(card.getCardName(), card.getCardType(), card.getCardNumber(), card.getCvv(),
				card.getCardHolderName(), card.getExpiryDate(), currentUser);
		cardDetailsRepository.save(cardDetails);
		
	}

	@Override
	public List<CardDetails> getListOfUserCards(Long id) {
		return cardDetailsRepository.findByUser_Id(id);
	}

	@Override
	public void deleteUserCard(Long id) {
		cardDetailsRepository.deleteById(id);
		
	}

	

	
}
