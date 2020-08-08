package com.Spring.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Spring.Bean.StockExecutedOrder;

public interface OrderExecutedRepository extends CrudRepository<StockExecutedOrder, String> {
	List<StockExecutedOrder> findOrderByTransId(String id);

	List<StockExecutedOrder> findOrderByOrderId(String id);
}
