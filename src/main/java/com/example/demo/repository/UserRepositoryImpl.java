package com.example.demo.repository;


import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;
import com.example.demo.form.ChgPassForm;
import com.example.demo.form.LoginForm;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

	private final JdbcTemplate jdbcTemplate;
	
	@Override
	public User selectUser(LoginForm form) {
		// DBアクセス処理
		String sql = "SELECT user_id, password FROM m_password WHERE user_id = ?";
		
		Map<String, Object> list = jdbcTemplate.queryForMap(sql, form.getUserId());
		
		//値の取得・結果格納
		User user = new User();
		user.setUserId((String) list.get("user_id"));
		user.setPassword((String) list.get("password"));
		
		return user;
	}

	@Override
	public int updatePass(ChgPassForm form, String pass) {
		int cnt = 0;
		String sql = "UPDATE m_password SET password = ? "
				+ " WHERE user_id = ? ";
		String userId = form.getUserId();
		
		cnt = jdbcTemplate.update(sql, pass, userId);
		
		return cnt;
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
