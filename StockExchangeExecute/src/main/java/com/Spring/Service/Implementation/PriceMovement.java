package com.Spring.Service.Implementation;

import org.springframework.stereotype.Service;

import com.Spring.Bean.StockExecutedOrder;

// Service Class, that Tells Weather Trade is Feasible or Not
@Service
public class PriceMovement{
	
	public boolean isGoodToBuy(StockExecutedOrder order) {
		// Logic to Find Weather Price is Right
	
		
		return true;
	}

}
