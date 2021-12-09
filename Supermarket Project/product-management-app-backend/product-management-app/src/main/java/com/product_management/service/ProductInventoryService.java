package com.product_management.service;

import java.util.Date;
import java.util.List;

import com.product_management.bean.ProductInventory;
import com.product_management.bean.ProductMaster;
import com.product_management.exception.ProductException;
import com.product_management.exception.ProductInventoryException;

public interface ProductInventoryService {
	public abstract ProductInventory getProductInventoryById(Long inventoryrId) throws ProductInventoryException;
	String addProductInventory(ProductInventory productInventory) throws ProductInventoryException;
	String deleteProductInventory(Long inventoryId) throws ProductInventoryException;
	String updateProductInventory(ProductInventory productInventory) throws ProductInventoryException;	
	List<ProductInventory> getAllProductInventory() throws ProductInventoryException;

}
