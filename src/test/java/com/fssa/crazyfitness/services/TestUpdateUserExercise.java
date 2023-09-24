package com.fssa.crazyfitness.services;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.crazyfitness.model.UserExercise;
import com.fssa.crazyfitness.model.UserExerciseStatus;
import com.fssa.crazyfitness.services.exceptions.ServiceException;

class TestUpdateUserExercise {
	@Test
	void testValidUpdateUserExercise() {
		UserExerciseService userExerciseService = new UserExerciseService();
		UserExercise userExercise = new UserExercise();
		UserExerciseStatus status = UserExerciseStatus.COMPLETED;
		userExercise.setUserExerciseId(4);
		userExercise.setStatus(status);

		try {
			assertTrue(userExerciseService.updateUserExercise(userExercise));
		} catch (ServiceException e) {
			e.printStackTrace(); 
			System.out.println(e.getMessage());
			fail();
		}
	}
	@Test
	void testInvalidUpdateUserExercise() {
		UserExerciseService userExerciseService = new UserExerciseService();
		UserExercise userExercise = new UserExercise();
		UserExerciseStatus status = null;
		userExercise.setUserExerciseId(2);
		userExercise.setStatus(status);
		assertThrows(ServiceException.class, () ->{
			userExerciseService.updateUserExercise(userExercise);
		});
	}
}
