package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.entity.Prod;
import com.example.demo.form.HistoryForm;
import com.example.demo.service.ProdService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class purchaseHistoryController {
	
	private final ProdService service;
	
	@GetMapping("purchase-history")
	public String purchaseHistory(@ModelAttribute HistoryForm form,
			Model model, HttpSession session) {
		
		List<Prod> list = service.findByUserId((String) session.getAttribute("userId"));
		
				
		model.addAttribute("purchaseList", list);
		
		return "history";
	}
	
	
}
