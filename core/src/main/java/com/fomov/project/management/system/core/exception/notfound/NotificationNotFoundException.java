package com.fomov.project.management.system.core.exception.notfound;

public class NotificationNotFoundException extends RuntimeException {
	public NotificationNotFoundException() {
		super();
	}

	public NotificationNotFoundException(String message) {
		super(message);
	}

	public NotificationNotFoundException(Exception e) {
		super(e);
	}

	public NotificationNotFoundException(String message, Exception e) {
		super(message, e);
	}
}