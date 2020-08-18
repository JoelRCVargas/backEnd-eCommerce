package com.beecode.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordDecode {
	
	public static boolean decode(String rawPassword, String encodedPassword) {
		boolean isPasswordMatch;
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		isPasswordMatch = passwordEncoder.matches(rawPassword, encodedPassword);
		return isPasswordMatch;
	}
	

}
