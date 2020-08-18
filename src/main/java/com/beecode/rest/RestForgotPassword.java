package com.beecode.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beecode.interfaces.ForgotPasswordService;

@RestController
public class RestForgotPassword {
	
	@Autowired
	private ForgotPasswordService forgotPasswordService;
	
	@GetMapping(value = "/public/user/forgot/password", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> senEmailRecoveryPassword(@RequestParam("email") String email){
		//return ResponseEntity.status(HttpStatus.OK).body(forgotPasswordService.updateForgotPassword(email));
		return forgotPasswordService.sendEmailForgotPassword(email);
	}
	
	@GetMapping(value = "/public/user/verification/token/recover/password", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> verificationTokenForgotPassword(@RequestParam("token") String token){
		return forgotPasswordService.verificationTokenForgotPassword(token);
	}
	
	@GetMapping(value = "/public/user/recover/password", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> forgotPassword(@RequestParam("token") String token, @RequestParam("password") String password){
		return forgotPasswordService.forgotPassword(token, password);
	}
}
