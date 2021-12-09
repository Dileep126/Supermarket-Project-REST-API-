package com.product_management.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.product_management.bean.ProductInventory;
import com.product_management.dao.ProductInventoryDAO;
import com.product_management.dao.ProductInventoryDaoImpl;
import com.product_management.exception.ProductException;
import com.product_management.exception.ProductInventoryException;
/**
 * 
 * @author Srini
 * In the Service layer, we catch SQL exceptions thrown by the methods of DAO layer
 * and convert them to custom exceptions so that the UI layer
 * receives only business-related exception shielding from SQL exceptions.
 * 
 * 
 * We are implementing layered architecture.
 * Layered architecture provides a clean separation between the 
	business implementation, presentation and data-access logic.
	
	Layered architecture provides "separation of concerns"

 */
public class ProductInventoryServiceImpl implements ProductInventoryService{
	private ProductInventoryDAO productInventoryDao= new ProductInventoryDaoImpl();
	

	@Override
	public ProductInventory getProductInventoryById(Long inventoryId) throws ProductInventoryException {
		try {				
			ProductInventory productInventory= productInventoryDao.getProductInventoryById(inventoryId);
			return productInventory;
		}catch(SQLException e) {
			throw new ProductInventoryException(e.getMessage(),e);
		}	
	}

	@Override
	public String addProductInventory(ProductInventory productInventory) throws ProductInventoryException {
		try {
			String result= productInventoryDao.addProductInventory(productInventory);
			return result;
		}catch(SQLException e) {
			throw new ProductInventoryException(e.getMessage(),e);
		}		
	}

	@Override
	public String deleteProductInventory(Long inventoryId) throws ProductInventoryException {
		try {			
			String message= productInventoryDao.deleteProductInventory(inventoryId);
			return message;
		}catch(SQLException e) {
			throw new ProductInventoryException(e.getMessage(),e);
		}	
	}

	@Override
	public String updateProductInventory(ProductInventory productInventory) throws ProductInventoryException{
		try {			
			String message= productInventoryDao.updateProductInventory(productInventory);
			return message;
		}catch(SQLException e) {
			throw new ProductInventoryException(e.getMessage(),e);
		}	
	}

	@Override
	public List<ProductInventory> getAllProductInventory() throws ProductInventoryException{
		try {
			List<ProductInventory> productInventoryList= productInventoryDao.getAllProductInventory();
			return productInventoryList;
		}catch(SQLException e) {
			throw new ProductInventoryException(e.getMessage(),e);
		}	
	}

}
