package fr.appgestionstock.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import fr.appgestionstock.messages.response.UserRest;
import fr.appgestionstock.services.UserServiceImpl;
import fr.appgestionstock.shared.UserDto;

class UserControllerTest {

	@InjectMocks
	UserController userController;

	@Mock
	UserServiceImpl userService;

	UserDto userDto;

	String userId = "hytr4193hthty7G4vgr";
	String username = "Myriam";
	String email = "test@test.com";
	String password = "fezrf9541gre";
	String encryptedPassword = "ffez4841fez89ghbhhththy";

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		userDto = new UserDto();
		userDto.setUserId(userId);
		userDto.setUsername(username);
		userDto.setEmail(email);
		userDto.setPassword(password);
		userDto.setEncryptedPassword(encryptedPassword);
	}

	@Test
	void testGetUser() {
		when(userService.getUserByUserId(anyString())).thenReturn(userDto);

		UserRest userRest = userController.getUser(userId);

		assertNotNull(userRest);
		assertEquals(userId, userRest.getUserId());
		assertEquals(userDto.getUsername(), userRest.getUsername());
		assertEquals(userDto.getEmail(), userRest.getEmail());
	}

}
