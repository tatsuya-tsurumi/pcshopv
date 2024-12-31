package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Prod;

import jakarta.servlet.http.HttpSession;

public interface ProdRepository {
	List<Prod> selectByProd();
	int insertProd(List<Prod> form, HttpSession session);
	List<Prod> selectByUserId(String userId);
	
}
