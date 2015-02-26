package br.mdarte.exemplo.academico;

public interface UtilServiceHandlerHome extends javax.ejb.EJBHome{

    /**
     * The logical JNDI name.
     */
   
    public static final String COMP_NAME = "java:comp/env/br.mdarte.exemplo.academico.UtilServiceHandler";

    /**
     * The physical JNDI name.
     */
     
    public static final String JNDI_NAME = "br.mdarte.exemplo.academico.UtilServiceHandler";

    public br.mdarte.exemplo.academico.UtilServiceHandler create() throws javax.ejb.CreateException, java.rmi.RemoteException;
}
