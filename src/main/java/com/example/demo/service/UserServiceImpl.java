package com.example.demo.service;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.entity.User;
import com.example.demo.form.CartForm;
import com.example.demo.form.ChgPassForm;
import com.example.demo.form.LoginForm;
import com.example.demo.form.RegistForm;
import com.example.demo.repository.UserRepository;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final UserRepository repository;

	//ログイン処理、インフラ層へDBアクセス処理を依頼
	@Override
	public boolean loginExecute(@ModelAttribute LoginForm form,HttpSession session,
			Model model) {
		
		boolean result = false;
		
		User user = repository.selectUser(form);
		
		try {
			result = checkPassowrd(form.getPassword(), user.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(result) {
			List<CartForm> cart = new ArrayList<>();
			session.setAttribute("cart", cart);
			result = true;
		} 
		model.addAttribute("login_msg", "IDもしくはパスワードに誤りがあります");
		return result;
	}
	
	//入力されたパスワードをハッシュ化
	public static String hashPassword(String password) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(password.getBytes());
		byte[] digest = md.digest();
		return Base64.getEncoder().encodeToString(digest);
	}
	
	/**
	 * ハッシュ値の比較
	 * @param pass 比較対象のパスワード(入力値)
	 * @param hashedPass ハッシュ化されたパスワード(DBからの値)
	 */
	public static boolean checkPassowrd(String pass, String hashedPass) throws Exception {
		
		//比較結果を返す
		return hashPassword(pass).equals(hashedPass);
	}

	//パスワード変更処理
	@Override
	public int chgPassExecute(ChgPassForm form) {
		
		String pass = form.getPassword();
		String hashPass = null;
		int cnt = 0;
		
		if(pass.equals(form.getAgain())) {
			try {
				hashPass = hashPassword(pass);
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			 cnt = repository.updatePass(form, hashPass);
			return cnt;
		} else {
			cnt = 99;
		}
			return cnt;
	}

	//ユーザー登録処理をインフラ層へ依頼、
	@Override
	public int registUser(RegistForm form) {
		int cnt = 0;
		if(form.getPassword().equals(form.getAgain())) {
			try {
				form.setPassword(hashPassword(form.getPassword()));
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			cnt = repository.registUser(form);
		}
		return cnt;
	}

	
	
	


}
