package com.example.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.exception.UserNotFoundByIdException;

@ControllerAdvice
public class ApplicationExceptionHandler {
  @ExceptionHandler
	public ResponseEntity<ErrorStructure> handleUserNotById(UserNotFoundByIdException ex) {
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(),ex.getMessage(),"User Not found for the given Id"));
  }

}
