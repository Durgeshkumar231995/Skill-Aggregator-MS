package com.cts.empower.globalException;

public class PasswordMismatchException extends RuntimeException {
	public PasswordMismatchException(String message) {
		super(message);
	}
}
