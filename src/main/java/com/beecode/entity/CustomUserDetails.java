package com.beecode.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {
	
	private static final long serialVersionUID = -7324241470369560894L;
	
	private String email;
	private String password;
	Collection<? extends GrantedAuthority> authorities;

	public CustomUserDetails(Optional<User> users) {
		this.email = users.get().getEmail();
		this.password  = users.get().getPassword();
		List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		for(Role role: users.get().getRoles()) {
			auths.add(new SimpleGrantedAuthority(role.getRoleName()));
		}
		
		this.authorities = auths;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	

}
