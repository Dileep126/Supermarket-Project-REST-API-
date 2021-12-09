package com.product_management.bean;

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
public class UserCredential {
	private Integer userId;
	private String userName;
	private String password;
	private String email;
	private Long roleId;
}
