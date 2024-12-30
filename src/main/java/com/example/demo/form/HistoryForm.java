package com.example.demo.form;

import java.sql.Date;

import lombok.Data;

@Data
public class HistoryForm {
	private int userId;
	private int salesId;
	private String productId;
	private String productName;
	private int price;
	private int quantity;
	private Date salesDate;
}
