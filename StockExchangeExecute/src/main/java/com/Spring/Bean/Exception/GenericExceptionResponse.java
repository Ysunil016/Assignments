package com.Spring.Bean.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

/**
 * 
 * @author sunil016, General Bean for all type of exceptions
 *
 */

// General Response Bean
public class GenericExceptionResponse {
	private Date timestamp;
	private String message;
	private HttpStatus status;

	public GenericExceptionResponse(String message, HttpStatus status) {
		this.timestamp = new Date();
		this.message = message;
		this.status = status;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
