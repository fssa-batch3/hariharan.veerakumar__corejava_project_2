package com.fssa.crazyfitness.services;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.crazyfitness.model.UserExercise;
import com.fssa.crazyfitness.services.exceptions.ServiceException;

class TestGetUserExerciseByUserId {
@Test
void testGetUserUserExerciseByUserId() {
	UserExerciseService userExerciseService = new UserExerciseService();
	UserExercise userExercise = new UserExercise();
	try {
		userExercise = userExerciseService.getUserExerciseByUserId(1);
		System.out.println(userExercise.getUserExerciseId() + " - " + userExercise.getUserId() + " - "
				+ userExercise.getExerciseId() + " - " + userExercise.getExerciseDate() + " - "
				+ userExercise.getStatus());
	} catch (ServiceException e) {
		e.printStackTrace();
		fail();
	}
}

}
