package com.cts.empower.globalException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	@ExceptionHandler(EmailAlreadyInUseException.class)
	public ResponseEntity<String> handleEmailAlreadyInUseException(EmailAlreadyInUseException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	}
	@ExceptionHandler(PasswordMismatchException.class)
	public ResponseEntity<String> handlePasswordMismatchException(PasswordMismatchException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	}
	@ExceptionHandler(UserDoesNotExistException.class)
	public ResponseEntity<String> handleUserDoesNotExistException(UserDoesNotExistException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	}
}
