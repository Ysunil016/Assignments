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
import com.Spring.CustomException.OrderException;
import com.Spring.Services.Interface.StockOrderInterface;

@RestController
@RequestMapping("/v1/stockExchange")
public class Orders {

	@Autowired
	private StockOrderInterface orderService;

	@PostMapping(value = "/placeOrder", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBean> placeOrder(@Valid @RequestBody StockReceivedOrder order) {
		if (order == null)
			new OrderException("Not Valid Input");

		ResponseBean response = new ResponseBean(orderService.createOrder(order), "Placeing Order");
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "/fetchOrder/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBean> getOrder(@PathVariable("orderId") Integer orderId) {
		if (orderId == null)
			new OrderException("No Order ID");
		ResponseBean response = new ResponseBean(orderService.fetchOrder(orderId), "Placeing Order");
		return ResponseEntity.ok(response);
	}

	@PutMapping(value = "/updateOrder/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBean> updateOrder(@PathVariable("orderId") Integer id,
			@RequestBody StockReceivedOrder order) {
		if (order == null)
			new OrderException("Order Found");
		ResponseBean response = new ResponseBean(orderService.updateOrder(id, order), "Placeing Order");
		return ResponseEntity.ok(response);
	}

	@DeleteMapping(value = "/deleteOrder/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBean> deleteOrder(@PathVariable("orderId") Integer orderId) {
		if (orderId == null)
			new OrderException("No Order ID");

		ResponseBean response = new ResponseBean(orderService.deleteOrder(orderId), "Placeing Order");
		return ResponseEntity.ok(response);
	}

}
