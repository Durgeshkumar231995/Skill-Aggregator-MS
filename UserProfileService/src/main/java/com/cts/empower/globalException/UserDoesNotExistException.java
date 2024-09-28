package com.cts.empower.globalException;

public class UserDoesNotExistException extends RuntimeException {
	public UserDoesNotExistException(String message) {
		super(message);
	}
}
