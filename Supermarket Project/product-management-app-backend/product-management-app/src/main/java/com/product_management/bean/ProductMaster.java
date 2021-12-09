package com.product_management.bean;

import java.time.LocalDate;


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

public class ProductMaster {
	private Long productMasterId;
	private String category;
	private String type;
	private String brand;
	private String productName;
	private String image;
	private ProductDetails productDetails;
}
