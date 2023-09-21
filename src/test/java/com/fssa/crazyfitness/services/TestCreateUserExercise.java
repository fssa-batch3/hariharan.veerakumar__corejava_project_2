package com.fssa.crazyfitness.services;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.fssa.crazyfitness.model.UserExercise;
import com.fssa.crazyfitness.model.UserExerciseStatus;
import com.fssa.crazyfitness.services.exceptions.ServiceException;

class TestCreateUserExercise {
	@Test
	void testCreateValidUserExercise() {
		UserExerciseService userExerciseService = new UserExerciseService();
		UserExerciseStatus status = UserExerciseStatus.PLANNED;
		LocalDate today = LocalDate.now(); 
		UserExercise userExercise = new UserExercise(1, 2, today, status);
		try {
			assertTrue(userExerciseService.createUserExercise(userExercise));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testCreateInvalidNullUserExercise() {
		UserExerciseService userExerciseService = new UserExerciseService();
		UserExercise userExercise = null;
		assertThrows(ServiceException.class, () -> {
			userExerciseService.createUserExercise(userExercise);
		});
	}
}
