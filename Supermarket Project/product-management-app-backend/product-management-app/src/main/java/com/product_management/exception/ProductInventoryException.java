package com.product_management.exception;

public class ProductInventoryException extends Exception{
	
	public ProductInventoryException() {
		super();
	}
	
	public ProductInventoryException(String message) {
		super(message);
	}
	
	
	public ProductInventoryException(String message,Throwable t) {
		super(message,t);
	}
	
}
