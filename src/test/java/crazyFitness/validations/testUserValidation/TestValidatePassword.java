package crazyFitness.validations.testUserValidation;
import crazyFitness.validation.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

 class TestValidatePassword {
	@Test
	 void testValidPassword() {
		assertTrue(UserValidator.validatePassword("Hari@2004"));
	
	}
	
	@Test
	 void testInvalidPasswordWithoutSpecialCharacter() {
		assertFalse(UserValidator.validatePassword("Hari2004"));
	}
	@Test
	 void testInvalidPasswordWithoutNumber() {
		assertFalse(UserValidator.validatePassword("Hari$%^&&"));
	}
	@Test
	 void testInvalidPasswordWithoutUpperCase() {
		assertFalse(UserValidator.validatePassword("hari2004"));
	}
	@Test
	 void testInvalidPasswordWithoutLowerCase() {
		assertFalse(UserValidator.validatePassword("HARI2004"));
	}
	@Test
	 void testInvalidPasswordLessLength() {
		assertFalse(UserValidator.validatePassword("hari"));
	}
}

