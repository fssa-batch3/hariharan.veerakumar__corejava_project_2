package com.fssa.crazyfitness.validations.testuservalidtion;
import com.fssa.crazyfitness.validations.*;
import com.fssa.crazyfitness.validations.exceptions.InvalidUserException;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

 class TestValidatePassword {

	@Test
	 void testValidPassword() throws InvalidUserException {
        // Valid passwords
        assertTrue(UserValidator.validatePassword("Passw0rd!"));
   //     assertTrue(UserValidator.validatePassword("SecurePassword123!"));
	
	}
	 
	@Test
	 void testInvalidPasswordWithoutSpecialCharacter() {
        // Invalid passwords (no special character)
        assertThrows(InvalidUserException.class, () -> {
            UserValidator.validatePassword("Password123");
        });

	}
	@Test
	 void testInvalidPasswordWithoutNumber() {
	
        // Invalid passwords (no numeric character)
        assertThrows(InvalidUserException.class, () -> {
            UserValidator.validatePassword("Password!");
        });
	}
	@Test
	 void testInvalidPasswordWithoutUpperCase() {
        // Invalid passwords (no uppercase letter)
        assertThrows(InvalidUserException.class, () -> {
            UserValidator.validatePassword("password123!");
        });
	}
	@Test
	 void testInvalidPasswordWithoutLowerCase() {

        // Invalid passwords (no lowercase letter)
        assertThrows(InvalidUserException.class, () -> {
            UserValidator.validatePassword("PASSWORD123!");
        });
	}
	@Test
	 void testInvalidPasswordLessLength() {
        // Invalid passwords (less than 8 characters)
        assertThrows(InvalidUserException.class, () -> {
            UserValidator.validatePassword("Pwd123!");
        });

	}
}

