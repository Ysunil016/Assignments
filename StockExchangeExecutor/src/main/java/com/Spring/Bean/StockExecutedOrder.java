package com.Spring.Bean;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document("stockExecutedOrders")
public class StockExecutedOrder {

	@Id
	@NotNull
	private int transId; // Transaction ID

	@NotNull
	private int orderId; // Order ID
	@NotNull
	private int quantity;
	@NotNull
	private int transPrice;
	@JsonIgnore
	@Past
	private Timestamp orderTime;

	public StockExecutedOrder() {
	}

	public StockExecutedOrder(@NotNull int transId, @NotNull int orderId, @NotNull int quantity,
			@NotNull int transPrice, @Past Timestamp orderTime) {
		this.transId = transId;
		this.orderId = orderId;
		this.quantity = quantity;
		this.transPrice = transPrice;
		this.orderTime = orderTime;
	}

	public int getTransId() {
		return transId;
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTransPrice() {
		return transPrice;
	}

	public void setTransPrice(int transPrice) {
		this.transPrice = transPrice;
	}

	public Timestamp getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}

	@Override
	public String toString() {
		return "StockExecutedOrder [transId=" + transId + ", orderId=" + orderId + ", quantity=" + quantity
				+ ", transPrice=" + transPrice + ", orderTime=" + orderTime + "]";
	}

}
