package com.beecode.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beecode.entity.ProductRating;
import com.beecode.interfaces.ProductRatingService;

@RestController
public class RestProductRating {

	@Autowired
	private ProductRatingService productRatingService;
	
	@GetMapping(value = "/public/product/rating/all", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<ProductRating>> getAllProductRating(){
		return ResponseEntity.ok().body(productRatingService.getAllProductRating());
	}
	
	@GetMapping(value = "/public/product/rating/by/user/product", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<ProductRating>> getAllProductRatingByUserAndProduct(@RequestParam("user_id")
	Long user_id, @RequestParam("product_id") Long product_id){
		return ResponseEntity.ok().body(productRatingService.getAllProductRatingByUserIdAndProductId(user_id, product_id));
	}
	
	// POST product rating -> stars score
	@PostMapping(value = "/public/product/rating/create", consumes = { MediaType.APPLICATION_JSON_VALUE },  produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ProductRating> createProductRating(@RequestBody ProductRating productRating) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productRatingService.createProductRating(productRating));
	}
	
}
