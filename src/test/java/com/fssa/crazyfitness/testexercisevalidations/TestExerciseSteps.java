package com.fssa.crazyfitness.testexercisevalidations;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.crazyfitness.validations.ExerciseValidator;
import com.fssa.crazyfitness.validations.exceptions.InvalidExerciseException;

 class TestExerciseSteps {
	  @Test
	     void testValidExerciseSteps() throws InvalidExerciseException {
	        // Valid exercise steps (non-null and non-empty)
	        assertTrue(ExerciseValidator.validateExerciseSteps("Step 1: ..."));
	        assertTrue(ExerciseValidator.validateExerciseSteps("Step 1: ...\nStep 2: ..."));
	    }

	    @Test
	     void testNullExerciseSteps() {
	        // Null exercise steps should throw an exception
	        assertThrows(InvalidExerciseException.class, () -> {
	            ExerciseValidator.validateExerciseSteps(null);
	        });
	    }

	    @Test
	     void testEmptyExerciseSteps() {
	        // Empty exercise steps should throw an exception
	        assertThrows(InvalidExerciseException.class, () -> {
	            ExerciseValidator.validateExerciseSteps("");
	        });
	    }
}
