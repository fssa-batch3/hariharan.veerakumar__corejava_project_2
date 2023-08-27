package com.fssa.crazyfitness.validations.exceptions;

public class InvalidCartException extends Exception{
      /**
	 * 
	 */
	private static final long serialVersionUID = -157145714339807093L;

	public InvalidCartException(String msg) {
    	  super(msg);
      }
      
      public InvalidCartException(Throwable e) {
    	  super(e);
      }
}
