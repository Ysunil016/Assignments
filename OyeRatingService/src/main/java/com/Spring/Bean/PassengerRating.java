package com.Spring.Bean;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "passengerRating")
public class PassengerRating {

	@Id
	private String rideId;
	@NotNull
	private String passengerId;
	@NotNull
	private String driverId;
	@NotNull
	private int rating;

	private long time;

	// Important to Be for Mockito Testing
	public PassengerRating() {
	}

	public PassengerRating(String toDriver, String fromPassenger, int rating, String rideId) {
		this.rideId = rideId;
		this.time = System.currentTimeMillis();
		this.driverId = toDriver;
		this.passengerId = fromPassenger;
		this.rating = rating;
	}

	public String getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}

	public String getRideId() {
		return rideId;
	}

	public void setRideId(String rideId) {
		this.rideId = rideId;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}
