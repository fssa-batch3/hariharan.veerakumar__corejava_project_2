package crazyFitness.validations.testUserValidation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import crazyFitness.validation.UserValidator;
 
 class TestValidateEmail {
	@Test
	 void testValidEmail() {
		assertTrue(UserValidator.validateEmail("hari@gmail.com"));
	
	}
	@Test
	 void testUpperCaseEmail() {
		assertFalse(UserValidator.validateEmail("HARI@gmail.com"));
	}
	@Test
	 void testInvalidEmailMissingAt() {
		assertFalse(UserValidator.validateEmail("harigmail.com"));
	
	}
	@Test
	 void testInvalidEmailMissingPeriod() {
		assertFalse(UserValidator.validateEmail("hari@gmailcom"));
	
	}
}
