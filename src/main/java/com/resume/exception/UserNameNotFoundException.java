package com.resume.exception;
@SuppressWarnings("serial")
public class UserNameNotFoundException extends RuntimeException {
	public UserNameNotFoundException(String message) {
		super(message);
	}
}
