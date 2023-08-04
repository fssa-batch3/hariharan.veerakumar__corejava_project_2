package crazyFitness.validation.exceptions;

public class InvalidUserException extends Exception{

/**
	 * 
	 */
	private static final long serialVersionUID = 7395928823831538146L;
	
public InvalidUserException(String msg) {
	super(msg);
}
public InvalidUserException(Throwable ex) {
	super(ex);
}
}
