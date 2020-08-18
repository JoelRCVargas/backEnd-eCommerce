package com.beecode.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.beecode.entity.VerificationToken;
import com.beecode.interfaces.VerificationTokenService;
import com.beecode.repository.IVerificationTokenRepository;

@Service
public class VerificationTokenImpl implements VerificationTokenService {
	
	@Autowired
	private IVerificationTokenRepository verificationTokenRepo;

	@Override
	public ResponseEntity<String> updateVerificationToken(String token) {
		List<VerificationToken> verificationTokenList = verificationTokenRepo.findByToken(token);
		if(verificationTokenList.isEmpty()) {
			return ResponseEntity.ok("Invalid Token");
		}
		if(verificationTokenList.get(0).getStatus().equals(VerificationToken.STATUS_VERIFIED)) {
			return ResponseEntity.ok("Your email was verified");
		}
		VerificationToken verificationToken =  verificationTokenList.get(0);
		if(verificationToken.getExpiredDateTime().isBefore(LocalDateTime.now())) {
			return ResponseEntity.ok("Expired Token");
		}
		verificationToken.setConfirmedDateTime(LocalDateTime.now());
		verificationToken.setStatus(VerificationToken.STATUS_VERIFIED);
		verificationToken.getUser().setEnabled(true);
		verificationTokenRepo.save(verificationToken);
		
		return ResponseEntity.ok("You have successfully verified your email adress.");
	}

	@Override
	public List<VerificationToken> getVerificationTokenByUserEmail(String email) {
		return verificationTokenRepo.findByUserEmailValue(email);
	}

	@Override
	public void forwardEmail(String token) {
		//List<VerificationToken> verificationTokenList = verificationTokenRepo.findByToken(token);
	}

}
