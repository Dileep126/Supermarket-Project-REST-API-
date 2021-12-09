package com.product_management.service;

import java.sql.SQLException;

import com.product_management.dao.UserCredentialDAO;
import com.product_management.dao.UserCredentialDaoImpl;
import com.product_management.exception.CredentialException;

public class UserCredentialServiceImpl implements UserCredentialService{
	private UserCredentialDAO userCredentialDao= new UserCredentialDaoImpl();

	@Override
	public Boolean isValidCredential(String userName, String password) throws CredentialException {
		try {
			Boolean status= userCredentialDao.isValidCredential(userName, password);
			return status;
		}catch(SQLException e) {
			throw new CredentialException(e.getMessage(),e);
		}
	}

}
