package com.shivam.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerExceptionHandler {

	@ExceptionHandler
	ResponseEntity<CustomerErrorResponse> handleException(CustomerException e){
		CustomerErrorResponse error = new CustomerErrorResponse();
		error.setMsg(e.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.value()	);
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<CustomerErrorResponse>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	ResponseEntity<CustomerErrorResponse> handleExceptionAll(Exception e){
		CustomerErrorResponse error = new CustomerErrorResponse();
		error.setMsg(e.getMessage());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<CustomerErrorResponse>(error,HttpStatus.BAD_REQUEST);
	}
	
}
