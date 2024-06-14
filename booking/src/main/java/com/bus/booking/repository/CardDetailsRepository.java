package com.bus.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.booking.entity.CardDetails;

public interface CardDetailsRepository extends JpaRepository<CardDetails, Long> {
	
	public List<CardDetails> findByUser_Id(Long id);

}
