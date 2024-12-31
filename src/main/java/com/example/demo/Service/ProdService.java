package com.example.demo.Service;

import java.util.List;

import com.example.demo.entity.Prod;
import com.example.demo.form.AddProdForm;

import jakarta.servlet.http.HttpSession;

public interface ProdService {
	//DBから全商品を検索する処理
	List<Prod> findByProd();
	//商品をカートへ追加する処理
	List<Prod> addProd(AddProdForm form, HttpSession session);
	//カート内商品の削除処理
	void removeProd(int idx, HttpSession session);
	
	//カート内の商品を購入する処理
	int payProd(List<Prod> cart,HttpSession session);
	
	//DBから過去に購入した商品を検索する処理
	List<Prod> findByUserId(String userId);
}
