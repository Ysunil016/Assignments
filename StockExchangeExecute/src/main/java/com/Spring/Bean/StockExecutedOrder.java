package com.Spring.Bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

// Bean Class for Exceuted Order, that Holds Structure for Exceuted Orders.

@Document("stockExecutedOrders")
public class StockExecutedOrder {

	@Id
	@NotNull
	private String trans_id; // Transaction ID

	@NotNull
	private int order_id; // Order ID
	@NotNull
	private int quantity;
	@NotNull
	private int price;
	@JsonIgnore
	private String time;

	public StockExecutedOrder() {
	}

	public StockExecutedOrder(@NotNull String type, @NotNull int order_id, @NotNull int quantity, @NotNull int price,
			@Past String time) {
		this.trans_id = type + "" + String.valueOf(order_id);
		this.order_id = order_id;
		this.quantity = quantity;
		this.price = price;
		this.time = time;
	}

	public String getTrans_id() {
		return trans_id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
