package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Service.ProdService;
import com.example.demo.Service.UserService;
import com.example.demo.entity.Prod;
import com.example.demo.form.LoginForm;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class LoginController {
	
	private final UserService loginService;
	private final ProdService prodService;

	/*--- 最初のリクエスト -----------------*/
	@GetMapping("/")
	public String login() {
		return "login";
	}
	
	/*--- ログインのリクエスト -----------------*/
	@PostMapping("login-execute")
	public String loginExcecute(@ModelAttribute LoginForm form,Model model,
			HttpSession session) {
		
		boolean result = loginService.loginExecute(form, session, model);
		
		if(result) {
			List<Prod> list = prodService.findByProd();
			session.setAttribute("prodList", list);
			String userId = form.getUserId();
			session.setAttribute("userId", userId);
			return "select";
		} else {
			return "login";
		}
	}
	
	/*--- ログイン画面へ -----------------*/
	@GetMapping("/login-page")
	public String loginPage(HttpSession session) {
		session.invalidate();
		return "login";
	}
	
}
