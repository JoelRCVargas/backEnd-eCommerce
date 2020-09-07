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

import com.beecode.entity.ProductComments;
import com.beecode.interfaces.ProductCommentsService;
import com.beecode.projection.ProductCommentsProjection;
import com.beecode.projection.ProductCommentsScoreProjection;

@RestController
public class RestProductCommentsController {

	@Autowired
	private ProductCommentsService productCommentService;
	
	@GetMapping(value = "/public/product/comments/by/product", consumes = {MediaType.APPLICATION_JSON_VALUE}, 
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<ProductCommentsProjection>> getAllProductCommentsByProduct(@RequestParam("id_product") Long id){
		return ResponseEntity.ok().body(productCommentService.getAllProductCommentsbByProduct(id));
	}
	
	//Get score by product
	@GetMapping(value = "/public/product/score/comments/by/product", consumes = {MediaType.APPLICATION_JSON_VALUE}, 
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<ProductCommentsScoreProjection>> getScoreProductCommentsByProduct(@RequestParam("id_product") Long id){
		return ResponseEntity.ok().body(productCommentService.getScoreProductCommentsByProduct(id));
	}
	
	// Get product rating -> stars score
	@PostMapping(value = "/public/product/comments/create", consumes = { MediaType.APPLICATION_JSON_VALUE },  
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ProductComments> createProductComments(@RequestBody ProductComments productComments) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productCommentService.createProductComments(productComments));
	}
	
}
