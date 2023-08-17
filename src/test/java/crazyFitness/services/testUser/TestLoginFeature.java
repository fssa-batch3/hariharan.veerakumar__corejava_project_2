package crazyFitness.services.testUser;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import crazyFitness.services.*;

import crazyFitness.services.exceptions.ServiceException;

 class TestLoginFeature {
	@Test
	 void testLoginSuccess() {
		UserService userService = new UserService();

		try {
			assertTrue(userService.login("hari10haran@gmail.com", "Haripassword$10"));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}
	 
	@Test
	 void testLoginNotSuccess() {
		UserService userService = new UserService();

		try {
			assertFalse(userService.login("hariharan@gmail.com", "HariPassword$10"));
		} catch (ServiceException e) {
			e.printStackTrace();
		} 
	}
	
	@Test
	 void testLoginWrongEmail() {
		UserService userService = new UserService();

		try {
			assertFalse(userService.login("hariharan@gmail.com", "HariPassword$10"));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	@Test
	 void testLoginWrongPassword() {
		UserService userService = new UserService();

		try {
			assertFalse(userService.login("hari10haran@gmail.com", "Haripassword$1"));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
}
