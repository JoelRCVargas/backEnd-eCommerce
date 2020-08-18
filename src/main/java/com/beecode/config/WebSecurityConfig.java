package com.beecode.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.beecode.util.MyAuthenticationProvider;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


	@Autowired
    private MyAuthenticationProvider authProvider;


	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}


	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
		http.authenticationProvider(authProvider);
	}

	@Bean
	public PasswordEncoder getPassword() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

}
