package com.product_management.bean;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class ProductInventory {
	private Long inventoryId;
	private Long buyingPrice;
	private Long minimumSellingPrice;
	private String batchCode;
	private Date batchDate;
	private Long quantity;
	private Long reorderLevel;
	private String status;
	private Long storeId;
	private Long productMasterId;
}
