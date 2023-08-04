package crazyFitness.services.exceptions;

public class ServiceException extends Exception{
/**
	 * 
	 */
	private static final long serialVersionUID = 5962415459015907459L;
public ServiceException(String msg) {
	super(msg);
}
public ServiceException(Throwable ex) {
	super(ex);
}
}
