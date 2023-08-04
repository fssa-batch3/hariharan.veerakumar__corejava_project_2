package crazyFitness.dao.exceptions;

public class DAOException extends Exception {
	/**
		 * 
		 */
	private static final long serialVersionUID = -7173706993091255450L;

	public DAOException(String msg) {
		super(msg);
	}

	public DAOException(Throwable ex) {
		super(ex);
	}
}
