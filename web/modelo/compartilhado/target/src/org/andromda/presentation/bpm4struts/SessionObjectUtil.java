package org.andromda.presentation.bpm4struts;

import org.apache.struts.action.ActionForm;

import javax.servlet.http.HttpServletRequest;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;

public class SessionObjectUtil{

	private static final String SESSION_OBJECTS_KEY = "cadastroSessionObjectKeys";
	
	public static void updateSessionObjects(HttpServletRequest request, Collection listaCasosUso){
		Map cadastroSessionObject = getCollectionSessionsKey(request); 
		java.util.Set chaves = cadastroSessionObject.keySet();
	
		java.util.Iterator it = chaves.iterator();
	
		while(it.hasNext()){
			String chave = (String)it.next();
			
			if(cadastroSessionObject.get(chave) instanceof Integer){
				Integer counter = (Integer)cadastroSessionObject.get(chave);
				--counter;
				
				if(counter <= 0){
					request.getSession().removeAttribute(chave);
					cadastroSessionObject.remove(chave);	
				}else
					cadastroSessionObject.put(chave, counter);
				
				break;
			}
			
			if(!listaCasosUso.contains((String)cadastroSessionObject.get(chave))){
				request.getSession().removeAttribute(chave);
				cadastroSessionObject.remove(chave);
			}
		
		}
	}
	
	public static void removeSessionObject(HttpServletRequest request, String sessionKey){
		java.util.Map cadastroSessionObject = (Map)getCollectionSessionsKey(request);
            	cadastroSessionObject.remove(sessionKey);
            	 request.getSession().removeAttribute(sessionKey);
	}
	
	public static void setSessionObject(HttpServletRequest request, Object sessionObject, String sessionKey, String useCaseName, boolean keepSO){
	    if(!keepSO){
	    	java.util.Map cadastroSessionObject = (Map)getCollectionSessionsKey(request);
            	cadastroSessionObject.put(sessionKey, useCaseName);
            }
            
	    request.getSession().setAttribute(sessionKey, sessionObject);		       
	}
	
	public static void resetSessionObjetCounter(HttpServletRequest request, String sessionKey, Integer iterations){
		Map cadastroSessionObject = getCollectionSessionsKey(request);
		cadastroSessionObject.put(sessionKey, iterations);
	}
	
	public static void setSessionObject(HttpServletRequest request, Object sessionObject, String sessionKey, Integer iteracoes){
	    java.util.Map cadastroSessionObject = (Map)getCollectionSessionsKey(request);
            cadastroSessionObject.put(sessionKey, iteracoes);
            request.getSession().setAttribute(sessionKey, sessionObject);		       
	}
	
	private static Map getCollectionSessionsKey(HttpServletRequest request){
		Map sessionsKey = (Map)request.getSession().getAttribute(SESSION_OBJECTS_KEY);
		
		if(sessionsKey == null){
			sessionsKey = new HashMap();
			request.getSession().setAttribute(SESSION_OBJECTS_KEY, sessionsKey);
		}
		
		return sessionsKey;
	}
}