package com.example.demo.Service;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.form.ChgPassForm;
import com.example.demo.form.LoginForm;

import jakarta.servlet.http.HttpSession;

public interface UserService {
	
	//ログイン処理
	boolean loginExecute(@ModelAttribute LoginForm form,HttpSession session,Model model);
	
	//ログアウト処理
	
	//パスワード変更処理
	int chgPassExecute(ChgPassForm form);
}
