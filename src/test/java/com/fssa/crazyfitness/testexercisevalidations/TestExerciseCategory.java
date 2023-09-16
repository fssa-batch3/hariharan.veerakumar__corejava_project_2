package com.fssa.crazyfitness.testexercisevalidations;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.crazyfitness.validations.ExerciseValidator;
import com.fssa.crazyfitness.validations.exceptions.InvalidExerciseException;

 class TestExerciseCategory {
	 @Test
	     void testValidExerciseCategory() throws InvalidExerciseException {
	        // Valid exercise categories
	        assertTrue(ExerciseValidator.validateExerciseCategory("FULLBODY"));
	        assertTrue(ExerciseValidator.validateExerciseCategory("ARMS"));
	    }

	    @Test
	     void testNullExerciseCategory() {
	        // Null exercise category should throw an exception
	        assertThrows(InvalidExerciseException.class, () -> {
	            ExerciseValidator.validateExerciseCategory(null);
	        });
	    }

	    @Test
	     void testEmptyExerciseCategory() {
	        // Empty exercise category should throw an exception
	        assertThrows(InvalidExerciseException.class, () -> {
	            ExerciseValidator.validateExerciseCategory("");
	        });
	    }

	    @Test
	     void testInvalidExerciseCategory() {
	        // Invalid exercise category should throw an exception
	        assertThrows(InvalidExerciseException.class, () -> {
	            ExerciseValidator.validateExerciseCategory("INVALIDCATEGORY");
	        });
	    }
}
