package com.Spring.Service.Implementation;

import java.util.Date;

import org.springframework.stereotype.Service;

/**
 * 
 * @author sunil016 Additional service class, that holds additional functions
 *         required in multiple services class.
 */

@Service
public class HelperService {

	public String getDate() {
		Date date = new Date();
		@SuppressWarnings("deprecation")
		int dateValue = date.getDate() + date.getMonth() + 1 + date.getYear();
		return String.valueOf(dateValue);
	}

	public Date getTodayDate() {
		return new Date();
	}

}
