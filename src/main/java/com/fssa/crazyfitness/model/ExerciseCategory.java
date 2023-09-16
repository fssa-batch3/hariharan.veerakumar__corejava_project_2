package com.fssa.crazyfitness.model;

import com.fssa.crazyfitness.dao.exceptions.DAOException;

public enum ExerciseCategory {
    FULL_BODY(1),
    LOWER_BODY(2),
    ABS(3),
    CHEST(4),
    ARMS(5),
    SHOULDER_AND_BACK(6),
    LEG(7);

    private final int value;

    ExerciseCategory(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ExerciseCategory fromValue(int value) throws DAOException {
        for (ExerciseCategory category : ExerciseCategory.values()) {
            if (category.value == value) {
                return category;
            }
        }
        throw new DAOException("Invalid ExerciseCategory value: " + value);
    }
}
