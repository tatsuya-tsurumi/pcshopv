package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Service.ProdService;
import com.example.demo.Service.UserService;
import com.example.demo.entity.Prod;
import com.example.demo.form.RegistForm;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class RegistUserController {
	
	private final UserService registService;
	private final ProdService prodService;

	@GetMapping("regist")
	public String registUser() {
		return "regist";
	}
	
	@PostMapping("regist-user")
	public String registUser(RegistForm form,RedirectAttributes redirectAttributes,
			HttpSession session) {
		

		int cnt = 0;
		
		System.out.println(form.getBirthDay());
		
		cnt = registService.registUser(form);
		
		if(cnt > 0) {
			redirectAttributes.addFlashAttribute("registMsg", "登録が完了しました");
			List<Prod> list = prodService.findByProd();
			session.setAttribute("prodList", list);
			String userId = form.getUserId();
			session.setAttribute("userId", userId);
			String userName = form.getUserName();
			session.setAttribute("userName", userName);
			return "redirect:/complete-regist";
		} else {
			redirectAttributes.addFlashAttribute("errorMsg", "登録時にエラーが発生しました");
			return "redirect:/error-regist";
		}
		
		
		
	}
}
