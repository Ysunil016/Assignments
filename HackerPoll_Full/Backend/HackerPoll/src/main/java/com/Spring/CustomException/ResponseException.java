package com.Spring.CustomException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.Spring.Bean.Exception.ResponseBean;

// Handling Response Entity

@RestController
@ControllerAdvice
public class ResponseException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
		ResponseBean responseBean = new ResponseBean(ex.getMessage());
		return new ResponseEntity<Object>(responseBean, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = HackerException.class)
	public final ResponseEntity<Object> orderException(Exception ex, WebRequest request) throws Exception {
		ResponseBean responseBean = new ResponseBean(ex.getMessage());
		return new ResponseEntity<Object>(responseBean, HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ResponseBean responseBean = new ResponseBean(ex.getMessage());
		return new ResponseEntity<Object>(responseBean, HttpStatus.BAD_REQUEST);
	}

}
