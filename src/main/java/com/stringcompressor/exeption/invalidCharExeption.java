package com.stringcompressor.exeption;

public class invalidCharExeption extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public invalidCharExeption(String message) { super(message); }
}
