package com.beecode.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.beecode.entity.User;
import com.beecode.interfaces.UserService;

@RestController
public class RestUserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/private/admin/users/all", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<User>> getAllUser() {
		return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
	}

	// verify if exists email
	@GetMapping(value = "/email/request", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public boolean checkUserByEmail(@RequestParam("value") String value) {
		boolean result = false;
		Optional<User> optionalUserVerification = userService.getUserByEmail(value);
		if (optionalUserVerification.isPresent()) {result = true;};
		return result;
	}
	
	// get User by email
	@GetMapping(value= "/private/user/access_token/byemail",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Optional<User>> getUserByEmail(@RequestParam("email") String email){
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUserByEmail(email));
	}

}
