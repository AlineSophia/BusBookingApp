package com.bus.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bus.booking.entity.CardDetails;
import com.bus.booking.entity.TicketBooking;
import com.bus.booking.entity.User;

@Repository
public interface TicketBookingRepository extends JpaRepository<TicketBooking, Long> {

	@Modifying
	@Query("update TicketBooking tk set tk.card = ?1, tk.payment = ?2 where tk.id = ?3")	
	public void updateCardAndPayment(CardDetails cardDetails, Boolean payment, Long id);

	@Query("select tk from TicketBooking tk where tk.user = ?1 and tk.payment = ?2")
	List<TicketBooking> getUserConfirmedBookings(User user, Boolean value);

}
