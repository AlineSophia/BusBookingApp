package com.bus.booking.service;

import java.util.List;

import com.bus.booking.dto.BusDto;
import com.bus.booking.entity.Bus;
import com.bus.booking.entity.User;

public interface BusService {

	List<Bus> getBuses(String fromCityName, String toCityName);

	Bus findBusById(Long id);

	void saveBus(BusDto bus, User user);
	
	public List<Bus> findByUser_Id(Long id);

	void updateBus(BusDto bus);

	void deleteBus(Long id); 

}
