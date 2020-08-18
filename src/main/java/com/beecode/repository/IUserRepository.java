package com.beecode.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beecode.entity.User;

public interface IUserRepository  extends JpaRepository<User, Long>{
	
	public Optional<User> findByEmailValue(String email);
}
