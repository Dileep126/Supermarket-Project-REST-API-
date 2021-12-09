package com.product_management.exception;

public class ProductException extends Exception {

	public ProductException() {

	}

	public ProductException(String message) {
		super(message);
	}
	
	public ProductException(String message, Throwable t) {
		super(message,t);
	}
}
