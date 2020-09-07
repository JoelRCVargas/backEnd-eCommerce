package com.beecode.rest;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beecode.entity.Product;
import com.beecode.interfaces.ProductService;
import com.beecode.projection.ProductCardProjection;
import com.beecode.projection.ProductProjection;

@RestController
public class RestProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "/public/product/all", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Product>> getAllProduct(){
		return ResponseEntity.ok().body(productService.getAllProduct());
	}
	
	//Get products -> Home
	@GetMapping(value = "/public/product/pagination", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Page<ProductCardProjection>> getAllProductPage(Pageable pageable ,@RequestParam("pageNo") 
	int pageNo, @RequestParam("pageSize") int pageSize, @RequestParam("type") List<String> type){
		return ResponseEntity.ok().body(this.productService.getProductPage(pageable, pageNo, pageSize, type));
	}
	
	//Get products -> Menu
	@GetMapping(value = "/public/product/by/type", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Collection<ProductProjection>> getProductsByType(){
		return ResponseEntity.ok().body(productService.getCustomProducts());
	}
	
	//Get products -> Search
	@GetMapping(value = "/public/product/like/name", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Slice<ProductProjection>> getProductsLikeName(@RequestParam("name") String name){
		return ResponseEntity.ok().body(productService.getLikeCustomProductsByName(name, PageRequest.of(0, 7)));
	}
	
	//Get products -> Details
	@GetMapping(value = "/public/product/bysku", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Optional<Product>> getProductBySku(@RequestParam("sku") String sku){
		return ResponseEntity.ok().body(productService.getBySku(sku));
	}
}
