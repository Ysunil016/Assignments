package com.Spring.Bean;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bookings")
public class Booking {

	@Id
	private String bookingId; // booking_for+timeSlot+todaysDate;
	@NotNull
	@Email(message = "Please Provide Username")
	private String to;
	private String from;
	private String Description;
	@NotNull
	private Integer slot;

	// Important to Be for Mockito Testing
	public Booking() {
	}

	public Booking(String to, String from, Integer slot) {
		this.bookingId = to.hashCode() + "_" + slot + "_" + getDate();
		this.to = to;
		this.from = from;
		this.slot = slot;
	}

	public Booking initiateBooking(String from) {
		this.bookingId = to.hashCode() + "_" + slot + "_" + getDate();
		this.from = from;
		return this;
	}

	public String getBookingId() {
		return bookingId;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public Integer getSlot() {
		return slot;
	}

	public void setSlot(Integer slot) {
		this.slot = slot;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	private String getDate() {
		Date date = new Date();
		@SuppressWarnings("deprecation")
		int dateValue = date.getDate() + date.getMonth() + 1 + date.getYear();
		return String.valueOf(dateValue);

	}

	@Override
	public String toString() {
		return "{\"bookingId\":\"" + bookingId + "\",\"to\":\"" + to + "\",\"from\":\"" + from + "\",\"slot\":" + slot
				+ ",\"description\":\"" + Description + "\"} ";
	}

}
