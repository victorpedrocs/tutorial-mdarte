package br.mdarte.exemplo.academico.cd;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Collections;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.HibernateException;
import org.hibernate.Interceptor;
import org.hibernate.type.Type;
import org.hibernate.FlushMode;


import accessControl.ControleAcesso;

import br.mdarte.exemplo.academico.cd.AuditoriaEntity;
import br.mdarte.exemplo.academico.cd.AbstractDAO;
import br.mdarte.exemplo.academico.cd.AbstractEntity;
import br.mdarte.exemplo.academico.cd.Auditable;


public class LogInterceptor extends EmptyInterceptor implements Interceptor{
	private Set inserts = Collections.synchronizedSet(new HashSet());
	private Set updates = Collections.synchronizedSet(new HashSet());
	private Set deletes = Collections.synchronizedSet(new HashSet());
	private boolean deletado = false;
	
		// propriedades
	private final static String PROPRIEDADE_AUDITORIA_DATA_HORA = "auditoriaDataHora";
	private final static String PROPRIEDADE_AUDITORIA_LOGIN = "auditoriaLogin";
	private final static String PROPRIEDADE_AUDITORIA_OPERACAO = "auditoriaOperacao";
	
	// tipos de operacao
	private final static String OPERACAO_INSERCAO = "INSERCAO";
	private final static String OPERACAO_ATUALIZACAO = "ATUALIZACAO";

	// controles internos
	private boolean executingPostFlush = false;
	
	private void atualizaCamposAuditoria (String tipoOperacao, String propriedades[], Object[] state)
	{
		String login;
		try {
			    login = ControleAcesso.getCallerPrincipal(accessControl.SecurityHolder.getSubject()).getName();
		} catch (Exception e)	 {
		    login = "NA";
		}
		java.util.Date dataOperacao = new java.util.Date();
		
		for (int i=0; i < propriedades.length; i++) 
		{
			if (propriedades[i].equals(PROPRIEDADE_AUDITORIA_DATA_HORA))
				state[i] = dataOperacao;
			else if (propriedades[i].equals(PROPRIEDADE_AUDITORIA_LOGIN))
				state[i] = login;
			else if (propriedades[i].equals(PROPRIEDADE_AUDITORIA_OPERACAO))
				state[i] = tipoOperacao;
        }
			
	}	
	
	public boolean onSave(Object entity,
	                     Serializable id,
	                     Object[] state,
	                     String[] propertyNames,
	                     Type[] types)
	        throws CallbackException {

		if (entity instanceof AuditoriaEntity)
		{
			atualizaCamposAuditoria(OPERACAO_INSERCAO, propertyNames, state);
			Log log = LogFactory.getLog(LogInterceptor.class);
			log.debug("Entidade: " + entity.toString() );
			log.debug( "Modo: INSERCAO");			

			if(!(entity instanceof Auditable))
        			inserts.add(entity);
        	
        		return true;
		}

        	return false;
	}
	public boolean onFlushDirty(Object entity,
	                             Serializable id,
	                             Object[] currentState,
	                             Object[] previousState,
	                             String[] propertyNames,
	                             Type[] types)
	        throws CallbackException {

		if (entity instanceof AuditoriaEntity)
		{
			atualizaCamposAuditoria(OPERACAO_ATUALIZACAO, propertyNames, currentState);
			Log log = LogFactory.getLog(LogInterceptor.class);
			log.debug("Entidade: " + entity.toString() );
			log.debug("Modo: ATUALIZACAO");			

      		if(!(entity instanceof Auditable))
    				updates.add(entity);

    			return true;
		}

        	return false;
	}
	
	public void onDelete(Object entity, Serializable id, Object[] currentState, String[] previousState, Type[] types) {
		if(!(entity instanceof Auditable))
	    	deletes.add(entity);
	}
	public void postFlush(Iterator iterator)throws CallbackException {
		if (executingPostFlush) return;
		executingPostFlush = true;
		Log log = LogFactory.getLog(LogInterceptor.class);
		try {

			AbstractDAO.currentSession().setFlushMode(FlushMode.NEVER);

			Object[] insertsArray = inserts.toArray();
			Object[] updatesArray = updates.toArray();
			Object[] deletesArray = deletes.toArray();
			  
		      for (int i=0; i < insertsArray.length; i++) {
		          AbstractEntity entity = (AbstractEntity) insertsArray[i];
		          inserts.remove(entity);
	          	  entity.getDaoImpl().logEvent("insert", entity);
	          	  log.debug("Entidade: " + entity.toString() );
	          	  log.debug("Modo: INSERCAO - PostFlush");
		      }
		      for (int u=0; u < updatesArray.length; u++) {
		          AbstractEntity entity = (AbstractEntity) updatesArray[u];
		          updates.remove(entity);
		          log.debug("Entidade: " + entity.toString());
		          log.debug("Modo: ATUALIZACAO - PostFlush");
		          for (int d=0; (d < deletesArray.length) && (!deletado); d++) {
			          AbstractEntity entdel = (AbstractEntity) deletesArray[d];
			          
			          if(entity.equals(entdel)){
			        	  deletado = true;
			          }
			      }
		          if(!deletado){
		        	  entity.getDaoImpl().logEvent("update", entity);       	  
		          }
		          deletado=false;		 
		      }
		      for (int d=0; d < deletesArray.length; d++) {
		          AbstractEntity entity = (AbstractEntity) deletesArray[d];
		          deletes.remove(entity);
		          entity.getDaoImpl().logEvent("delete", entity);
		          log.debug("Entidade: " + entity.toString());
		          log.debug("Modo: REMOCAO - PostFlush");
		      }
		  } catch (HibernateException ex) {
		      throw new CallbackException(ex);
		  } finally {
		      inserts.clear();
		      updates.clear();
		      deletes.clear();
		      AbstractDAO.currentSession().flush();
			AbstractDAO.currentSession().setFlushMode(FlushMode.AUTO);
			executingPostFlush = false;
		  }
		}

}
