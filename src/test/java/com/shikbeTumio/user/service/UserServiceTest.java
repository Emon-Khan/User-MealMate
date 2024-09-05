package com.shikbeTumio.user.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.shikbeTumio.user.dto.UserDTO;
import com.shikbeTumio.user.entity.User;
import com.shikbeTumio.user.mapper.UserMapper;
import com.shikbeTumio.user.repo.UserRepo;

public class UserServiceTest {

	@InjectMocks
	UserService userService;

	@Mock
	UserRepo userRepo;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testCreateUser() {
		UserDTO mockUserDTO = new UserDTO(101, "JohnDoe", "Pass@1234", "123 Main St, Apt 4B", "New York");
		User savedUser = UserMapper.INSTANCE.mapUserDTOToUser(mockUserDTO);
		when(userRepo.save(savedUser)).thenReturn(savedUser);

		UserDTO userDTO = userService.createUser(mockUserDTO);

		verify(userRepo, times(1)).save(savedUser);
		assertEquals(mockUserDTO, userDTO);
	}

	@Test
	public void testGetUserByID_ExistingId() {
		Integer mockUserId = 1;
		UserDTO mockUserDTO = new UserDTO(mockUserId, "JohnDoe", "Pass@1234", "123 Main St, Apt 4B", "New York");
		Optional<User> mockUser = Optional.ofNullable(UserMapper.INSTANCE.mapUserDTOToUser(mockUserDTO));
		when(userRepo.findById(mockUserId)).thenReturn(mockUser);

		ResponseEntity<UserDTO> response = userService.getUserByID(mockUserId);

		verify(userRepo, times(1)).findById(mockUserId);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(mockUserDTO, response.getBody());
	}

	@Test
	public void testGetUserByID_NonExistingId() {
		Integer mockUserId = 2;
		when(userRepo.findById(mockUserId)).thenReturn(Optional.empty());

		ResponseEntity<UserDTO> response = userService.getUserByID(mockUserId);

		verify(userRepo, times(1)).findById(mockUserId);
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		assertNull(response.getBody());
	}

}
