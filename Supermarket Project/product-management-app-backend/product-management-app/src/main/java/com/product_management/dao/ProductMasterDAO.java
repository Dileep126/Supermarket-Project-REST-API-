package com.product_management.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.product_management.bean.ProductDetails;
import com.product_management.bean.ProductMaster;

/**
 * Dileep
 *
 */
//The methods in an interface are by default public abstract
//CRUD (Create Read Update Delete) operations

public interface ProductMasterDAO {
	public abstract ProductMaster getProductMasterById(Long productMasterId) throws SQLException;
	String addProductMaster(ProductMaster productMaster) throws SQLException;
	String deleteProductMaster(Long productMasterId) throws SQLException;
	String updateProductMaster(ProductMaster productMaster) throws SQLException;	
	List<ProductMaster> getAllProductMaster() throws SQLException;
}
