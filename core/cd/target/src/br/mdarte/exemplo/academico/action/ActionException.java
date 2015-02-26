package br.mdarte.exemplo.academico.action;


public class ActionException extends javax.ejb.EJBException {

	public ActionException(Exception e) {
		super(e);
	}

	public ActionException(String message) {
		super(message);
	}

	public ActionException(String message, Exception cause) {
		super(message, cause);
	}

}


