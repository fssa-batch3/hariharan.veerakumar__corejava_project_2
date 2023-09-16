package com.fssa.crazyfitness.validations.exceptions;

public class InvalidExerciseException extends Exception{
      /**
	 * 
	 */
	private static final long serialVersionUID = -157145714339807093L;

	public InvalidExerciseException(String msg) {
    	  super(msg);
      }
      
      public InvalidExerciseException(Throwable e) {
    	  super(e);
      }
}
