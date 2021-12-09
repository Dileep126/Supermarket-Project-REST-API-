package com.product_management.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.product_management.bean.ProductDetails;
import com.product_management.dao.ProductMasterDAO;
import com.product_management.dao.ProductMasterDaoImpl;
import com.product_management.bean.ProductMaster;
import com.product_management.exception.ProductException;
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
public class ProductMasterServiceImpl implements ProductMasterService{
	private ProductMasterDAO productMasterDao= new ProductMasterDaoImpl();

	@Override
	public ProductMaster getProductMasterById(Long productCode) throws ProductException {
		try {				
			ProductMaster productMaster= productMasterDao.getProductMasterById(productCode);
			return productMaster;
		}catch(SQLException e) {
			throw new ProductException(e.getMessage(),e);
		}	
	}

	@Override
	public String addProductMaster(ProductMaster productMaster) throws ProductException {
		try {
			String result= productMasterDao.addProductMaster(productMaster);
			return result;
		}catch(SQLException e) {
			throw new ProductException(e.getMessage(),e);
		}		
	}

	@Override
	public String deleteProductMaster(Long productCode) throws ProductException {
		try {			
			String message= productMasterDao.deleteProductMaster(productCode);
			return message;
		}catch(SQLException e) {
			throw new ProductException(e.getMessage(),e);
		}	
	}

	@Override
	public String updateProductMaster(ProductMaster productMaster) throws ProductException {
		try {			
			String message= productMasterDao.updateProductMaster(productMaster);
			return message;
		}catch(SQLException e) {
			throw new ProductException(e.getMessage(),e);
		}	
	}

	@Override
	public List<ProductMaster> getAllProductMaster() throws ProductException {
		try {
			List<ProductMaster> productMasterList= productMasterDao.getAllProductMaster();
			return productMasterList;
		}catch(SQLException e) {
			throw new ProductException(e.getMessage(),e);
		}	
	}

}
