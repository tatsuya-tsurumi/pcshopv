package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class CommonController {
	
	@GetMapping("complete-chg-pass")
	public String completeChgPass() {
		return "chg-pass";
	}
	
	@GetMapping("complete-add-cart")
	public String completeAddCart() {
		return  "cart";
	}
	
	@GetMapping("complete-remove-cart")
	public String completeRemoveCart() {
		return  "cart";
	}
	
	@GetMapping("complete-pay")
	public String completePay() {
		return  "pay";
	}
	
	@GetMapping("complete-regist")
	public String completeRegist() {
		return "complete-regist";
	}
	
	@GetMapping("error-regist")
	public String errorRegist() {
		return "regist";
	}
	
}
