package com.bus.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bus.booking.config.EmailServiceImpl;
import com.bus.booking.dto.BusDto;
import com.bus.booking.entity.CardDetails;
import com.bus.booking.entity.TicketBooking;
import com.bus.booking.entity.User;
import com.bus.booking.repository.TicketBookingRepository;
import com.bus.booking.repository.UserRepository;
import com.bus.booking.service.TicketBookingServiceImpl;
import com.bus.booking.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends EmailServiceImpl {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TicketBookingRepository ticketBookingRepository;
	
	@Autowired TicketBookingServiceImpl ticketBookingServiceImpl;
	
	public User getCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return userRepository.findByEmail(auth.getName());
	}
	
	@GetMapping("/details")
	public String getUserDetails(Model model) {
		model.addAttribute("user", getCurrentUser());

		return "userDetails";
	}
	
	@PostMapping("/updateDetails")
	public String updateUserDetails(@ModelAttribute User user, Model model) {
		System.out.println(user.getCity());
		userService.updateUserDetails(user);
		return "redirect:/user/details?updateSuccess";
	}
	
	@GetMapping("/payments")
	public String getUserPayment(Model model) {
		List<CardDetails> cardDetails = userService.getListOfUserCards(getCurrentUser().getId());
		model.addAttribute("cardDetails", cardDetails);
		model.addAttribute("user", getCurrentUser());
		model.addAttribute("payRate", null);
		return "userPayments";
	}
	
	@GetMapping("/addCards")
	public String getUserCard(Model model) {
		return "addCards";
	}
	
	@PostMapping("/addCard")
	public String addCard(@ModelAttribute CardDetails card, Model model) {
		userService.addCard(card, getCurrentUser());
		return "redirect:/user/payments?addSuccess";
	}
	
	@GetMapping("/cardDelete/{id}")
	public String deleteUser(@PathVariable Long id) {
		userService.deleteUserCard(id);
		return "redirect:/user/payments?deleteSuccess";
	}
	
	@GetMapping("/payAmount/{id}/card/{cardId}")
	public String payment(@PathVariable("id") Long id, @PathVariable("cardId") Long cardId, Model model) {
		//TicketBooking tk =  ticketBookingRepository.getById(id);
		//update card and payment
		TicketBooking tk = ticketBookingServiceImpl.updateCardAndPayment(id, cardId);
		
		String message = "Thank you for booking your ticket on "+ tk.getDate()+" "
				+ "from "+tk.getBus().getFromCityName()+" "
						+ "to "+ tk.getBus().getToCityName()+". "
								+ "Your confirmation number is "+tk.getId()+ ". "
										+ "No of tickets are "+tk.getNoOfTickets() ;
		sendSimpleMessage(getCurrentUser().getEmail(), "Confirmation Email", message);
		return "redirect:/user/bookings?bookingSuccess";
	}
	
	@GetMapping("/bookings")
	public String getBookingHistoryd(Model model) {
		List<TicketBooking> booking = ticketBookingServiceImpl.getUserTicket(getCurrentUser());
		model.addAttribute("booking", booking);
		return "bookingHistory";
	}
	
	
}
