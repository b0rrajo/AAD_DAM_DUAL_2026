package com.carballeira.jdbc;

public class DniAlreadyExistsException extends Exception {
	public DniAlreadyExistsException(String message) {
		super(message);
	}
}
