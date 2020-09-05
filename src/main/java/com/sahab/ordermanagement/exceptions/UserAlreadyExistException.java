package com.sahab.ordermanagement.exceptions;

public class UserAlreadyExistException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UserAlreadyExistException() {
		super("User Already Exist.");
	}

}
