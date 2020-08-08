package com.Spring.CustomException;

public class CouldNotExecuteOrder extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CouldNotExecuteOrder(String message) {
		super(message);
	}

}
