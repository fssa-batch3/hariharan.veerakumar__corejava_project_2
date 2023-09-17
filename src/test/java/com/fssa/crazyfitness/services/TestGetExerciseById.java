package com.fssa.crazyfitness.services;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.crazyfitness.model.Exercise;
import com.fssa.crazyfitness.services.exceptions.ServiceException;

class TestGetExerciseById {
	@Test
	void testValidGetExerciseById() {
		ExerciseService exerciseService = new ExerciseService();
		Exercise exercise = new Exercise();

		try {
			exercise = exerciseService.getExerciseById(1);
			System.out.println(exercise.getExerciseId() + " - " + exercise.getExerciseName());
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	
}
