package fr.appgestionstock.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import fr.appgestionstock.models.UserEntity;
import fr.appgestionstock.repository.UserRepository;
import fr.appgestionstock.shared.UserDto;
import fr.appgestionstock.shared.Utils;

class UserServiceImplTest {

	@InjectMocks
	UserServiceImpl userService;

	@Mock
	UserRepository userRepo;

	@Mock
	Utils utils;

	@Mock
	BCryptPasswordEncoder bCryptPasswordEncoder;

	String username = "Myriam";
	String userId = "fjthG7fg";
	String password = "gr844grdfcc";
	String encryptedPassword = "gheeh84hgdf6h4hte7";
	String email = "test@test.com";

	UserEntity userEntity;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		userEntity = new UserEntity();
		userEntity.setId(1L);
		userEntity.setUsername(username);
		userEntity.setUserId(userId);
		userEntity.setEncryptedPassword(encryptedPassword);
		userEntity.setEmail(email);
	}

	@Test
	final void testGetUser() {

		when(userRepo.findByEmail(anyString())).thenReturn(userEntity);

		UserDto userDto = userService.getUser(email);

		assertNotNull(userDto);
		assertEquals("Myriam", userDto.getUsername());
	}

	@Test
	final void testGetUser_UsernameNotFoundException() {
		when(userRepo.findByEmail(anyString())).thenReturn(null);

		assertThrows(UsernameNotFoundException.class,

				() -> {
					userService.getUser(email);
				}

		);

	}

	@Test
	final void testCreateUser() {

		when(userRepo.findByEmail(anyString())).thenReturn(null);
		when(utils.generateRandomId(anyInt())).thenReturn(userId);
		when(bCryptPasswordEncoder.encode(anyString())).thenReturn(encryptedPassword);
		when(userRepo.save(any(UserEntity.class))).thenReturn(userEntity);

		UserDto userDto = new UserDto();
		userDto.setEmail(email);
		userDto.setUsername(username);
		userDto.setPassword(password);

		UserDto createdUser = userService.createUser(userDto);

		assertNotNull(createdUser);
		assertEquals(userEntity.getUsername(), createdUser.getUsername());
		assertEquals(userEntity.getEmail(), createdUser.getEmail());
		assertNotNull(createdUser.getUserId());
		verify(utils, times(1)).generateRandomId(30);
		verify(bCryptPasswordEncoder, times(1)).encode(password);
		verify(userRepo, times(1)).save(any(UserEntity.class));
	}

	@Test
	final void testCreateUser_RuntimeException() {
		when(userRepo.findByEmail(anyString())).thenReturn(userEntity);

		UserDto userDto = new UserDto();
		userDto.setEmail(email);
		userDto.setUsername(username);
		userDto.setPassword(password);

		assertThrows(RuntimeException.class,

				() -> {
					userService.createUser(userDto);
				}

		);
	}

}
