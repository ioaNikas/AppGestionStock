package fr.appgestionstock.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import fr.appgestionstock.shared.UserDto;

public interface UserService extends UserDetailsService {
	UserDto createUser(UserDto user);

	UserDto updateUser(String userId, UserDto user);

	UserDto getUser(String email);

	UserDto getUserByUserId(String userId);
}