package com.product_management.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class DBCPDataSource {    
	private static BasicDataSource ds = new BasicDataSource();
	private DBCPDataSource(){ }
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			ds.setUrl("jdbc:mysql://localhost:3306/product_management");
			ds.setUsername("root");
			ds.setPassword("1229");
			ds.setMinIdle(5);
			ds.setMaxIdle(10);
			ds.setMaxOpenPreparedStatements(100);
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}

	}

	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}


}