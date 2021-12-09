package com.product_management.domain;

import java.util.Date;
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

public class ProductDetails {
	private Long inventoryId;
	private Long buyingPrice;
	private Long minimumSellingPrice;
	private Long batchCode;
	private Date batchDate;
}
