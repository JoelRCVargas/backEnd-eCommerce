package com.beecode.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beecode.interfaces.ProductOnOfferService;
import com.beecode.projection.ProductOnOfferProjection;

@RestController
public class RestProductOnOfferController {
	
	@Autowired
	private ProductOnOfferService productOnOfferService;
	
	@GetMapping(value = "/public/product/on/offer/all", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Collection<ProductOnOfferProjection>> getAllProductOnOffer(){
		return ResponseEntity.ok().body(productOnOfferService.getAllProductOnOfferProjection());
	}
}
