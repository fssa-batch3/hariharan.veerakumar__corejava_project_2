package com.fssa.crazyfitness.validations.testuservalidtion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.crazyfitness.validations.UserValidator;
import com.fssa.crazyfitness.validations.exceptions.InvalidUserException;

class TestValidateEmail {

	@Test
	void testValidEmail() throws InvalidUserException {
	       // Valid email addresses
        assertTrue(UserValidator.validateEmail("hari@gmail.com"));
        assertTrue(UserValidator.validateEmail("hari.kumar@gmail.in"));
	}

	@Test 
	void testInvalidEmailMissingAt() {
	       // Invalid email addresses (missing '@')
        assertThrows(InvalidUserException.class, () -> {
            UserValidator.validateEmail("invalid.email.com");
        });

	}

	@Test
	void testInvalidEmailMissingPeriod() {
	       // Invalid email addresses (missing '.')
        assertThrows(InvalidUserException.class, () -> {
            UserValidator.validateEmail("invalid@emailcom");
        });
	}
	@Test
	void testInvalidUpperCaseEmail() {
	     // Invalid email addresses (uppercase characters)
        assertThrows(InvalidUserException.class, () -> {
            UserValidator.validateEmail("Invalid@Email.com");
        });
    }
	}

