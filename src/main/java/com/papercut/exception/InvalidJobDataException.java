package com.papercut.exception;

public class InvalidJobDataException extends RuntimeException{
	private static final long serialVersionUID = -4693870828975748063L;

	public InvalidJobDataException(String message, Throwable cause) {
        super(message, cause);
    }

}
