package com.bus.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.booking.entity.SeatPreference;
import com.bus.booking.repository.SeatPreferenceRepository;

@Service
public class SeatPreferenceImpl {
	
	@Autowired
	private SeatPreferenceRepository seatPreferenceRepository;

	public List<SeatPreference> getAllSeatPreference() {
		return seatPreferenceRepository.findAll();
	}

}
