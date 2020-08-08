package com.Spring.Service.Implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.Bean.StockExecutedOrder;
import com.Spring.CustomException.CouldNotExecuteOrder;
import com.Spring.CustomException.OrderNotFound;
import com.Spring.Repository.OrderExecutedRepository;
import com.Spring.Services.Interface.StockExecInterface;

@Service
public class StockExecService implements StockExecInterface {
	@Autowired
	private OrderExecutedRepository executedRepository;
	@Autowired
	private PriceMovement priceMovement;

	@Override
	public StockExecutedOrder executeOrder(StockExecutedOrder eOrder) {

		if (priceMovement.isGoodToBuy(eOrder)) {
			return executedRepository.save(eOrder);
		} else {
			throw new CouldNotExecuteOrder("Not Able to Buy on That Price");
		}
	}

	@Override
	public StockExecutedOrder fetchOrder(Integer orderId) {
		Optional<StockExecutedOrder> excecutedOrder = executedRepository.findById(orderId);
		if (!excecutedOrder.isPresent())
			throw new OrderNotFound("No Order in Executed Reposiroty");

		return excecutedOrder.get();

	}

}
