package com.ssc.springSecurity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // id 생성 전략
	private int id;
	
	private String username;
	private String password;
	private String role;
}
