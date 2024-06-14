package com.bus.booking.dto;

public class TicketBookingDto {
	
	private String name;
	
	private String phoneNumber;
	
	private String date;
	
	private String email;
	
	private String age;
	
	private String gender;
	
	private String nationality;
	
	private Long seatPreference;
	
	private int noOfTickets;
	
	private int price;
	
	private boolean payment;
	
	private Long busId;
	
	private Long cardId;
		
	public TicketBookingDto() {
		
	}
	
	

	public TicketBookingDto(String name, String phoneNumber, String date, String email, String age, String gender,
			String nationality, Long seatPreference, int noOfTickets, int price, boolean payment, Long busId,
			Long cardId) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.date = date;
		this.email = email;
		this.age = age;
		this.gender = gender;
		this.nationality = nationality;
		this.seatPreference = seatPreference;
		this.noOfTickets = noOfTickets;
		this.price = price;
		this.payment = payment;
		this.busId = busId;
		this.cardId = cardId;
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

	public Long getSeatPreference() {
		return seatPreference;
	}

	public void setSeatPreference(Long seatPreference) {
		this.seatPreference = seatPreference;
	}

	public int getNoOfTickets() {
		return noOfTickets;
	}

	public void setNoOfTickets(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isPayment() {
		return payment;
	}

	public void setPayment(boolean payment) {
		this.payment = payment;
	}

	public Long getBusId() {
		return busId;
	}

	public void setBusId(Long busId) {
		this.busId = busId;
	}

	public Long getCardId() {
		return cardId;
	}

	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}

	


}
