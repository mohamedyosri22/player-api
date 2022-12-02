package com.spring.playerapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class ControllerException {
	
	@ExceptionHandler
	public ResponseEntity<PlayerError> getExceptionNotFound(PlayerException pe) {
		PlayerError p = new PlayerError();
		p.setStatusCode(HttpStatus.NOT_FOUND.value());
		p.setMessage(pe.getMessage());
		p.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<PlayerError>(p, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<PlayerError> getException(Exception se) {
		PlayerError s = new PlayerError();
		s.setStatusCode(HttpStatus.BAD_REQUEST.value());
		s.setMessage(se.getMessage());
		s.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<PlayerError>(s, HttpStatus.BAD_REQUEST);
	} 
}
