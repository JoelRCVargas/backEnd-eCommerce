package com.beecode.interfaces;

import org.springframework.http.ResponseEntity;

public interface ForgotPasswordService {
	public ResponseEntity<String> sendEmailForgotPassword(String email);
	public ResponseEntity<String> verificationTokenForgotPassword(String token);
	public ResponseEntity<String> forgotPassword(String token, String password);
}
