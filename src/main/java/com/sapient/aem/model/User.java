package com.sapient.aem.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer userId;
	private String userName;
	private String password;
	private Role role;
	
	
	public User(String userName, String password, Role role) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
	}
	
	
	
}
