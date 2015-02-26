package br.mdarte.exemplo.academico.to;

public class TOException extends Exception {

	public TOException(Exception e) {
		super(e);
	}

	public TOException(String message) {
		super(message);
	}

}