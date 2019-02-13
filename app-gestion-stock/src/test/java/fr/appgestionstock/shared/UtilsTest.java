package fr.appgestionstock.shared;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UtilsTest {

	@Autowired
	Utils utils;

	int idLength = 30;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGenerateRandomId() {
		String randomId = utils.generateRandomId(idLength);
		String randomId2 = utils.generateRandomId(idLength);

		assertNotNull(randomId);
		assertNotNull(randomId2);
		assertTrue(randomId.length() == idLength && randomId2.length() == idLength);
		assertTrue(!randomId.equalsIgnoreCase(randomId2));
	}

}
