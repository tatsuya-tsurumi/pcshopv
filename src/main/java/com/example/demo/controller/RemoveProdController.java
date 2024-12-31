package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Service.ProdService;
import com.example.demo.entity.Prod;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RemoveProdController {
	
	private final ProdService service;
	
	@PostMapping("remove-prod")
	public String removeProd(@RequestParam("idx") int idx,
			Prod form,HttpSession session) {
		
		service.removeProd(idx, session);
		
		return "redirect:/complete-remove-cart";
	}
}
