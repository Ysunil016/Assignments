package com.Spring.Bean.Exception;

import java.util.Date;

/**
 * 
 * @author sunil016, Custom Timely Bean for Special type of exceptions
 *
 */

public class ResponseBean {

	private Date timestamp;
	private Object message;

	public ResponseBean(Object message) {
		this.timestamp = new Date();
		this.message = message;
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

	public void setMessage(Object message) {
		this.message = message;
	}

}
