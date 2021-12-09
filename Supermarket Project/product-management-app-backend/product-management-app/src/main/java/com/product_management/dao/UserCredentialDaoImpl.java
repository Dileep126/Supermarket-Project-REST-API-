package com.product_management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.product_management.util.DBCPDataSource;
import com.product_management.util.MySQLConnection;

public class UserCredentialDaoImpl implements UserCredentialDAO{

	@Override
	public Boolean isValidCredential(String userName, String password) throws SQLException {
		try(
				Connection connection= DBCPDataSource.getConnection();
				PreparedStatement preparedStatement= connection.prepareStatement(QueryMapper.GET_USER_CREDENTIAL);
			) {
			
				preparedStatement.setString(1, userName);
				preparedStatement.setString(2, password);
				ResultSet resultSet=preparedStatement.executeQuery();
				if(resultSet.next()) {					
					return true;
				}else {
					return false;
				}
			}catch(SQLException e) {
				throw e;
			}catch(Exception e) {
				throw new SQLException(e.getMessage());
			}
	}

}
