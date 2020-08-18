package com.beecode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beecode.entity.VerificationToken;

public interface IVerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
	
	public List<VerificationToken> findByToken(String token);
	public List<VerificationToken> findByUserEmailValue(String email);
}
