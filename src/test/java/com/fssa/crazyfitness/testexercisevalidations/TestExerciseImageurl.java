package com.fssa.crazyfitness.testexercisevalidations;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.crazyfitness.validations.ExerciseValidator;
import com.fssa.crazyfitness.validations.exceptions.InvalidExerciseException;

 class TestExerciseImageurl {
	@Test
     void testValidExerciseImage() throws InvalidExerciseException {
        // Valid exercise image URLs
        assertTrue(ExerciseValidator.validateExerciseImage("https://exercise.com/image.jpg"));
        assertTrue(ExerciseValidator.validateExerciseImage("http://exercise.com/image.png"));
    }

    @Test
     void testNullExerciseImage() {
        // Null exercise image URL should throw an exception
        assertThrows(InvalidExerciseException.class, () -> {
            ExerciseValidator.validateExerciseImage(null);
        });
    }

    @Test
     void testEmptyExerciseImage() {
        // Empty exercise image URL should throw an exception
        assertThrows(InvalidExerciseException.class, () -> {
            ExerciseValidator.validateExerciseImage("");
        });
    }
}
