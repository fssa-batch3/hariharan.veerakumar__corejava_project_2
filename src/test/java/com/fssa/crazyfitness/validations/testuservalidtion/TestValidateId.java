package com.fssa.crazyfitness.validations.testuservalidtion;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.crazyfitness.validations.UserValidator;
import com.fssa.crazyfitness.validations.exceptions.InvalidUserException;

class TestValidateId {
	@Test
	void testValidId() throws InvalidUserException {
		// Valid user ID (positive integer)
		assertTrue(UserValidator.validateId(1));
	}

	@Test
	void testInvalidIdZero() throws InvalidUserException {
		// Invalid user ID (zero)
		assertThrows(InvalidUserException.class, () -> {
			UserValidator.validateId(0);
		});
	}

	@Test
	void testInvalidIdLessThanZero() throws InvalidUserException {
		// Invalid user ID (negative)
		assertThrows(InvalidUserException.class, () -> {
			UserValidator.validateId(-1);
		});
	}
}
