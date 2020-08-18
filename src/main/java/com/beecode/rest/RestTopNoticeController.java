package com.beecode.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.beecode.entity.TopNotice;
import com.beecode.interfaces.TopNoticeService;

@RestController
public class RestTopNoticeController {

	@Autowired
	private TopNoticeService topNoticeService;
	
	@GetMapping(value = "/public/top/notice/all", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<TopNotice>> getAllTopNotice(){
		return ResponseEntity.ok().body(topNoticeService.getAllTopNotice());
	}
	
	@PostMapping(value = "/public/top/notice/update", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<TopNotice> updateTopNotice(@RequestBody TopNotice topNotice){
		return ResponseEntity.ok().body(topNoticeService.updateTopNotice(topNotice));
	}
}
