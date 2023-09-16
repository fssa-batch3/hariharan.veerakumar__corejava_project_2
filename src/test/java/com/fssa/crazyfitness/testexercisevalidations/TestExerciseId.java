package com.fssa.crazyfitness.testexercisevalidations;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.crazyfitness.validations.ExerciseValidator;
import com.fssa.crazyfitness.validations.exceptions.InvalidExerciseException;

 class TestExerciseId {

    @Test
     void testValidId() throws InvalidExerciseException {
        // Valid exercise IDs (positive integers)
        assertTrue(ExerciseValidator.validateId(1));
        assertTrue(ExerciseValidator.validateId(100));
    }

    @Test
     void testNegativeId() {
        // Negative exercise ID should throw an exception
        assertThrows(InvalidExerciseException.class, () -> {
            ExerciseValidator.validateId(-1);
        });
    }

    @Test
     void testZeroId() {
        // Zero exercise ID should throw an exception
        assertThrows(InvalidExerciseException.class, () -> {
            ExerciseValidator.validateId(0);
        });
    }
}
