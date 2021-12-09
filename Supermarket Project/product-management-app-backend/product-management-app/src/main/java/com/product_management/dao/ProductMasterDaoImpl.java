package com.product_management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.product_management.bean.ProductDetails;
import com.product_management.bean.ProductMaster;
import com.product_management.util.DBCPDataSource;
/**
 * 
 * @author Dileep
 *	DDL and static queries : Statement
 *  DML and Dynamic queries: PreparedStatement
 *  Calling stored procedures/functions: CallableStatement
 */
public class ProductMasterDaoImpl implements ProductMasterDAO{

	@Override
	public ProductMaster getProductMasterById(Long productMasterId) throws SQLException {
		try(
				Connection connection= DBCPDataSource.getConnection();
				PreparedStatement preparedStatement= connection.prepareStatement(QueryMapper.GET_PRODUCT);
			) {
			
				preparedStatement.setLong(1, productMasterId);
				ResultSet resultSet=preparedStatement.executeQuery();
				if(resultSet.next()) {
					ProductMaster productMaster= new ProductMaster();
					
					populateProductMaster(resultSet,productMaster);
					return productMaster;
				}else {
					throw new Exception("Invalid Product ID");
				}
			}catch(SQLException e) {
				throw e;
			}catch(Exception e) {
				throw new SQLException(e.getMessage());
			}
	}

	private void populateProductMaster(ResultSet resultSet, ProductMaster productMaster) throws SQLException{
		productMaster.setProductMasterId(resultSet.getLong("product_master_id"));
		productMaster.setProductName(resultSet.getString("product_name"));
		productMaster.setCategory(resultSet.getString("category"));
		productMaster.setBrand(resultSet.getString("brand"));
		productMaster.setType(resultSet.getString("type"));
		productMaster.setImage(null);
		
		String object=(resultSet.getObject("product_details")).toString();
		JSONObject jsonObject=new JSONObject(object);
		ProductDetails details=new ProductDetails();
		details.setColor(jsonObject.getString("color"));
		details.setSize(jsonObject.getString("size"));
		details.setSpecific_details(jsonObject.getString("specific_details"));
		details.setWeight(jsonObject.getString("weight"));
		
		productMaster.setProductDetails(details);
	}

	@Override
	public String addProductMaster(ProductMaster productMaster) throws SQLException {
		
		try(
			Connection connection= DBCPDataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(QueryMapper.ADD_PRODUCT);
		) {
			
			preparedStatement.setLong(1, productMaster.getProductMasterId());
			preparedStatement.setString(2, productMaster.getCategory());
			preparedStatement.setString(3, productMaster.getType());
			preparedStatement.setString(4, productMaster.getBrand());
			preparedStatement.setString(5, productMaster.getProductName());
			preparedStatement.setNull(6, Types.BLOB);
			
			ProductDetails productDetails=productMaster.getProductDetails();
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("color", productDetails.getColor());
			jsonObject.put("size", productDetails.getSize());
			jsonObject.put("specific_details", productDetails.getSpecific_details());
			jsonObject.put("weight", productDetails.getWeight());
			String object=jsonObject.toString();
		
			preparedStatement.setString(7, object);
			
			int result=preparedStatement.executeUpdate();
			if(result>0) {
				return "One Product Added";
			}else {
				throw new Exception("Unable to add Product");
			}
			
		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}
		
	}

	@Override
	public String deleteProductMaster(Long productCode) throws SQLException {
		try(
				Connection connection= DBCPDataSource.getConnection();
				PreparedStatement preparedStatement= connection.prepareStatement(QueryMapper.DELETE_PRODUCT);
			) {
			
				preparedStatement.setLong(1, productCode);
				
				int result = preparedStatement.executeUpdate();
				if(result>0) {
					return "Record with Product ID,"+productCode+" deleted";
				}else {
					throw new Exception("Invalid Product ID");
				}
			}catch(SQLException e) {
				throw e;
			}catch(Exception e) {
				throw new SQLException(e.getMessage());
			}
	}


	@Override
	public String updateProductMaster(ProductMaster productMaster) throws SQLException {
		try(
				Connection connection= DBCPDataSource.getConnection();
				PreparedStatement preparedStatement= connection.prepareStatement(QueryMapper.UPDATE_PRODUCT);
			) {
			
				preparedStatement.setString(1, productMaster.getCategory());
				preparedStatement.setString(2, productMaster.getType());
				preparedStatement.setString(3, productMaster.getBrand());
				preparedStatement.setString(4, productMaster.getProductName());
				preparedStatement.setNull(5, Types.BLOB);
				
				ProductDetails productDetails=productMaster.getProductDetails();
				JSONObject jsonObject=new JSONObject();
				jsonObject.put("color", productDetails.getColor());
				jsonObject.put("size", productDetails.getSize());
				jsonObject.put("specific_details", productDetails.getSpecific_details());
				jsonObject.put("weight", productDetails.getWeight());
				String object=jsonObject.toString();
				
				preparedStatement.setString(6, object);
				preparedStatement.setLong(7, productMaster.getProductMasterId());
				
				int result = preparedStatement.executeUpdate();
				if(result>0) {
					return "Record with Product ID,"+productMaster.getProductMasterId()+" updated";
				}else {
					throw new Exception("Invalid Product ID");
				}
			}catch(SQLException e) {
				throw e;
			}catch(Exception e) {
				throw new SQLException(e.getMessage());
			}
	}

	@Override
	public List<ProductMaster> getAllProductMaster() throws SQLException {
		try(
				Connection connection= DBCPDataSource.getConnection();
				Statement statement= connection.createStatement();
			) {			
				
				ResultSet resultSet=statement.executeQuery(QueryMapper.GET_ALL_PRODUCT);
				List<ProductMaster>  productMasterList= new ArrayList<>();
				while(resultSet.next()) {
					ProductMaster productMaster= new ProductMaster();
					
					populateProductMaster(resultSet,productMaster);
					productMasterList.add(productMaster);
				}
				if(productMasterList.size()==0) {
					throw new Exception("Product Master table is empty");
				}
				return productMasterList;
			}catch(SQLException e) {
				throw e;
			}catch(Exception e) {
				throw new SQLException(e.getMessage());
			}
	}

	

}
