package com.fomov.project.management.system.core.exception.notfound;

public class TaskNotFoundException extends RuntimeException {
	public TaskNotFoundException() {
		super();
	}

	public TaskNotFoundException(String message) {
		super(message);
	}

	public TaskNotFoundException(Exception e) {
		super(e);
	}

	public TaskNotFoundException(String message, Exception e) {
		super(message, e);
	}
}
