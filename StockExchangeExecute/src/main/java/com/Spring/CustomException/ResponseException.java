package com.Spring.CustomException;


// Exception Handler for Service
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

@RestController
@ControllerAdvice
public class ResponseException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
		ResponseBean responseBean = new ResponseBean("Contact to Customer Support", ex.getMessage());
		return new ResponseEntity<Object>(responseBean, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = OrderException.class)
	public final ResponseEntity<Object> orderException(Exception ex, WebRequest request) throws Exception {
		ResponseBean responseBean = new ResponseBean("Order Exception", ex.getMessage());
		return new ResponseEntity<Object>(responseBean, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = OrderNotFound.class)
	public final ResponseEntity<Object> orderNotFoundException(Exception ex, WebRequest request) throws Exception {
		ResponseBean responseBean = new ResponseBean("Order Exception", ex.getMessage());
		return new ResponseEntity<Object>(responseBean, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = CouldNotExecuteOrder.class)
	public final ResponseEntity<Object> orderNotExceuting(Exception ex, WebRequest request) throws Exception {
		ResponseBean responseBean = new ResponseBean("Order Excecutation Exception", ex.getMessage());
		return new ResponseEntity<Object>(responseBean, HttpStatus.FAILED_DEPENDENCY);
	}

	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ResponseBean responseBean = new ResponseBean("Validation Failed", ex.getMessage());
		return new ResponseEntity<Object>(responseBean, HttpStatus.BAD_REQUEST);
	}

}
