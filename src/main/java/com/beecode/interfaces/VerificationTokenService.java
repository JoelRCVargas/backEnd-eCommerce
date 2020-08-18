package com.beecode.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.beecode.entity.VerificationToken;

public interface VerificationTokenService {
	
	public ResponseEntity<String> updateVerificationToken(String token);
	public List<VerificationToken> getVerificationTokenByUserEmail(String token);
	public void forwardEmail(String email);
	
}
