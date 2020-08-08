package com.Spring.Bean;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stockReceivedOrders")
public class StockReceivedOrder {

	@Id
	@NotNull
	private int orderId;
	@NotNull
	private String stockName;
	@Size(max = 1, min = 1, message = "Order Type Should be Either -1 or 1")
	private int orderType; // Buy - 1 or Sell - 1;
	@NotNull
	private int quantity;
	@NotNull
	private int orderPice;
	@Past
	private Timestamp orderTime;

	public StockReceivedOrder() {
	}

	public StockReceivedOrder(@NotNull int orderId, @NotNull String stockName,
			@Size(max = 1, min = 1, message = "Order Type Should be Either -1 or 1") int orderType,
			@NotNull int quantity, @NotNull int orderPice, @Past Timestamp orderTime) {
		this.orderId = orderId;
		this.stockName = stockName;
		this.orderType = orderType;
		this.quantity = quantity;
		this.orderPice = orderPice;
		this.orderTime = orderTime;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public int getOrderType() {
		return orderType;
	}

	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getOrderPice() {
		return orderPice;
	}

	public void setOrderPice(int orderPice) {
		this.orderPice = orderPice;
	}

	public Timestamp getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}

	@Override
	public String toString() {
		return "StockReceivedOrder [orderId=" + orderId + ", stockName=" + stockName + ", orderType=" + orderType
				+ ", quantity=" + quantity + ", orderPice=" + orderPice + ", orderTime=" + orderTime + "]";
	}

}
