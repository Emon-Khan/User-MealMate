package com.shikbeTumio.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shikbeTumio.user.dto.UserDTO;
import com.shikbeTumio.user.entity.User;
import com.shikbeTumio.user.mapper.UserMapper;
import com.shikbeTumio.user.repo.UserRepo;

@Service
public class UserService {
	@Autowired
	UserRepo userRepo;

	public UserDTO createUser(UserDTO userDTO) {
		User savedUser = userRepo.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));
		return UserMapper.INSTANCE.mapUserToUserDTO(savedUser);
	}

	public ResponseEntity<UserDTO> getUserByID(Integer userId) {
		Optional<User> user = userRepo.findById(userId);
		if (user.isPresent()) {
			return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(user.get()), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

}
