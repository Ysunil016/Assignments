package com.Spring.Bean.Exception;

import java.util.Date;

/**
 * 
 * @author sunil016, Custom Timely Bean for Special type of exceptions
 *
 */

// Response Bean
public class ResponseBean {

	private Date timestamp;
	private Object message;
	private Object description;

	public ResponseBean(Object message, Object description) {
		this.timestamp = new Date();
		this.message = message;
		this.description = description;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Object getMessage() {
		return message;
	}

	public Object getDescription() {
		return description;
	}

	public void setDescription(Object description) {
		this.description = description;
	}

	public void setMessage(Object message) {
		this.message = message;
	}

}
