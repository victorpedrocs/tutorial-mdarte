package br.mdarte.exemplo.academico.cd;

public class DAOException extends Exception {

	public DAOException(Exception e) {
		super(e);
	}

	public DAOException(String message) {
		super(message);
	}

}