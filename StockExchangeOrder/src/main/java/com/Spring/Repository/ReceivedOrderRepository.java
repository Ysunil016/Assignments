package com.Spring.Repository;

import org.springframework.data.repository.CrudRepository;

import com.Spring.Bean.StockReceivedOrder;

public interface ReceivedOrderRepository extends CrudRepository<StockReceivedOrder, Integer> {
}
