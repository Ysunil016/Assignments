package com.Spring.Service.Implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.Bean.StockReceivedOrder;
import com.Spring.Bean.PassengerRating;
import com.Spring.Repository.ReceivedOrderRepository;
import com.Spring.Repository.OrderExecutedRepository;
import com.Spring.Services.Interface.RatingInterface;

@Service
public class RatingService implements RatingInterface {

	@Autowired
	private ReceivedOrderRepository driverRatingRepository;
	@Autowired
	private OrderExecutedRepository passengerRatingRepository;

	@Override
	public boolean rateDriver(StockReceivedOrder driverRating) {
		try {
			// Checking if Ride is Already Present in the Database
			Optional<StockReceivedOrder> foundRide = driverRatingRepository.findById(driverRating.getRideId());
			if (foundRide.isPresent()) {
				return false;
			}
			// Saving Ride Rating to Database
			driverRatingRepository.save(driverRating);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean ratePassenger(PassengerRating passengerRating) {
		try {
			Optional<PassengerRating> foundRide = passengerRatingRepository.findById(passengerRating.getRideId());
			// Checking if Ride is Already Present in the Database
			if (foundRide.isPresent()) {
				return false;
			}
			// Saving Ride Rating to Database
			passengerRatingRepository.save(passengerRating);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public float getAggregatedDriverRating(String driverId) {
		List<StockReceivedOrder> allDriverRatings = driverRatingRepository.findByDriverId(driverId);
		int totalSumRating = 0;
		for (StockReceivedOrder driverRating : allDriverRatings) {
			totalSumRating += driverRating.getRating();
		}
		if (allDriverRatings.size() != 0) {
			return totalSumRating / allDriverRatings.size();
		}
		return -1;
	}

	@Override
	public float getAggregatedPassengerRating(String passenderId) {
		List<PassengerRating> allPassengerRating = passengerRatingRepository.findByPassengerId(passenderId);
		int totalSumRating = 0;
		for (PassengerRating passengerRating : allPassengerRating) {
			totalSumRating += passengerRating.getRating();
		}
		if (allPassengerRating.size() != 0) {
			return totalSumRating / allPassengerRating.size();
		}
		return -1;
	}

}
