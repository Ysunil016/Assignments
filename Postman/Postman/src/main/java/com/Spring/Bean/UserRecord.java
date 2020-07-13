package com.Spring.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "userRecords")
public class UserRecord {

	@Id
	private String username;
	private HashMap<String, ArrayList<Booking>> bookings;
	private HashMap<String, ArrayList<Booking>> booked;
	private HashMap<String, ArrayList<Integer>> availableSlots;

	public UserRecord(String username) {
		this.username = username;
		this.bookings = new HashMap<String, ArrayList<Booking>>();
		this.booked = new HashMap<String, ArrayList<Booking>>();
		this.availableSlots = new HashMap<String, ArrayList<Integer>>();
	}

	public String getUsername() {
		return username;
	}

	public UserRecord setUsername(String username) {
		this.username = username;
		return this;
	}

	public HashMap<String, ArrayList<Booking>> getBookings() {
		return bookings;
	}

	public UserRecord setBookings(HashMap<String, ArrayList<Booking>> bookings) {
		this.bookings = bookings;
		return this;
	}

	public HashMap<String, ArrayList<Booking>> getBooked() {
		return booked;
	}

	public UserRecord setBooked(HashMap<String, ArrayList<Booking>> booked) {
		this.booked = booked;
		return this;
	}

	public boolean addBooking(Booking book) {
		ArrayList<Booking> allBookings = this.bookings.get(getDate());
		if (allBookings.equals(null))
			allBookings = new ArrayList<Booking>();
		allBookings.add(book);
		this.bookings.put(getDate(), allBookings);
		return true;
	}

	public boolean addBooked(Booking book) {
		ArrayList<Booking> allBooked = this.bookings.get(getDate());
		if (allBooked.equals(null))
			allBooked = new ArrayList<Booking>();
		allBooked.add(book);
		this.booked.put(getDate(), allBooked);

		return true;
	}

	public HashMap<String, ArrayList<Integer>> getAvailableSlots() {
		return availableSlots;
	}

	public void setAvailableSlots(HashMap<String, ArrayList<Integer>> availableSlots) {
		this.availableSlots = availableSlots;
	}

	private String getDate() {
		Date date = new Date();
		@SuppressWarnings("deprecation")
		int dateValue = date.getDate() + date.getMonth() + 1 + date.getYear();
		return String.valueOf(dateValue);
	}

}
