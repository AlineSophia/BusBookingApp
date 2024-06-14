package com.bus.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bus.booking.entity.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {

	@Query("select b from Bus b where b.fromCityName = ?1 and b.toCityName = ?2 ")
	List<Bus> getListOfBuses(String fromCityName, String toCityName);
	
	public List<Bus> findByUser_Id(Long id);

	@Modifying
	@Query("update Bus b set b.travelsName = ?1, b.fromCityName = ?2, b.toCityName = ?3, b.date = ?4, b.startTime = ?5, "
			+ "b.arrivalTime = ?6, b.price = ?7, b.rating = ?8, b.type = ?9, b.totalSeats = ?10, b.availableSeats = ?11 "
			+ "where b.id = ?12  ")
	void updateBus(String travelsName, String fromCityName, String toCityName, String date, String startTime,
			String arrivalTime, int price, String rating, String type, int totalSeats, int availableSeats, Long id); 

}
