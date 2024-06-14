package com.bus.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.booking.dto.BusDto;
import com.bus.booking.entity.Bus;
import com.bus.booking.entity.User;
import com.bus.booking.repository.BusRepository;

import jakarta.transaction.Transactional;

@Service
public class BusServiceImpl implements BusService {
	
	@Autowired
	private BusRepository busRepository;

	@Override
	public List<Bus> getBuses(String fromCityName, String toCityName) {
		
		return busRepository.getListOfBuses(fromCityName, toCityName);
	}

	@Override
	public Bus findBusById(Long id) {
		return busRepository.getById(id);
	}

	@Override
	public void saveBus(BusDto bus, User user) {
		Bus saveBus = new Bus(bus.getTravelsName(), bus.getFromCityName(), bus.getToCityName(), bus.getDate(), bus.getStartTime(), bus.getArrivalTime(),
				bus.getPrice(), bus.getRating(), bus.getType(), bus.getTotalSeats(), bus.getTotalSeats(), user);
		busRepository.save(saveBus);
		
	}

	@Override
	public List<Bus> findByUser_Id(Long id) {
		return busRepository.findByUser_Id(id);
	}

	@Transactional
	public void updateBus(BusDto bus) {
		busRepository.updateBus(bus.getTravelsName(), bus.getFromCityName(), bus.getToCityName(), bus.getDate(), bus.getStartTime(), bus.getArrivalTime(),
				bus.getPrice(), bus.getRating(), bus.getType(), bus.getTotalSeats(), bus.getAvailableSeats() ,bus.getId());
		
	}

	@Override
	public void deleteBus(Long id) {
		busRepository.deleteById(id);
		
	}
	
}
