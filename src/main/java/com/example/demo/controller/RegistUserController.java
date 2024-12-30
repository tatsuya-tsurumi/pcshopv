package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Service.UserService;
import com.example.demo.form.RegistForm;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class RegistUserController {
	
	private final UserService service;

	@GetMapping("regist")
	public String registUser() {
		return "regist";
	}
	
	@PostMapping("regist-user")
	public String registUser(RegistForm form,RedirectAttributes redirectAttributes) {
		int cnt = 0;
		
		service.registUser(form);
		
		if(cnt > 0) {
			redirectAttributes.addFlashAttribute("registMsg", "登録が完了しました");
		} else {
			redirectAttributes.addFlashAttribute("registMsg", "登録時にエラーが発生しました");
		}
		
		
		return "redirect:/complete-regist";
	}
}
