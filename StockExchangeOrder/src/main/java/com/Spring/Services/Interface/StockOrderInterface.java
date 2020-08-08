package com.Spring.Services.Interface;

import com.Spring.Bean.StockExecutedOrder;
import com.Spring.Bean.StockReceivedOrder;

public interface StockOrderInterface {

	Object fetchOrder(Integer orderId);

	StockExecutedOrder createOrder(StockReceivedOrder order);

	StockExecutedOrder executeOrder(StockReceivedOrder order);

	StockReceivedOrder updateOrder(Integer orderId,StockReceivedOrder order);

	StockReceivedOrder deleteOrder(Integer orderId);

}
