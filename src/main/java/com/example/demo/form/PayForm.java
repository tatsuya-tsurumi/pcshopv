package com.example.demo.form;

import java.sql.Date;

import lombok.Data;

@Data
public class PayForm {
	private String userId;
	private String productId;
	private int quantity;
	private Date salesDate;
}
