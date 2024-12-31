package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Prod;
import com.example.demo.form.AddProdForm;
import com.example.demo.repository.ProdRepository;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdServiceImpl implements ProdService {
	
	private final ProdRepository repository;

	//DBから全商品を検索する処理
	@Override
	public List<Prod> findByProd() {
		// TODO 自動生成されたメソッド・スタブ
		List<Prod> list = repository.selectByProd();
		return list;
	}

	//商品をカートへ追加する処理
	@Override
	public List<Prod> addProd(AddProdForm form, HttpSession session) {
		// TODO 自動生成されたメソッド・スタブ
		
		@SuppressWarnings("unchecked")
		List<Prod> cart = (List<Prod>) session.getAttribute("cart");
		Prod prod = new Prod();
		prod.setProductId(form.getProductId());
		prod.setProductName(form.getProductName());
		prod.setPrice(form.getPrice());
		prod.setImgId(form.getImgId());
		cart.add(prod);
		 
		 return cart;

	}

	//カート内の商品を購入する処理
	@Override
	public void payProd(List<AddProdForm> form, HttpSession session) {
		// 実際のDBアクセスをインフラ層へ依頼
		repository.insertProd(form, session);
		
		int sum = 0;
		
		@SuppressWarnings("unchecked")
		List<AddProdForm> cart = (List<AddProdForm>) session.getAttribute("cart");
		for(AddProdForm num : cart) {
			sum += Integer.parseInt(num.getPrice());
		}
		
		
		session.setAttribute("sum", sum);
	}
	
	//DBから過去に購入した商品を検索する処理
	@Override
	public List<Prod> findByUserId(String userId) {
		
		// 実際のDBアクセスをインフラ層へ依頼
		List<Prod> list = repository.selectByUserId(userId);
		return list;
	}	
}
