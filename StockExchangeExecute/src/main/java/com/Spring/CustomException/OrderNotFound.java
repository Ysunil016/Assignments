package com.Spring.CustomException;


//Exception for Order that is Not Found in Repository
public class OrderNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OrderNotFound(String message) {
		super(message);
	}

}
