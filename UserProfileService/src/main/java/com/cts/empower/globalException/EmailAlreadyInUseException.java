package com.cts.empower.globalException;

public class EmailAlreadyInUseException extends RuntimeException {
	public EmailAlreadyInUseException(String message) {
		super(message);
	}
}
