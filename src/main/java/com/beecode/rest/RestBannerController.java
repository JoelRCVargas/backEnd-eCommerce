package com.beecode.rest;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beecode.entity.Banner;
import com.beecode.interfaces.BannerService;
import com.beecode.projection.BannerProjection;

@RestController
public class RestBannerController {
	
	@Autowired
	private BannerService bannerService;
	
	@GetMapping(value = "/public/banner/all", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Banner>> getAllProduct(){
		return ResponseEntity.ok().body(bannerService.getAllBanner());
	}

	@GetMapping(value = "/public/banner/custom/all", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Collection<BannerProjection>> getCustomAllProduct(){
		return ResponseEntity.ok().body(bannerService.getAllProjetedBanner());
	}

}
