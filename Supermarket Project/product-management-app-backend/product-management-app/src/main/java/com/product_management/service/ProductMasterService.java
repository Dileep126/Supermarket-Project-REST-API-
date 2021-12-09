package com.product_management.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.product_management.bean.ProductDetails;
import com.product_management.bean.ProductMaster;
import com.product_management.exception.ProductException;

/**
 * Dileep
 *
 */
//The methods in an interface are by default public abstract
//CRUD (Create Read Update Delete) operations

public interface ProductMasterService {
	public abstract ProductMaster getProductMasterById(Long productMasterId) throws ProductException;
	String addProductMaster(ProductMaster productMaster) throws ProductException;
	String deleteProductMaster(Long productMasterId) throws ProductException;
	String updateProductMaster(ProductMaster productMaster) throws ProductException;	
	List<ProductMaster> getAllProductMaster() throws ProductException;
}
