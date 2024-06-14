package com.bus.booking.entity;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bus")
public class Bus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String travelsName;
	
	private String fromCityName;
	
	private String toCityName;
	
	private String date;
	
	private String startTime;
	
	private String arrivalTime;
	
	private int price;
	
	private String rating;
	
	private String type;
	
	private int totalSeats;
	
	private int availableSeats;
	
	@ManyToOne
	private User user;
	
	/*
	 * @ManyToMany private TicketBooking ticketBooking;
	 */
	
	public Bus() {
		
	}

	public Bus(String travelsName, String fromCityName, String toCityName, String date, String startTime, String arrivalTime,
			int price, String rating, String type, int totalSeats, int availableSeats, User user) {
		super();
		this.travelsName = travelsName;
		this.fromCityName = fromCityName;
		this.toCityName = toCityName;
		this.date = date;
		this.startTime = startTime;
		this.arrivalTime = arrivalTime;
		this.price = price;
		this.rating = rating;
		this.type = type;
		this.totalSeats = totalSeats;
		this.availableSeats = availableSeats;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTravelsName() {
		return travelsName;
	}

	public void setTravelsName(String travelsName) {
		this.travelsName = travelsName;
	}

	public String getFromCityName() {
		return fromCityName;
	}

	public void setFromCityName(String fromCityName) {
		this.fromCityName = fromCityName;
	}

	public String getToCityName() {
		return toCityName;
	}

	public void setToCityName(String toCityName) {
		this.toCityName = toCityName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
	
}
