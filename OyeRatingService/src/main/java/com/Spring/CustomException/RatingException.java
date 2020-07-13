package com.Spring.CustomException;

/**
 * 
 * @author sunil016, Custom exception class for Booking
 *
 */
public class RatingException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RatingException(String message) {
		super(message);
	}

}
