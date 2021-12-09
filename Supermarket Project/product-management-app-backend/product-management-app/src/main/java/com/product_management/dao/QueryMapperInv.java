package com.product_management.dao;

public interface QueryMapperInv {

	public static final String ADD_PRODUCT_INVENTORY = "insert into product_inventory values(?,?,?,?,?,?,?,?,?,?)";
	String DELETE_PRODUCT_INVENTORY = "delete from product_inventory where inventory_id=?";
	String GET_PRODUCT_INVENTORY="select * from product_inventory where inventory_id=?";
	String UPDATE_PRODUCT_INVENTORY="update product_inventory set buying_price=?,minimum_selling_price=?, batch_code=?,batch_date=?,quantity=?,reorder_level=?,status=?,store_id=?,product_master_id=? where inventory_id=?";
	String GET_ALL_PRODUCT_INVENTORY="select * from product_inventory";
	String GET_USER_CREDENTIAL= "select * from user_credential where user_name=? and password=?";
}
