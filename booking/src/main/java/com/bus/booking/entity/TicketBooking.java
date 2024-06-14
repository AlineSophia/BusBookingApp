package com.bus.booking.entity;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ticket_booking")
public class TicketBooking {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Bus bus;
	
	private String name;
	
	private String phoneNumber;
	
	private String date;
	
	private String email;
	
	private String age;
	
	private String gender;
	
	private String nationality;
	
	@ManyToOne
	private SeatPreference seatPreference;
	
	private int noOfTickets;
	
	private boolean payment;
	
	@OneToOne
	private CardDetails card;
	
	public TicketBooking() {
		
	}

	public TicketBooking(User user, Bus bus, String name, String phoneNumber, String date,
			String email, String age, String gender, String nationality, SeatPreference seatPreference, int noOfTickets,
			boolean payment, CardDetails card) {
		super();
		this.user = user;
		this.bus = bus;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.date = date;
		this.email = email;
		this.age = age;
		this.gender = gender;
		this.nationality = nationality;
		this.seatPreference = seatPreference;
		this.noOfTickets = noOfTickets;
		this.payment = payment;
		this.card = card;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public SeatPreference getSeatPreference() {
		return seatPreference;
	}

	public void setSeatPreference(SeatPreference seatPreference) {
		this.seatPreference = seatPreference;
	}

	public int getNoOfTickets() {
		return noOfTickets;
	}

	public void setNoOfTickets(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}

	public boolean isPayment() {
		return payment;
	}

	public void setPayment(boolean payment) {
		this.payment = payment;
	}

	public CardDetails getCard() {
		return card;
	}

	public void setCard(CardDetails card) {
		this.card = card;
	}

	
}
