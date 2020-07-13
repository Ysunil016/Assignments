package com.Spring.Services.Interface;

import com.Spring.Bean.DriverRating;
import com.Spring.Bean.PassengerRating;

public interface RatingInterface {

	// Passenger Rating Driver
	boolean rateDriver(DriverRating driverRating);

	// Passenger Rating Driver
	boolean ratePassenger(PassengerRating passengerRating);

	// Driver Getting Aggregated Rating
	float getAggregatedDriverRating(String driverId);

	// Passenger Getting Aggregated Rating
	float getAggregatedPassengerRating(String passenderId);

}
