package crazyFitness.validation.exceptions;

public class InvalidProductException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2226738424667169394L;

	public InvalidProductException(String msg) {
		super(msg);
	}
	
	public InvalidProductException(Throwable ex) {
		super(ex);
	}

}
