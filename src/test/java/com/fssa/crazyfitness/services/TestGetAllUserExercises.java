package com.fssa.crazyfitness.services;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.crazyfitness.model.UserExercise;
import com.fssa.crazyfitness.services.exceptions.ServiceException;

class TestGetAllUserExercises {
	@Test
	void testGetAllUserExerciseList() {
		UserExerciseService userExerciseService = new UserExerciseService();
		List<UserExercise> userExercises;
		try {
			userExercises = userExerciseService.getAllUserExercise();
			for (UserExercise userExercise : userExercises) {
				System.out.println(userExercise.getUserExerciseId() + " - " + userExercise.getUserId() + " - "
						+ userExercise.getExerciseId() + " - " + userExercise.getExerciseDate() + " - "
						+ userExercise.getStatus());
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}

	}
}
