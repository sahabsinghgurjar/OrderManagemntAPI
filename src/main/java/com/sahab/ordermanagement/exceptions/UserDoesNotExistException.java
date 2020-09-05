package com.sahab.ordermanagement.exceptions;

public class UserDoesNotExistException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UserDoesNotExistException() {
		super("User does not Exist.");
	}

}
