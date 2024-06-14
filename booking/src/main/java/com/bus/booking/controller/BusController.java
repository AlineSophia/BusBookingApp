package com.bus.booking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bus.booking.dto.BusDto;
import com.bus.booking.dto.TicketBookingDto;
import com.bus.booking.entity.Bus;
import com.bus.booking.entity.CardDetails;
import com.bus.booking.entity.SeatPreference;
import com.bus.booking.entity.TicketBooking;
import com.bus.booking.entity.User;
import com.bus.booking.repository.UserRepository;
import com.bus.booking.service.BusService;
import com.bus.booking.service.SeatPreferenceImpl;
import com.bus.booking.service.TicketBookingServiceImpl;
import com.bus.booking.service.UserService;

@Controller
@RequestMapping("/bus")
public class BusController {
	
	@Autowired
	private BusService busService;
	
	@Autowired
	private SeatPreferenceImpl seatPreferenceImpl;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TicketBookingServiceImpl ticketBookingServiceImpl;
	
	public User getCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return userRepository.findByEmail(auth.getName());
	}
	
	@ModelAttribute("bus")
	public BusDto BusDto() {
		return new BusDto();
	}
	
	@ModelAttribute("ticket")
	public TicketBookingDto ticketBookingDto() {
		return new TicketBookingDto();
	}
	
	@ModelAttribute("travelsBus")
	public Bus bus() {
		return new Bus();
	}
	
	@GetMapping
	public String getIndex(Model model) {
		User user = getCurrentUser();
		Optional<String> role = Optional.ofNullable("ROLE_TRAVELS");
		if(user.getRoles().stream().map(i -> i.getName()).findFirst().equals(role)) {
			List<Bus> travels= busService.findByUser_Id(user.getId());
			model.addAttribute("travels", travels);
			return "travelsBusList";
		} 
		
		return "index";
	}
	
	@GetMapping("/addBus")
	@PreAuthorize("hasRole('ROLE_TRAVELS')")
	public String getAddBus() {
		return "addBus";
	}
	
	@PostMapping("/addBus")
	public String addBus(@ModelAttribute BusDto bus, Model model) {
		busService.saveBus(bus, getCurrentUser());
		return "redirect:/bus?addsuccess";
	}
	
	@GetMapping("/updateBus/{id}")
	public String updateBus(@PathVariable Long id, Model model) {
		Bus updateBus = busService.findBusById(id); 
		model.addAttribute("updateBus", updateBus);
		return "updateBus";
	}
	
	@PostMapping("/updateBus")
	public String updateBus(@ModelAttribute BusDto bus, Model model) {
		busService.updateBus(bus);
		return "redirect:/bus?updatesuccess";
	}
	
	@GetMapping("/deleteBus/{id}")
	public String deleteBus(@PathVariable Long id) {
		busService.deleteBus(id);
		return "redirect:/bus?deletesuccess";
	}
	
	@PostMapping("/search")
	public String searchBuses(@ModelAttribute BusDto bus, Model model) {
		List<Bus> buses = busService.getBuses(bus.getFromCityName(), bus.getToCityName());
		System.out.println(buses);
		model.addAttribute("buses", buses);
		model.addAttribute("date", bus.getDate());
		return "busList";
	}
	
	@GetMapping("/bookTicket/{id}/{date}")
	public String bookTicket(@PathVariable("id") Long id, @PathVariable("date") String date, Model model) {
		Bus busDetail = busService.findBusById(id);
		List<SeatPreference> seat = seatPreferenceImpl.getAllSeatPreference();
		model.addAttribute("buses", busDetail);
		model.addAttribute("seat", seat);
		model.addAttribute("date", date);
		return "bookTicket";
	}
	
	@PostMapping("/bookTicket")
	public String bookTicket(@ModelAttribute TicketBookingDto ticket ,Model model) {
		model.addAttribute("payRate", ticket.getPrice() * ticket.getNoOfTickets());
		model.addAttribute("ticket", ticket);
		List<CardDetails> cardDetails = userService.getListOfUserCards(getCurrentUser().getId());
		model.addAttribute("cardDetails", cardDetails);
		model.addAttribute("user", getCurrentUser());
		TicketBooking tk = ticketBookingServiceImpl.saveTicketBooking(ticket, getCurrentUser(), cardDetails);
		if(tk == null) {
			return "redirect:/bus?availableTicketError";
		} else {
		
		model.addAttribute("booking", tk);
		return "userPayments";
		}
	}
	
	@GetMapping("/bookingHistory")
	public String getBookingHistory() {
		return "bookingHistory";
	}
}
