package crazyFitness.validations.testUserValidation;
import crazyFitness.validation.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestValidatePassword {
	@Test
	public void testValidPassword() {
		assertTrue(UserValidator.validatePassword("Hari@2004"));
	
	}
	
	@Test
	public void testInvalidPasswordWithoutSpecialCharacter() {
		assertFalse(UserValidator.validatePassword("Hari2004"));
	}
	@Test
	public void testInvalidPasswordWithoutNumber() {
		assertFalse(UserValidator.validatePassword("Hari$%^&&"));
	}
	@Test
	public void testInvalidPasswordWithoutUpperCase() {
		assertFalse(UserValidator.validatePassword("hari2004"));
	}
	@Test
	public void testInvalidPasswordWithoutLowerCase() {
		assertFalse(UserValidator.validatePassword("HARI2004"));
	}
	@Test
	public void testInvalidPasswordLessLength() {
		assertFalse(UserValidator.validatePassword("hari"));
	}
}

