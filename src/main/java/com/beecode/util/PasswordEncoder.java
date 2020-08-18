package com.beecode.util;

import javax.persistence.Column;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
	
	@Column(name = "password", nullable = false)
	private String value;
	
	public PasswordEncoder() {}

	public PasswordEncoder(String value) {
		String passEncoder = new  BCryptPasswordEncoder().encode(value);
		this.value = passEncoder;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
