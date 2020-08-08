package com.Spring.Service.Implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Spring.Bean.StockExecutedOrder;
import com.Spring.Bean.StockReceivedOrder;
import com.Spring.CustomException.CouldNotExecuteOrder;
import com.Spring.CustomException.OrderException;
import com.Spring.CustomException.OrderNotFound;
import com.Spring.Repository.OrderExecutedRepository;
import com.Spring.Repository.ReceivedOrderRepository;
import com.Spring.Services.Interface.StockOrderInterface;

@Service
public class StockOrderService implements StockOrderInterface {

	@Autowired
	private ReceivedOrderRepository orderRepository;
	@Autowired
	private OrderExecutedRepository executedRepository;
	@Autowired
	RestTemplate restTamplate;

	@Value("${data.ExecutorServiceEndPoint}")
	private String executorServiceEndPoint;
	@Value("${data.ExecutorServiceIP}")
	private String executorServiceIP;
	@Value("${data.ExecutorServicePort}")
	private String executorServicePORT;

	@Override
	public StockExecutedOrder createOrder(StockReceivedOrder order) {
		if (orderRepository.findById(order.getOrder_id()).isPresent())
			throw new OrderException("Order Already Exist");

		// Sending Order for Executation
		StockExecutedOrder eOrder = executeOrder(order);
		if (eOrder != null) {
			// Saving Order // Updating
			order.setExecuted(true);
			orderRepository.save(order);
		} else {
			// Saving Order as Pending
			orderRepository.save(order);
		}
		return eOrder;
	}

	@Override
	public StockExecutedOrder executeOrder(StockReceivedOrder order) {
		
		ResponseEntity<StockExecutedOrder> responseEntity = restTamplate.postForEntity(
				"http://" + executorServiceIP + ":" + executorServicePORT + executorServiceEndPoint, order,
				StockExecutedOrder.class);

		if (!responseEntity.getStatusCode().equals(HttpStatus.OK)) {
			throw new CouldNotExecuteOrder("Could Not Place Order");
		}

		return responseEntity.getBody();
	}

	@Override
	public StockReceivedOrder updateOrder(Integer orderId, StockReceivedOrder rOrder) {
		if (orderId == null)
			throw new OrderException("Not Appropriate OrderId");

		Optional<StockReceivedOrder> order = orderRepository.findById(orderId);
		if (!order.isPresent()) {
			throw new OrderNotFound("Could Not Find Order with ID - " + orderId);
		}

		if (order.get().isExecuted()) {
			throw new OrderException("Order Excuted Already - Cannot be Updated");
		}

		// Deleting Order
		rOrder.setOrder_id(order.get().getOrder_id());
		orderRepository.save(rOrder);

		return rOrder;

	}

	@Override
	public StockReceivedOrder deleteOrder(Integer orderId) {
		if (orderId == null)
			throw new OrderException("Not Appropriate OrderId");

		Optional<StockReceivedOrder> order = orderRepository.findById(orderId);
		if (!order.isPresent()) {
			throw new OrderNotFound("Could Not Find Order with ID - " + orderId);
		}

		if (order.get().isExecuted()) {
			throw new OrderException("Order Excuted Already - Cannot be Deleted");
		}

		// Deleting Order
		orderRepository.delete(order.get());

		return order.get();
	}

	@Override
	public Object fetchOrder(Integer orderId) {
		Optional<StockReceivedOrder> oReceived = orderRepository.findById(orderId);
		if (!oReceived.isPresent()) {
			throw new OrderNotFound("No Such Order Found");
		}
		if (!oReceived.get().isExecuted()) {
			return oReceived.get();
		}
		Optional<StockExecutedOrder> excecutedOrder = executedRepository.findById(orderId);

		return new Response(oReceived.get(), excecutedOrder.get());
	}

	// Combined Response for Fetching
	class Response {
		private StockReceivedOrder received;
		private StockExecutedOrder executed;

		public Response(StockReceivedOrder received, StockExecutedOrder executed) {
			super();
			this.received = received;
			this.executed = executed;
		}

		public StockReceivedOrder getReceived() {
			return received;
		}

		public void setReceived(StockReceivedOrder received) {
			this.received = received;
		}

		public StockExecutedOrder getExecuted() {
			return executed;
		}

		public void setExecuted(StockExecutedOrder executed) {
			this.executed = executed;
		}

	}

}
