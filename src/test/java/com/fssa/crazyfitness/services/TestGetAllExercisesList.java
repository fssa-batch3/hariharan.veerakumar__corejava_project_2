package com.fssa.crazyfitness.services;


import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.crazyfitness.model.Exercise;
import com.fssa.crazyfitness.services.exceptions.ServiceException;

class TestGetAllExercisesList {
	 @Test
	 void testGetAllExercises() {
		 ExerciseService exerciseService = new ExerciseService();
		 List<Exercise> exercises = null;
		try {
			exercises = exerciseService.getAllExerciseList();
			 for(Exercise exercise : exercises) {
				 System.out.println(exercise.getExerciseId()+ " - " + exercise.getExerciseName()+" - "+exercise.getExerciseImage()+ " - " + exercise.getExerciseTiming()+ " - "+exercise.getExerciseSteps()+ " - " +exercise.getExerciseCategory());
			 }
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}

	 }


}
