package com.Spring.CustomException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.context.request.WebRequest;

import com.Spring.Bean.Exception.TimelyBean;
import com.Spring.Bean.Exception.GenericExceptionResponse;

/**
 * 
 * @author sunil016, Custom Exception handler class, that makes custom response
 *         body for the user based on what exception is thrown from the business
 *         logic.
 *
 */

@ControllerAdvice
public class ResponseCustomException {

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleAnyExceptions(Exception ex, WebRequest request) {
		String exceptionMessage = ex.getLocalizedMessage();
		if (exceptionMessage == null)
			exceptionMessage = ex.toString();

		GenericExceptionResponse exception = new GenericExceptionResponse(exceptionMessage, HttpStatus.ACCEPTED);
		System.out.println(ex);
		return new ResponseEntity<Object>(exception, new HttpHeaders(), HttpStatus.ACCEPTED);
	}

	@ExceptionHandler(value = { SlotException.class })
	public ResponseEntity<Object> handleSlotExceptions(Exception ex, WebRequest request) {
		String exceptionMessage = ex.getLocalizedMessage();
		if (exceptionMessage == null)
			exceptionMessage = ex.toString();

		TimelyBean BSE = new TimelyBean(exceptionMessage);

		return new ResponseEntity<Object>(BSE, new HttpHeaders(), HttpStatus.ACCEPTED);
	}

	@ExceptionHandler(value = { BookingException.class })
	public ResponseEntity<Object> handleBookingExceptions(Exception ex, WebRequest request) {
		String exceptionMessage = ex.getLocalizedMessage();
		if (exceptionMessage == null)
			exceptionMessage = ex.toString();

		TimelyBean BSE = new TimelyBean(exceptionMessage);

		return new ResponseEntity<Object>(BSE, new HttpHeaders(), HttpStatus.ACCEPTED);
	}

	@ExceptionHandler(value = { AccessDeniedException.class })
	public ResponseEntity<Object> handleUnAuthorizedExceptions(Exception ex, WebRequest request) {
		GenericExceptionResponse exception = new GenericExceptionResponse(
				"Unauthorized Access Reported -- Access Denied", HttpStatus.UNAUTHORIZED);

		return new ResponseEntity<Object>(exception, new HttpHeaders(), HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(value = { MethodArgumentNotValidException.class })
	public ResponseEntity<Object> handleBeanValidationExceptions(Exception ex, WebRequest request) {
		GenericExceptionResponse exception = new GenericExceptionResponse("Please Provide Valid Formated Request Body ",
				HttpStatus.BAD_REQUEST);

		return new ResponseEntity<Object>(exception, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = { InternalServerError.class })
	public ResponseEntity<Object> handle500Exceptions(Exception ex, WebRequest request) {
		GenericExceptionResponse exception = new GenericExceptionResponse("Please Reported this Issue to Developer",
				HttpStatus.INTERNAL_SERVER_ERROR);

		return new ResponseEntity<Object>(exception, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = { Unauthorized.class })
	public ResponseEntity<Object> handle401Exceptions(Exception ex, WebRequest request) {
		GenericExceptionResponse exception = new GenericExceptionResponse("Please Reported this Issue to Developer",
				HttpStatus.UNAUTHORIZED);

		return new ResponseEntity<Object>(exception, new HttpHeaders(), HttpStatus.UNAUTHORIZED);
	}

}
