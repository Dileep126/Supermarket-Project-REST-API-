package com.product_management.service;

import com.product_management.exception.CredentialException;

public interface UserCredentialService {
	Boolean isValidCredential(String userName,String password) throws CredentialException;
}
