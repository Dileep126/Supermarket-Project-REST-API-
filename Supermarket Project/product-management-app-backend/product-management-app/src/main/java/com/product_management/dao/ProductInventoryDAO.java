package com.product_management.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.product_management.bean.ProductInventory;

public interface ProductInventoryDAO {
	
	public abstract ProductInventory getProductInventoryById(Long inventoryId) throws SQLException;
	String addProductInventory(ProductInventory productInventory) throws SQLException;
	String deleteProductInventory(Long inventoryId) throws SQLException;
	String updateProductInventory(ProductInventory productInventory) throws SQLException;	
	List<ProductInventory> getAllProductInventory() throws SQLException;
}
