package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.form.AddProdForm;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AddProdController {
	
	@PostMapping("/add-prod")
	public String addProd(@ModelAttribute AddProdForm form,RedirectAttributes redirectAttributes,
			HttpSession session) {
		
		//カートへ商品を追加するをサービス層へ依頼
		@SuppressWarnings("unchecked")
		List<AddProdForm> cart = (List<AddProdForm>) session.getAttribute("cart");
		cart.add(form);
		session.setAttribute("cart", cart);

		
		return "redirect:/complete-add-cart";
	}
}
