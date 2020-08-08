package com.Spring.Resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.Bean.StockExecutedOrder;
import com.Spring.Bean.StockReceivedOrder;
import com.Spring.CustomException.OrderException;
import com.Spring.Services.Interface.StockExecInterface;

@RestController
@RequestMapping("/v1/stockExchange")
public class Executation {

	@Autowired
	private StockExecInterface eService;

	@PostMapping(value = "/executeOrder", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StockExecutedOrder> exeOrder(@Valid @RequestBody StockReceivedOrder rOrder) {
		if (rOrder == null)
			new OrderException("Not Valid Input");
		StockExecutedOrder order = new StockExecutedOrder(rOrder.getType(), rOrder.getOrder_id(), rOrder.getQuantity(),
				rOrder.getPrice(), rOrder.getTime());
		return ResponseEntity.ok(eService.executeOrder(order));
	}

	@GetMapping(value = "/fetchOrder/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StockExecutedOrder> getOrder(@PathVariable("orderId") Integer orderId) {
		if (orderId == null)
			new OrderException("No Order ID");
		return ResponseEntity.ok(eService.fetchOrder(orderId));
	}

}
