package com.Spring.Bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection = "stockReceivedOrders")
public class StockReceivedOrder {

	@Id
	@NotNull
	private int order_id;
	@NotNull
	private String stock_name;
	@NotNull
	private String type; // BUY or SELL;
	@NotNull
	private int quantity;
	@NotNull
	private int price;
	@NotNull
	private String time;

	@NotNull
	@JsonIgnore
	private boolean isExecuted;

	public StockReceivedOrder() {
	}

	public StockReceivedOrder(@NotNull int order_id, @NotNull String stock_name, @Length(min = 3, max = 3) String type,
			@NotNull int quantity, @NotNull int price, @Past String time) {
		super();
		this.order_id = order_id;
		this.stock_name = stock_name;
		this.type = type;
		this.quantity = quantity;
		this.price = price;
		this.time = time;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getStock_name() {
		return stock_name;
	}

	public void setStock_name(String stock_name) {
		this.stock_name = stock_name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public boolean isExecuted() {
		return isExecuted;
	}

	public void setExecuted(boolean isExecuted) {
		this.isExecuted = isExecuted;
	}

}
