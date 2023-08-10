package crazyFitness.validations.testUserValidation;
import crazyFitness.validation.*;
import crazyFitness.validation.exceptions.InvalidUserException;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

 class TestValidatePassword {
	 Throwable exception;
	@Test
	 void testValidPassword() {
		try {
			assertTrue(UserValidator.validatePassword("Hari@2004"));
		} catch (InvalidUserException e) {
			
			e.printStackTrace();
			fail();
		}
	
	}
	 
	@Test
	 void testInvalidPasswordWithoutSpecialCharacter() {
		
		try {
			UserValidator.validatePassword("Hari2004");
			 exception = assertThrows(InvalidUserException.class, () -> {
				 
			 });
			 assertEquals("Invalid Password",exception.getMessage());
			
		} catch (InvalidUserException e) {
		e.printStackTrace();
		}
	}
	@Test
	 void testInvalidPasswordWithoutNumber() {
	
		try {
			UserValidator.validatePassword("Hari$%^&&");
			 exception = assertThrows(InvalidUserException.class, () -> {
				 
			 });
			 assertEquals("Invalid Password",exception.getMessage());
			
		} catch (InvalidUserException e) {
		e.printStackTrace();
		}
	}
	@Test
	 void testInvalidPasswordWithoutUpperCase() {
		try {
			UserValidator.validatePassword("hari2004");
			 exception = assertThrows(InvalidUserException.class, () -> {
				 
			 });
			 assertEquals("Invalid Password",exception.getMessage());
			
		} catch (InvalidUserException e) {
		e.printStackTrace();
		}
	}
	@Test
	 void testInvalidPasswordWithoutLowerCase() {

		try {
			UserValidator.validatePassword("HARI2004");
			 exception = assertThrows(InvalidUserException.class, () -> {
				 
			 });
			 assertEquals("Invalid Password",exception.getMessage());
			
		} catch (InvalidUserException e) {
		e.printStackTrace();
		}
	}
	@Test
	 void testInvalidPasswordLessLength() {
	
		try {
			UserValidator.validatePassword("hari");
			 exception = assertThrows(InvalidUserException.class, () -> {
				 
			 });
			 assertEquals("Invalid Password",exception.getMessage());
			
		} catch (InvalidUserException e) {
		e.printStackTrace();
		}
	}
}

