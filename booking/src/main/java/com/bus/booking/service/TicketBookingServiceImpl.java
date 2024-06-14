package com.bus.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.booking.dto.TicketBookingDto;
import com.bus.booking.entity.Bus;
import com.bus.booking.entity.CardDetails;
import com.bus.booking.entity.SeatPreference;
import com.bus.booking.entity.TicketBooking;
import com.bus.booking.entity.User;
import com.bus.booking.repository.CardDetailsRepository;
import com.bus.booking.repository.SeatPreferenceRepository;
import com.bus.booking.repository.TicketBookingRepository;

import jakarta.transaction.Transactional;

@Service
public class TicketBookingServiceImpl {

	@Autowired
	private TicketBookingRepository ticketBookingRepository;
	
	@Autowired
	private SeatPreferenceRepository seatPreferenceRepository;
	
	@Autowired
	private BusService busService;
	
	@Autowired
	private CardDetailsRepository cardDetailsRepository;

	public TicketBooking saveTicketBooking(TicketBookingDto ticketDto, User user, List<CardDetails> cardDetails) {
		Bus bus = busService.findBusById(ticketDto.getBusId());
		//CardDetails card = cardDetailsRepository.getById(ticketDto.getCardId());
		SeatPreference sp = seatPreferenceRepository.getById(ticketDto.getSeatPreference());
		if(bus.getAvailableSeats() - ticketDto.getNoOfTickets() > 0) {
			TicketBooking ticket = new TicketBooking(user, bus, ticketDto.getName(), ticketDto.getPhoneNumber(), ticketDto.getDate(),
					ticketDto.getEmail(), ticketDto.getAge(), ticketDto.getGender() ,ticketDto.getNationality(), sp, ticketDto.getNoOfTickets(),
					false, null);
			return ticketBookingRepository.save(ticket);
		} else {
			return null;
		}
		
	}

	@Transactional
	public TicketBooking updateCardAndPayment(Long id, Long cardId) {
		System.out.println("Calling the ticket Booking -------------------------");
		TicketBooking tk =  ticketBookingRepository.getById(id);
		CardDetails cd = cardDetailsRepository.getById(cardId);
		/* if(tk.getBus().getAvailableSeats() - tk.getNoOfTickets() > 0) { */
			ticketBookingRepository.updateCardAndPayment(cd, true, tk.getId());
			return ticketBookingRepository.getById(id);
			/*
			 * } return tk;
			 */
		
	}

	public List<TicketBooking> getUserTicket(User currentUser) {
		List<TicketBooking> booking = ticketBookingRepository.getUserConfirmedBookings(currentUser, true);
		return booking;
	}
	
	
}
