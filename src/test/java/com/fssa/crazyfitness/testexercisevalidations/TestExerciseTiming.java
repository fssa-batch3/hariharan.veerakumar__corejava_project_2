package com.fssa.crazyfitness.testexercisevalidations;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.crazyfitness.validations.ExerciseValidator;
import com.fssa.crazyfitness.validations.exceptions.InvalidExerciseException;

 class TestExerciseTiming {
    @Test
     void testValidExerciseTiming() throws InvalidExerciseException {
        // Valid exercise timings (greater than 4 seconds)
        assertTrue(ExerciseValidator.validateExerciseTiming(5));
        assertTrue(ExerciseValidator.validateExerciseTiming(10));
    }

    @Test
     void testInvalidExerciseTiming() {
        // Invalid exercise timing (less than or equal to 4 seconds) should throw an exception
        assertThrows(InvalidExerciseException.class, () -> {
            ExerciseValidator.validateExerciseTiming(4);
        });
    }
}
