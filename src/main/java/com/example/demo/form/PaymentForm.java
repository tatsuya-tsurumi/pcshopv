package com.example.demo.form;

import java.sql.Date;

import lombok.Data;

@Data
public class PaymentForm {
	private String userId;
	private String productId;
	private int quantity;
	private Date salesDate;
}
