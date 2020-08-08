package com.Spring.Services.Interface;

import com.Spring.Bean.StockExecutedOrder;

// Interface, for Handling Exce Interfaces

public interface StockExecInterface {

	StockExecutedOrder fetchOrder(Integer orderId);

	StockExecutedOrder executeOrder(StockExecutedOrder order);

}
