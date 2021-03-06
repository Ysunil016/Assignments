package com.Spring.Resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.Bean.DriverRating;
import com.Spring.Bean.PassengerRating;
import com.Spring.Services.Interface.RatingInterface;

@RestController
@RequestMapping("/v1/rating")
public class RatingResource {

	@Autowired
	private RatingInterface ratingService;

	@GetMapping(value = "/getAggregatedRating/driver/{driverId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public float getdriverRating(@PathVariable("driverId") String driverId) {
		return ratingService.getAggregatedDriverRating(driverId);
	}

	@GetMapping(value = "/getAggregatedRating/passenger/{passengerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public float getpassengerRating(@PathVariable("passengerId") String passengerId) {
		return ratingService.getAggregatedPassengerRating(passengerId);
	}

	@PostMapping(value = "/giveRatingToDriver", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean giveRatingToDriver(@RequestBody DriverRating driverRating) {
		return ratingService.rateDriver(driverRating);
	}

	@PostMapping(value = "/giveRatingToPassenger", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean giveRatingToPassenger(@RequestBody PassengerRating passengerRating) {
		return ratingService.ratePassenger(passengerRating);
	}
}
