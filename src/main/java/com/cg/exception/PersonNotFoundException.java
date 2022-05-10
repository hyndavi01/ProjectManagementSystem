package com.cg.exception;

public class PersonNotFoundException extends Exception {

	private static final long serialVersionUID = 2L;

	public PersonNotFoundException(String string) {
		super(string);
	}

}
