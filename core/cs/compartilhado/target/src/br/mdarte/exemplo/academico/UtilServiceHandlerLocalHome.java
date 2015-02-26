package br.mdarte.exemplo.academico;

public interface UtilServiceHandlerLocalHome extends javax.ejb.EJBLocalHome {

	/**
     * The logical JNDI name.
     */
    public static final String COMP_NAME = "java:comp/env/br.mdarte.exemplo.academico.UtilServiceHandlerLocal";

    /**
     * The physical JNDI name.
     */
    public static final String JNDI_NAME = "br.mdarte.exemplo.academico.UtilServiceHandlerLocal";

    public br.mdarte.exemplo.academico.UtilServiceHandlerLocal create() throws javax.ejb.CreateException;
}
