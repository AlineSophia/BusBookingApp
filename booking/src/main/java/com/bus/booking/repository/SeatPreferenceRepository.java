package com.bus.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.booking.entity.SeatPreference;

@Repository
public interface SeatPreferenceRepository extends JpaRepository<SeatPreference, Long> {

}
