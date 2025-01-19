package com.fomov.project.management.system.core.exception.notfound;

public class CommentNotFoundException extends RuntimeException {
	public CommentNotFoundException() {
		super();
	}

	public CommentNotFoundException(String message) {
		super(message);
	}

	public CommentNotFoundException(Exception e) {
		super(e);
	}

	public CommentNotFoundException(String message, Exception e) {
		super(message, e);
	}
}
