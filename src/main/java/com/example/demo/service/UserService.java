package com.example.demo.service;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.form.ChgPassForm;
import com.example.demo.form.LoginForm;
import com.example.demo.form.RegistForm;

import jakarta.servlet.http.HttpSession;

public interface UserService {
	
	//ログイン処理
	boolean loginExecute(@ModelAttribute LoginForm form,HttpSession session,Model model);
	
	//パスワード変更処理
	int chgPassExecute(ChgPassForm form);
	
	//ユーザー登録処理
	int registUser(RegistForm form);
}
