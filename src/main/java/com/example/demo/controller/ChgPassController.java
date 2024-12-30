package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Service.UserService;
import com.example.demo.form.ChgPassForm;

import lombok.RequiredArgsConstructor;



@Controller
@RequiredArgsConstructor
public class ChgPassController {
	
	private final UserService service;

	@GetMapping("chg-pass")
	public String chgPass() {
		return "chg-pass";
	}
	
	@PostMapping("chg-pass-execute")
	public String chgPassExecute(ChgPassForm form, 
			RedirectAttributes redirectAttributes) {
		//TODO: process POST request
		
		
		int cnt = service.chgPassExecute(form);
		
		
		
		if(cnt == 1) {				
			redirectAttributes.addFlashAttribute("chg_pass_msg", "パスワードの変更が完了しました");
		}else if(cnt == 99) {
			redirectAttributes.addFlashAttribute("chg_pass_msg", "パスワードが一致しません");
		} else {
			redirectAttributes.addFlashAttribute("chg_pass_msg", "パスワード変更時にエラーが発生しました");
		}
		
		return "redirect:/complete-chg-pass";
	}
	
	
}
