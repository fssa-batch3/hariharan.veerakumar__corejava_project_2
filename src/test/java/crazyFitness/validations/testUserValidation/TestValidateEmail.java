package crazyFitness.validations.testUserValidation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import crazyFitness.validation.UserValidator;

public class TestValidateEmail {
	@Test
	public void testValidEmail() {
		assertTrue(UserValidator.validateEmail("hari@gmail.com"));
	
	}
	@Test
	public void testUpperCaseEmail() {
		assertFalse(UserValidator.validateEmail("HARI@gmail.com"));
	}
	@Test
	public void testInvalidEmailMissingAt() {
		assertFalse(UserValidator.validateEmail("harigmail.com"));
	
	}
	@Test
	public void testInvalidEmailMissingPeriod() {
		assertFalse(UserValidator.validateEmail("hari@gmailcom"));
	
	}
}
