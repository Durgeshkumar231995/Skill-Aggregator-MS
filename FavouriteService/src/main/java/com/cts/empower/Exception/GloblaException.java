package com.cts.empower.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GloblaException {

	@ExceptionHandler(FavouriteItemIsAbsentException.class)
	public ResponseEntity<String> handleFavouriteItemIsAbsentException(FavouriteItemIsAbsentException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	}
	@ExceptionHandler(FavouriteIsAddedAlreadyException.class)
	public ResponseEntity<String> FavouriteIsAddedAlreadyException(FavouriteIsAddedAlreadyException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	}
}
