package com.example.demo.form;

import java.sql.Date;

import lombok.Data;

@Data
public class RegistForm {
	private String userId;
	private String userName;
	private String email;
	private Date birthDay;
	private String password;
	private String again;
}
