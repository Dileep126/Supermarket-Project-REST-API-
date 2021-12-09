package com.product_management.dao;
/**
 * 
 * @author Srini
 *	This interface contains the SQL statements to manipulate tax_master table
 */
//public static final is by default implicit
public interface QueryMapper {
	public static final String ADD_PRODUCT = "insert into product_master values(?,?,?,?,?,?,?)";
	String DELETE_PRODUCT = "delete from product_master where product_master_id=?";
	String GET_PRODUCT="select * from product_master where product_master_id=?";
	String UPDATE_PRODUCT="update product_master set category=?,type=?,brand=?,product_name=?,image=?,product_details=? where product_master_id=?";
	String GET_ALL_PRODUCT="select * from product_master";
	String GET_USER_CREDENTIAL= "select * from user_credential where user_name=? and password=?";
}
