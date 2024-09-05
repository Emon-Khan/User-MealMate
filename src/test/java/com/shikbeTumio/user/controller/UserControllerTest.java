package com.shikbeTumio.user.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.shikbeTumio.user.dto.UserDTO;
import com.shikbeTumio.user.service.UserService;

public class UserControllerTest {
	@InjectMocks
	UserController userController;

	@Mock
	UserService userService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void TestCreateUser() {
		UserDTO mockUserDTO = new UserDTO(101, "JohnDoe", "Pass@1234", "123 Main St, Apt 4B", "New York");
		when(userService.createUser(mockUserDTO)).thenReturn(mockUserDTO);

		ResponseEntity<UserDTO> response = userController.createUser(mockUserDTO);

		verify(userService, times(1)).createUser(mockUserDTO);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertEquals(mockUserDTO, response.getBody());
	}

	@Test
	public void TestGetUserByID() {
		Integer mockUserId = 1;
		ResponseEntity<UserDTO> mockUserDTO = new ResponseEntity<>(
				new UserDTO(mockUserId, "JohnDoe", "Pass@1234", "123 Main St, Apt 4B", "New York"), HttpStatus.CREATED);
		when(userService.getUserByID(mockUserId)).thenReturn(mockUserDTO);

		ResponseEntity<UserDTO> response = userController.getUserByID(mockUserId);

		verify(userService, times(1)).getUserByID(mockUserId);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertEquals(mockUserDTO, response);
	}
}
