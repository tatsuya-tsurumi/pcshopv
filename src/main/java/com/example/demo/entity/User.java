package com.example.demo.entity;

import java.sql.Date;

import lombok.Data;

@Data
public class User {
	private String userId;
	private String userName;
	private String email;
	private Date birthDay;
	private String password;
	private String again;
}
