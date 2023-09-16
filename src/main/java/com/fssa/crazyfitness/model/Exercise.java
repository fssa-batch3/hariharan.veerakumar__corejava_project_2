package com.fssa.crazyfitness.model;

public class Exercise {

	private int exerciseId;
	private String exerciseName;
	private String exerciseImage;
	private int exerciseTiming;
	private String exerciseSteps;
	private String exerciseCategory;
	
	public Exercise() {
		
	}

	public Exercise(int exerciseId, String exerciseName, String exerciseImage, int exerciseTiming, String exerciseSteps,
			String exerciseCategory) {
		this.exerciseId = exerciseId;
		this.exerciseName = exerciseName;
		this.exerciseImage = exerciseImage;
		this.exerciseTiming = exerciseTiming;
		this.exerciseSteps = exerciseSteps;
		this.exerciseCategory = exerciseCategory;
	}

	public Exercise(String exerciseName, String exerciseImage, int exerciseTiming, String exerciseSteps,
			String exerciseCategory) {
		this.exerciseName = exerciseName;
		this.exerciseImage = exerciseImage;
		this.exerciseTiming = exerciseTiming;
		this.exerciseSteps = exerciseSteps;
		this.exerciseCategory = exerciseCategory;
	}

	public int getExerciseId() {
		return exerciseId;
	}

	public void setExerciseId(int exerciseId) {
		this.exerciseId = exerciseId;
	}

	public String getExerciseName() {
		return exerciseName;
	}

	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

	public String getExerciseImage() {
		return exerciseImage;
	}

	public void setExerciseImage(String exerciseImage) {
		this.exerciseImage = exerciseImage;
	}

	public int getExerciseTiming() {
		return exerciseTiming;
	}

	public void setExerciseTiming(int exerciseTiming) {
		this.exerciseTiming = exerciseTiming;
	}

	public String getExerciseSteps() {
		return exerciseSteps;
	}

	public void setExerciseSteps(String exerciseSteps) {
		this.exerciseSteps = exerciseSteps;
	}

	public String getExerciseCategory() {
		return exerciseCategory;
	}

	public void setExerciseCategory(String exerciseCategory) {
		this.exerciseCategory = exerciseCategory;
	}

}
