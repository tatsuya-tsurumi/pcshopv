package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Prod;
import com.example.demo.form.AddProdForm;

import jakarta.servlet.http.HttpSession;

@Controller
public class RemoveProdController {
	
	@PostMapping("remove-prod")
	public String addProd(@ModelAttribute @RequestParam("idx") int idx,
			AddProdForm form,Model model,HttpSession session) {
		
		
		
		@SuppressWarnings("unchecked")
		List< Prod> cart = (List<Prod>) session.getAttribute("cart");
		cart.remove(idx);
		
		session.setAttribute("cart", cart);
		model.addAttribute("cart", cart);
		
		
		return "redirect:/complete-remove-cart";
	}
}
