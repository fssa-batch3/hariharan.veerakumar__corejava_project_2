package com.fssa.crazyfitness.services;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.crazyfitness.model.Exercise;
import com.fssa.crazyfitness.services.ExerciseService;
import com.fssa.crazyfitness.services.exceptions.ServiceException;

class TestUpdateExercise {
	@Test
	void testValidUpdateExercise() {
		ExerciseService exerciseService = new ExerciseService();
		Exercise exercise = new Exercise();
		String steps = "Go to any slanting surface and ready with your position now give  full strength to your hands. benefits are it will increase your biceps,chest,shoulder.";
		String image = "http://localhost:8080/crazyfitnesswebapp/assets/images/GIF/Full_body_GIFs/pushup.gif";
		exercise.setExerciseId(1);
		exercise.setExerciseName("Push-up");
		exercise.setExerciseImage(image);
		exercise.setExerciseTiming(20);
		exercise.setExerciseSteps(steps);
		exercise.setExerciseCategory("FULLBODY");

		try {
			assertTrue(exerciseService.updateExercise(exercise));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	void testInvalidUpdateExercise() {
		ExerciseService exerciseService = new ExerciseService();
		Exercise exercise = new Exercise();
		String steps = "Go to any slanting surface and ready with your position now give  full strength to your hands. benefits are it will increase your biceps,chest,shoulder.";
		String image = "http://localhost:8080/crazyfitnesswebapp/assets/images/GIF/Full_body_GIFs/pushup.gif";
		exercise.setExerciseId(1);
		exercise.setExerciseName("Push-up");
		exercise.setExerciseImage(image);
		exercise.setExerciseTiming(20);
		exercise.setExerciseSteps(steps);
		exercise.setExerciseCategory("BODY");
		try {
			assertFalse(exerciseService.updateExercise(exercise));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
}
