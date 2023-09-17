package com.fssa.crazyfitness.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.crazyfitness.services.exceptions.ServiceException;

class TestDeleteExercise {
	@Test
	void testValidDeleteExercise() {
		ExerciseService exerciseService = new ExerciseService();

		try {
			assertTrue(exerciseService.deleteExercise(1));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testInvalidDeleteExercise() {
		ExerciseService exerciseService = new ExerciseService();

		try {
			assertFalse(exerciseService.deleteExercise(-1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}
}
