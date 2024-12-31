package com.example.demo.entity;

import java.sql.Date;

import lombok.Data;

@Data
public class Prod {
	private String userId;
	private String userName;
	private int salesId;
	private String productId;
	private String productName;
	private String price;
	private int quantity;
	private Date salesDate;
	private String imgId; 
}
