package com.Spring.Resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.Bean.StockReceivedOrder;
import com.Spring.Bean.Exception.ResponseBean;
import com.Spring.Services.Interface.RatingInterface;

@RestController
@RequestMapping("/v1/stockExchange")
public class Orders {

	@Autowired
	private RatingInterface ratingService;

	@PostMapping(value = "/placeOrder", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBean> placeOrder(@Valid @RequestBody StockReceivedOrder order) {
		return ratingService.getAggregatedDriverRating(driverId);
	}

	@GetMapping(value = "/fetchOrder/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public float getOrder(@PathVariable("orderId") Integer orderId) {
		return ratingService.getAggregatedPassengerRating(passengerId);
	}

	@PutMapping(value = "/updateOrder/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public float updateOrder(@PathVariable("orderId") Integer orderId) {
		return ratingService.getAggregatedPassengerRating(passengerId);
	}

	@DeleteMapping(value = "/deleteOrder/orderId", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean deleteOrder(@PathVariable("orderId") Integer orderId) {
		return ratingService.rateDriver(driverRating);
	}

}
