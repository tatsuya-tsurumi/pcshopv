package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Service.ProdService;
import com.example.demo.entity.Prod;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class PayController {
	
	private final ProdService service;
	
	@PostMapping("pay")
	public String pay(@ModelAttribute Prod form, RedirectAttributes redirectAttributes,
			HttpSession session, Model model) {
		int cnt = 0;
		@SuppressWarnings("unchecked")
		List<Prod> cart = (List<Prod>) session.getAttribute("cart");
		
		//支払い処理をサービス層へ依頼
		cnt = service.payProd(cart,session);
		
		if(cnt > 0) {			
			redirectAttributes.addFlashAttribute("cart", cart);
			session.setAttribute("cart", new ArrayList<>());
			return "redirect:/complete-pay";
		} else {
			model.addAttribute("payErrorMsg", "購入エラーが発生しました。お手数ですが操作をやり直してください");
		}
		
		return "select";
	}
	
}
