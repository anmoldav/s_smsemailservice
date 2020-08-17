package com.anmol.smsemailservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.anmol.smsemailservice.reqresp.ErrorResponse;

@ControllerAdvice
public class ArgumentExceptionHandler  {

	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException illegalArgumentexception) {
		System.out.println("In handleIllegalArgumentException:");
		ErrorResponse errorResponse = new ErrorResponse(401, illegalArgumentexception.getMessage());
		return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);

	}

}
