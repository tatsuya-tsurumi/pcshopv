package com.example.demo.form;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class RegistForm {
	
	private String userId;
	private String userName;
	private String email;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthDay;
	private String password;
	private String again;
}
