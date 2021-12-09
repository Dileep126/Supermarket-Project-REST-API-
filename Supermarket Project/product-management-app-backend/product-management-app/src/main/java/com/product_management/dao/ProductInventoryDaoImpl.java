package com.product_management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.product_management.bean.ProductInventory;
import com.product_management.util.DBCPDataSource;

public class ProductInventoryDaoImpl implements ProductInventoryDAO {

	@Override
	public ProductInventory getProductInventoryById(Long inventoryId	) throws SQLException {
		try(
				Connection connection= DBCPDataSource.getConnection();
				PreparedStatement preparedStatement= connection.prepareStatement(QueryMapperInv.GET_PRODUCT_INVENTORY);
			) {
			
				preparedStatement.setLong(1, inventoryId);
				ResultSet resultSet=preparedStatement.executeQuery();
				if(resultSet.next()) {
					ProductInventory productInventory= new ProductInventory();
					
					populateProductInventory(resultSet,productInventory);
					return productInventory;
				}else {
					throw new Exception("Invalid Product ID");
				}
			}catch(SQLException e) {
				throw e;
			}catch(Exception e) {
				throw new SQLException(e.getMessage());
			}
	}
	
	private void populateProductInventory(ResultSet resultSet, ProductInventory productInventory) throws SQLException{
		productInventory.setInventoryId(resultSet.getLong("inventory_id"));
		productInventory.setBuyingPrice(resultSet.getLong("buying_price"));
		productInventory.setMinimumSellingPrice(resultSet.getLong("minimum_selling_price"));
		productInventory.setBatchCode(resultSet.getString("batch_code"));
		productInventory.setBatchDate(resultSet.getDate("batch_date"));
		productInventory.setQuantity(resultSet.getLong("quantity"));
		productInventory.setReorderLevel(resultSet.getLong("reorder_level"));
		productInventory.setStatus(resultSet.getString("status"));
		productInventory.setStoreId(resultSet.getLong("store_id"));
		productInventory.setProductMasterId(resultSet.getLong("product_master_id"));
	}

	@Override
	public String addProductInventory(ProductInventory productInventory) throws SQLException {
		
				try(
					Connection connection= DBCPDataSource.getConnection();
					PreparedStatement preparedStatement= connection.prepareStatement(QueryMapperInv.ADD_PRODUCT_INVENTORY);
				) {
					
					preparedStatement.setLong(1, productInventory.getInventoryId());
					preparedStatement.setLong(2, productInventory.getBuyingPrice());
					preparedStatement.setLong(3, productInventory.getMinimumSellingPrice());
					preparedStatement.setString(4, productInventory.getBatchCode());
					preparedStatement.setDate(5, productInventory.getBatchDate());
					preparedStatement.setLong(6, productInventory.getQuantity());
					preparedStatement.setLong(7, productInventory.getReorderLevel());
					preparedStatement.setString(8, productInventory.getStatus());
					preparedStatement.setLong(9, productInventory.getStoreId());
					preparedStatement.setLong(10, productInventory.getProductMasterId());
					
					int result=preparedStatement.executeUpdate();
					if(result>0) {
						return "One Product Inventory added";
					}else {
						throw new Exception("Unable to add Product Inventory");
					}
					
				}catch(SQLException e) {
					throw e;
				}catch(Exception e) {
					throw new SQLException(e.getMessage());
				}
		
	}

	@Override
	public String deleteProductInventory(Long inventoryId) throws SQLException {
		try(
				Connection connection= DBCPDataSource.getConnection();
				PreparedStatement preparedStatement= connection.prepareStatement(QueryMapperInv.DELETE_PRODUCT_INVENTORY);
			) {
			
				preparedStatement.setLong(1, inventoryId);
				
				int result = preparedStatement.executeUpdate();
				if(result>0) {
					return "Record with Product Inventory id ,"+inventoryId+" deleted";
				}else {
					throw new Exception("Invalid Inventory Id");
				}
			}catch(SQLException e) {
				throw e;
			}catch(Exception e) {
				throw new SQLException(e.getMessage());
			}
	}

	@Override
	public String updateProductInventory(ProductInventory productInventory)throws SQLException {
		try(
				Connection connection= DBCPDataSource.getConnection();
				PreparedStatement preparedStatement= connection.prepareStatement(QueryMapperInv.UPDATE_PRODUCT_INVENTORY);
			) {
				
				preparedStatement.setLong(1, productInventory.getBuyingPrice());
				preparedStatement.setLong(2, productInventory.getMinimumSellingPrice());
				preparedStatement.setString(3, productInventory.getBatchCode());
				preparedStatement.setDate(4, productInventory.getBatchDate());
				preparedStatement.setLong(5, productInventory.getQuantity());
				preparedStatement.setLong(6, productInventory.getReorderLevel());
				preparedStatement.setString(7, productInventory.getStatus());
				preparedStatement.setLong(8, productInventory.getStoreId());
				preparedStatement.setLong(9, productInventory.getProductMasterId());
				preparedStatement.setLong(10, productInventory.getInventoryId());
				
				int result = preparedStatement.executeUpdate();
				if(result>0) {
					return "Record with Product Inventory ID,"+productInventory.getInventoryId()+" updated";
				}else {
					throw new Exception("Invalid Product Inventory ID");
				}
			}catch(SQLException e) {
				throw e;
			}catch(Exception e) {
				throw new SQLException(e.getMessage());
			}
	}

	@Override
	public List<ProductInventory> getAllProductInventory() throws SQLException {
		try(
				Connection connection= DBCPDataSource.getConnection();
				Statement statement= connection.createStatement();
			) {			
				
				ResultSet resultSet=statement.executeQuery(QueryMapperInv.GET_ALL_PRODUCT_INVENTORY);
				List<ProductInventory>  productInventoryList= new ArrayList<>();
				while(resultSet.next()) {
					ProductInventory productInventory= new ProductInventory();
					
					populateProductInventory(resultSet,productInventory);
					productInventoryList.add(productInventory);
				}
				if(productInventoryList.size()==0) {
					throw new Exception("product Inventory table is empty");
				}
				return productInventoryList;
			}catch(SQLException e) {
				throw e;
			}catch(Exception e) {
				throw new SQLException(e.getMessage());
			}
	}


}
