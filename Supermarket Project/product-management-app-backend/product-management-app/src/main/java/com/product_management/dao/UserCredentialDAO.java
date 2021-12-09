package com.product_management.dao;

import java.sql.SQLException;

public interface UserCredentialDAO {
	Boolean isValidCredential(String userName,String password) throws SQLException;
}
