package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Service.ProdService;
import com.example.demo.form.AddProdForm;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class PayController {
	
	private final ProdService service;
	
	@PostMapping("pay")
	public String pay(AddProdForm form, RedirectAttributes redirectAttributes,
			HttpSession session) {
		
		@SuppressWarnings("unchecked")
		List<AddProdForm> cart = (List<AddProdForm>) session.getAttribute("cart");
		
		//支払い処理をサービス層へ依頼
		service.payProd(cart,session);
		
		
		redirectAttributes.addFlashAttribute("cart", cart);
		
		session.setAttribute("cart", new ArrayList<>());
		
		return "redirect:/complete-pay";
	}
	
}
