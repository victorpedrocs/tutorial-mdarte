package org.andromda.presentation.bpm4struts;

import org.apache.struts.action.ActionForm;


import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import org.andromda.presentation.bpm4struts.ViewContainer;

public class SessionObjectUtilStruts2
{
	private static final String SESSION_OBJECTS_KEY = "cadastroSessionObjectKeys";

	public static void updateSessionObjects(ViewContainer container, Collection listaCasosUso)
	{
		Map cadastroSessionObject = getCollectionSessionsKey(container); 
		java.util.Set chaves = cadastroSessionObject.keySet();

		java.util.Iterator it = chaves.iterator();

		while(it.hasNext())
		{
			String chave = (String)it.next();

			if(cadastroSessionObject.get(chave) instanceof Integer)
			{
				Integer counter = (Integer) cadastroSessionObject.get(chave);
				--counter;

				if(counter <= 0)
				{
					container.removeFromSession(chave);
					cadastroSessionObject.remove(chave);
				}
				else
					cadastroSessionObject.put(chave, counter);

				break;
			}

			if(!listaCasosUso.contains((String) cadastroSessionObject.get(chave)))
			{
				container.removeFromSession(chave);
				cadastroSessionObject.remove(chave);
			}
		}
	}

	public static void removeSessionObject(ViewContainer container, String sessionKey)
	{
		java.util.Map cadastroSessionObject = (Map) getCollectionSessionsKey(container);
		cadastroSessionObject.remove(sessionKey);
		container.removeFromSession(sessionKey);
	}

	public static void setSessionObject(ViewContainer container, Object sessionObject, String sessionKey, String useCaseName, boolean keepSO)
	{
		if(!keepSO)
		{
			java.util.Map cadastroSessionObject = (Map) getCollectionSessionsKey(container);
			cadastroSessionObject.put(sessionKey, useCaseName);
		}

		container.setOnSession(sessionKey, sessionObject);
	}

	public static void resetSessionObjetCounter(ViewContainer container, String sessionKey, Integer iterations)
	{
		Map cadastroSessionObject = getCollectionSessionsKey(container);
		cadastroSessionObject.put(sessionKey, iterations);
	}

	public static void setSessionObject(ViewContainer container, Object sessionObject, String sessionKey, Integer iteracoes)
	{
		java.util.Map cadastroSessionObject = (Map) getCollectionSessionsKey(container);
		cadastroSessionObject.put(sessionKey, iteracoes);
		container.setOnSession(sessionKey, sessionObject);
	}

	private static Map getCollectionSessionsKey(ViewContainer container)
	{
		Map sessionsKey = (Map) container.getFromSession(SESSION_OBJECTS_KEY);

		if(sessionsKey == null)
		{
			sessionsKey = new HashMap();
			container.setOnSession(SESSION_OBJECTS_KEY, sessionsKey);
		}

		return sessionsKey;
	}
}