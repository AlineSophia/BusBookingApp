package com.bus.booking.dto;

public class BusDto {
	
	private String fromCityName;
	
	private String toCityName;
	
	private String date;
	
	private String travelsName;
	
	private String startTime;
	
	private String arrivalTime;
	
	private int price;
	
	private String rating;
	
	private String type;
	
	private int totalSeats;
	
	private int availableSeats;
	
	private Long id;
	
	public BusDto() {
		
	}

	public BusDto(String fromCityName, String toCityName, String date) {
		super();
		this.fromCityName = fromCityName;
		this.toCityName = toCityName;
		this.date = date;
	}
	
	public BusDto(String fromCityName, String toCityName, String date, String travelsName, String startTime,
			String arrivalTime, int price, String rating, String type, int totalSeats, int availableSeats) {
		super();
		this.fromCityName = fromCityName;
		this.toCityName = toCityName;
		this.date = date;
		this.travelsName = travelsName;
		this.startTime = startTime;
		this.arrivalTime = arrivalTime;
		this.price = price;
		this.rating = rating;
		this.type = type;
		this.totalSeats = totalSeats;
		this.availableSeats = availableSeats;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTravelsName() {
		return travelsName;
	}

	public void setTravelsName(String travelsName) {
		this.travelsName = travelsName;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	
}
