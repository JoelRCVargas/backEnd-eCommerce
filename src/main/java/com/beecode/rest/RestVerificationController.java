package com.beecode.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beecode.interfaces.VerificationTokenService;

@RestController
@RequestMapping("/public/email-verification")
public class RestVerificationController {

	@Autowired
	private VerificationTokenService verificationTokenCRUD;

	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE} , consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> getVerificationTokenByToken(@RequestParam("token") String token) {
		return verificationTokenCRUD.updateVerificationToken(token);
	}

}
