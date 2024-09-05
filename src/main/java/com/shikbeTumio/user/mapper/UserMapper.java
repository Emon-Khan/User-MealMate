package com.shikbeTumio.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.shikbeTumio.user.dto.UserDTO;
import com.shikbeTumio.user.entity.User;

@Mapper
public interface UserMapper {
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	User mapUserDTOToUser(UserDTO userDTO);

	UserDTO mapUserToUserDTO(User user);

}
