package com.beecode.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beecode.service.SendingMailService;

@RestController
public class RestProductCampaignController {
	
	@Autowired
	private SendingMailService mailService;

	// Register new User + Person embed
	@PostMapping(value = "/public/product/campaign", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Boolean> sedingMailProductCampaing(@RequestParam("email") String email){
		return ResponseEntity.ok().body(mailService.sendCampaignProduct(email, null, ""));
	}

}
