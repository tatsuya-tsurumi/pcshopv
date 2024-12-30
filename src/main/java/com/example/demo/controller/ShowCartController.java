package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.form.AddProdForm;

import jakarta.servlet.http.HttpSession;


@Controller
public class ShowCartController {
	
	@GetMapping("show-cart")
	public String showCart(@ModelAttribute  AddProdForm form, Model model, HttpSession session) {
		
		String userId = (String) session.getAttribute("userId");
		@SuppressWarnings("unchecked")
		List<AddProdForm> cart = (List<AddProdForm>) session.getAttribute("cart");
		
		model.addAttribute("cart", cart);
		model.addAttribute("userId", userId);
		

		
		return "cart";
	}
	
	
}
