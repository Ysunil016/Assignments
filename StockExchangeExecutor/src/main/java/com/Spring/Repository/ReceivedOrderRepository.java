package com.Spring.Repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.Spring.Bean.StockReceivedOrder;

public interface ReceivedOrderRepository extends CrudRepository<StockReceivedOrder, String> {
	ArrayList<StockReceivedOrder> findByOrderId(String driverId);
}
