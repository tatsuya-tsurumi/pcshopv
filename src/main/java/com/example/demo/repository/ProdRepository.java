package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Prod;
import com.example.demo.form.AddProdForm;

import jakarta.servlet.http.HttpSession;

public interface ProdRepository {
	List<Prod> selectByProd();
	void insertProd(List<AddProdForm> form, HttpSession session);
	List<Prod> selectByUserId(String userId);
	
}
