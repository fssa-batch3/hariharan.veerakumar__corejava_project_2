package com.fssa.crazyfitness.testexercisevalidations;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.crazyfitness.validations.ExerciseValidator;
import com.fssa.crazyfitness.validations.exceptions.InvalidExerciseException;

 class TestExerciseName {
	 @Test
	     void testValidExerciseName() throws InvalidExerciseException {
	        // Valid exercise names (3 to 20 characters with only letters and optional spaces)
	       assertTrue(ExerciseValidator.validateExerciseName("Push-Up"));
	       assertTrue(ExerciseValidator.validateExerciseName("Squat Jump"));
	    }

	    @Test
	     void testNullExerciseName() {
	        // Null exercise name should throw an exception
	        assertThrows(InvalidExerciseException.class, () -> {
	            ExerciseValidator.validateExerciseName(null);
	        });
	    }

	    @Test
	     void testEmptyExerciseName() {
	        // Empty exercise name should throw an exception
	        assertThrows(InvalidExerciseException.class, () -> {
	            ExerciseValidator.validateExerciseName("");
	        });
	    }

	    @Test
	     void testInvalidExerciseName() {
	        // Invalid exercise name with numeric characters should throw an exception
	        assertThrows(InvalidExerciseException.class, () -> {
	            ExerciseValidator.validateExerciseName("Sit-Up123");
	        });
	    }
}
