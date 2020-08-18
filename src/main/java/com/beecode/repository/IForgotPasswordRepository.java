package com.beecode.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beecode.entity.ForgotPassword;

public interface IForgotPasswordRepository extends JpaRepository<ForgotPassword, Long> {
	
	public Optional<ForgotPassword> findByUserEmailValue(String email);
	public Optional<ForgotPassword> findByToken(String token);
}
