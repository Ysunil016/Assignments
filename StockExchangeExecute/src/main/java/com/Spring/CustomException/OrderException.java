package com.Spring.CustomException;

/**
 * 
 * @author sunil016, Custom exception class for Booking
 *
 */
public class OrderException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OrderException(String message) {
		super(message);
	}

}
