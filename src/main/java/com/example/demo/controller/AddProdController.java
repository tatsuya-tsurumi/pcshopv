package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Prod;
import com.example.demo.form.AddProdForm;
import com.example.demo.service.ProdService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AddProdController {
	
	private final ProdService service;
	
	@PostMapping("/add-prod")
	public String addProd(@ModelAttribute AddProdForm form,RedirectAttributes redirectAttributes,
			HttpSession session) {
		
		
		//カートへ商品を追加するをサービス層へ依頼
		@SuppressWarnings("unchecked")
		List<Prod> cart = (List<Prod>) session.getAttribute("cart");
		cart = service.addProd(form, session);
		session.setAttribute("cart", cart);

		
		return "redirect:/complete-add-cart";
	}
}
