package com.fssa.crazyfitness.util;

public class DatabaseException extends Exception{
   /**
	 * 
	 */
	private static final long serialVersionUID = -2866486983726013640L;

public DatabaseException(String msg) {
	   super(msg);
   } 
	
 public DatabaseException(Throwable ex) {
	   super(ex);
   }
	 
 public DatabaseException(String msg, Throwable ex) {
	   super(msg,ex);
 }
	
 
}
