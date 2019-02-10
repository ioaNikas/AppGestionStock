package fr.appgestionstock.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import fr.appgestionstock.shared.UserDto;

public interface UserService extends UserDetailsService {
	UserDto createUser(UserDto user);

	UserDto updateUser(String userId, UserDto user);

	UserDto getUser(String email);

	UserDto getUserByUserId(String userId);

	void deleteUser(String userId);

	List<UserDto> getUsers();
}
