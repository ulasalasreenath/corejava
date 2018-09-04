package org.speakingcs.exceptions;

public class MyException extends RuntimeException{

	private static final long serialVersionUID = -9212747572017326912L;

	public MyException(String message) {
		super(message);
	}

}
