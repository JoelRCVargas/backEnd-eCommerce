package com.beecode.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.beecode.entity.CustomUserDetails;
import com.beecode.entity.User;
import com.beecode.repository.IUserRepository;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private IUserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepo.findByEmailValue(username);
		if (!user.isPresent()) {
			throw new UsernameNotFoundException(username);
		}
		return new CustomUserDetails(user);

	}

}
