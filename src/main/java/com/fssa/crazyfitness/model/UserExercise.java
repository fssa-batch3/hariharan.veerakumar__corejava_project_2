package com.fssa.crazyfitness.model;

import java.time.LocalDate;

public class UserExercise {
    private int userExerciseId;
    private int userId;
    private int exerciseId;
    private LocalDate exerciseDate; 
    private UserExerciseStatus status;

    public UserExercise() {
    }

    public UserExercise(int userExerciseId, UserExerciseStatus status) {
        this.userExerciseId = userExerciseId;
        this.status = status;
    }

    public UserExercise(int userId, int exerciseId, LocalDate exerciseDate, UserExerciseStatus status) {
        this.userId = userId;
        this.exerciseId = exerciseId;
        this.exerciseDate = exerciseDate;
        this.status = status;
    }

    public int getUserExerciseId() {
        return userExerciseId;
    }

    public void setUserExerciseId(int userExerciseId) {
        this.userExerciseId = userExerciseId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId; 
    }

    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    public LocalDate getExerciseDate() {
        return exerciseDate;
    }

    public void setExerciseDate(LocalDate exerciseDate) {
        this.exerciseDate = exerciseDate;
    }

    public UserExerciseStatus getStatus() {
        return status;
    }

    public void setStatus(UserExerciseStatus status) {
        this.status = status;
    }
}


