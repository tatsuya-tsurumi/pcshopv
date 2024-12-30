package com.example.demo.repository;

import com.example.demo.entity.User;
import com.example.demo.form.ChgPassForm;
import com.example.demo.form.LoginForm;

public interface UserRepository {
	User selectUser(LoginForm form);
	int updatePass(ChgPassForm form, String pass);
}
