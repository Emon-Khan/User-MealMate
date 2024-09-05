package com.shikbeTumio.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shikbeTumio.user.dto.UserDTO;
import com.shikbeTumio.user.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/users")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
		UserDTO userAdded = userService.createUser(userDTO);
		return new ResponseEntity<>(userAdded, HttpStatus.CREATED);
	}

	@GetMapping("/users/{userId}")
	public ResponseEntity<UserDTO> getUserByID(@PathVariable Integer userId) {
		return userService.getUserByID(userId);
	}
}
