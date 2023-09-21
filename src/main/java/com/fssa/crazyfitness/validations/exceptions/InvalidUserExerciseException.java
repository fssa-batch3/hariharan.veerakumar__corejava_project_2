package com.fssa.crazyfitness.validations.exceptions;

public class InvalidUserExerciseException extends Exception {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public InvalidUserExerciseException(String msg) {
	super(msg);
}
public InvalidUserExerciseException(Throwable ex) {
	super(ex);
}
}
