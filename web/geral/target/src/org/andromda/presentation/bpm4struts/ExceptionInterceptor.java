package org.andromda.presentation.bpm4struts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.util.MessageResources;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class ExceptionInterceptor implements Interceptor
{
	private static final String HANDLE_EXCEPTION = "handleException";

	public void destroy()
	{
		// empty
	}

	public void init()
	{
		// empty
	}

	public String intercept(ActionInvocation invocation) throws Exception
	{
		String result;

		try
		{
			result = invocation.invoke();
		}
		catch (Exception exception)
		{
			// same as the struts2 config
			result = HANDLE_EXCEPTION;

			final ActionContext context = invocation.getInvocationContext ();
			HttpServletRequest request = (HttpServletRequest) context.get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);

			MessageResources messageResources = (MessageResources)request.getAttribute(Globals.MESSAGES_KEY);
			Locale locale = (Locale)request.getSession().getAttribute(Globals.LOCALE_KEY);

			Collection<ActionMessage> mensagens = new ArrayList<ActionMessage>();

			ActionForward forward;

			ExceptionUtil exceptionUtil = new ExceptionUtil();

			try
			{
				if (messageResources==null)
				{
					mensagens.add(new ActionMessage(exception.getMessage()));
				}
				else
				{
    				Collection<String> chaves = new ArrayList<String>();
    				Map<String, Collection<String>> parametros = new HashMap<String, Collection<String>>();
    
    				exceptionUtil.parseExceptionMessage(request, exception, messageResources, locale, chaves, parametros);
    
    				Iterator it = chaves.iterator();
    
    				while(it.hasNext())
    				{
    					String chave = (String)it.next();
    
    					if (parametros.get(chave) == null || parametros.get(chave).size() == 0)
    						mensagens.add(new ActionMessage(chave));
    					else
    						mensagens.add(new ActionMessage(chave, parametros.get(chave).toArray()));
    				}
				}
			}
			catch (Throwable parseException)
			{
				// no pattern was found, so just continue as usual
				ActionMessages messages = (ActionMessages)request.getSession().getAttribute(Globals.MESSAGE_KEY);
				mensagens.add(new ActionMessage("error.exception.message", parseException.getMessage()));
			}

			// Store the exception
			request.setAttribute(Globals.EXCEPTION_KEY, exception);
			request.getSession().setAttribute(Globals.EXCEPTION_KEY, exception);
			exceptionUtil.storeException(request, mensagens);

			//PrintStackTraceException
			exception.printStackTrace();
		}

		return result;
	}
}
