package crazyFitness.validation.exceptions;

public class InvalidSongException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3747356347065333266L;
   public InvalidSongException(String msg) {
	   super(msg);
   }
   public InvalidSongException(Throwable e) {
	   super(e);
   }
}
