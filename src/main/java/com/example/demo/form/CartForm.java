package com.example.demo.form;

import java.util.List;

import lombok.Data;

@Data
public class CartForm {
	private String userId;
	private List<AddProdForm> listProd;
	
	public void remove(int index) {
		listProd.remove(index);
	}
}
