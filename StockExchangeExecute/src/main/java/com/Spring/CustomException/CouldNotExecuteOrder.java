package com.Spring.CustomException;


// Exception for Order that Could not Eexcute
public class CouldNotExecuteOrder extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CouldNotExecuteOrder(String message) {
		super(message);
	}

}
