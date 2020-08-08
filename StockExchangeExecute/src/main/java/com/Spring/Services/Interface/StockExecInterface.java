package com.Spring.Services.Interface;

import com.Spring.Bean.StockExecutedOrder;

public interface StockExecInterface {

	StockExecutedOrder fetchOrder(Integer orderId);

	StockExecutedOrder executeOrder(StockExecutedOrder order);

}
