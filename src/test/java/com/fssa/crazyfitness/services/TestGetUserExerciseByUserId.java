package com.fssa.crazyfitness.services;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.crazyfitness.model.UserExercise;
import com.fssa.crazyfitness.services.exceptions.ServiceException;

class TestGetUserExerciseByUserId {
@Test
void testGetUserUserExerciseByUserId() {
	UserExerciseService userExerciseService = new UserExerciseService();
	List<UserExercise> userExercise = new ArrayList<>();
	try {
		userExercise = userExerciseService.getUserExercisesListByUserId(1);
		for(int i =0; i < userExercise.size();i++) {
			System.out.println(((UserExercise) userExercise).getUserExerciseId() + " - " + ((UserExercise) userExercise).getUserId() + " - "
					+ ((UserExercise) userExercise).getExerciseId() + " - " + ((UserExercise) userExercise).getExerciseDate() + " - "
					+ ((UserExercise) userExercise).getStatus());
		}

	} catch (ServiceException e) {
		e.printStackTrace();
		fail();
	}
}

}
