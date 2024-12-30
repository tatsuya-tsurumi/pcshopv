package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;


@Controller
public class LogoutController {
	
	@GetMapping("/logout")
	public String getMethodName(HttpSession session) {
		
		session.invalidate();
		
		return "login";
	}
	
}
