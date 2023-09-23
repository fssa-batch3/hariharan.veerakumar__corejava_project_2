package com.fssa.crazyfitness.model;

import java.time.LocalDate;

public class AssignExercise {
    private int userExerciseId;
    private int userId;
    private int exerciseId;
    private LocalDate exerciseDate; 
    private UserExerciseStatus status;
    private String exerciseName;
    private int exerciseTimes;
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
	public String getExerciseName() {
		return exerciseName;
	}
	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}
	public int getExerciseTimes() {
		return exerciseTimes;
	}
	public void setExerciseTimes(int exerciseTimes) {
		this.exerciseTimes = exerciseTimes;
	}
    
    
}
