package com.Spring.CustomException;

/**
 * 
 * @author sunil016, Custom exception class for Booking
 *
 */
public class HackerException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public HackerException(String message) {
		super(message);
	}

}
