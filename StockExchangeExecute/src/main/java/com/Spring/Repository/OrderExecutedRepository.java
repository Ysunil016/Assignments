package com.Spring.Repository;

import org.springframework.data.repository.CrudRepository;

import com.Spring.Bean.StockExecutedOrder;

// Executed Order Repository
public interface OrderExecutedRepository extends CrudRepository<StockExecutedOrder, Integer> {

}
