package dao;

public class DAOException extends Exception {
	public DAOException() {
		super();
	}
	public DAOException(String exception) {
		super(exception);
	}
	public DAOException(String exception, Throwable throwable) {
		super(exception, throwable);
	}
	public DAOException(Throwable throwable) {
		super(throwable);
	}
}
