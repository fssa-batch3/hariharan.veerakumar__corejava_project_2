package com.fssa.crazyfitness.services;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.crazyfitness.model.Exercise;
import com.fssa.crazyfitness.services.exceptions.ServiceException;

class TestCreateExercise {
	@Test
	void testCreateValidExercise() {
		ExerciseService exerciseService = new ExerciseService();
		String steps = "Go to any slanting surface and ready with your position now give  full strength to your hands. benefits are it will increase your biceps,chest,shoulder.";
		String image = "http://localhost:8080/crazyfitnesswebapp/assets/images/GIF/Full_body_GIFs/pushup.gif";
		Exercise exercise = new Exercise("Push up", image, 20, steps, "FULLBODY");

		try {
			assertTrue(exerciseService.createExercise(exercise));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testCreateInvalidNullExercise() {
		ExerciseService exerciseService = new ExerciseService();
		Exercise exercise = null;
		
        assertThrows(ServiceException.class, () -> {
            exerciseService.createExercise(exercise);
        });

	}
	
}
