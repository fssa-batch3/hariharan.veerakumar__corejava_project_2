package com.fssa.crazyfitness.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.crazyfitness.services.exceptions.ServiceException;

class TestDeleteUserExercise {
	@Test
	void testValidDeleteUserExercise() {
		UserExerciseService userExerciseService = new UserExerciseService();
		try {
			assertTrue(userExerciseService.deleteUserExercise(2));
		} catch (ServiceException e) {
			e.printStackTrace();
		}


	}
	@Test
	void testInvalidDeleteUserExercise() {
		UserExerciseService userExerciseService = new UserExerciseService();
		try {
			assertFalse(userExerciseService.deleteUserExercise(-2));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
