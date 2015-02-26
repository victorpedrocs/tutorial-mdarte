package org.andromda.presentation.bpm4struts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;

import javax.ejb.EJBException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.util.MessageResources;
import org.hibernate.HibernateException;
import org.hibernate.StaleStateException;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
import org.hibernate.exception.GenericJDBCException;
import org.hibernate.exception.JDBCConnectionException;
import org.hibernate.exception.LockAcquisitionException;
import org.hibernate.exception.SQLGrammarException;

public class ExceptionUtil
{
	private static Map excecoesPadrao;
	private static List listExcecoesPadrao;

	static
	{
		excecoesPadrao = new HashMap();
		listExcecoesPadrao = new ArrayList();
		listExcecoesPadrao.add(ConstraintViolationException.class);
		listExcecoesPadrao.add(DataException.class);
		listExcecoesPadrao.add(GenericJDBCException.class);
		listExcecoesPadrao.add(JDBCConnectionException.class);
		listExcecoesPadrao.add(LockAcquisitionException.class);
		listExcecoesPadrao.add(SQLGrammarException.class);
		listExcecoesPadrao.add(StaleStateException.class);
		listExcecoesPadrao.add(HibernateException.class);

		excecoesPadrao.put(ConstraintViolationException.class, "error.dafault.constraint.violation.exception");
		excecoesPadrao.put(DataException.class, "error.default.data.exception");
		excecoesPadrao.put(GenericJDBCException.class, "error.default.generic.jdbc.exception");
		excecoesPadrao.put(JDBCConnectionException.class, "error.default.jdbc.connection.exception");
		excecoesPadrao.put(LockAcquisitionException.class, "error.default.lock.acquisition.exception");
		excecoesPadrao.put(SQLGrammarException.class, "error.default.sql.grammar.exceptio");
		excecoesPadrao.put(StaleStateException.class, "error.default.stale.stale.exception");
		excecoesPadrao.put(HibernateException.class, "error.default.hibernate.exception");
	}

	/**
	 * Retrieves the message and attempts to extract the specified pattern
	 * defined within this class. If a string can not be found matching the
	 * pattern, the message itself is returned.
	 * 
	 * @param exception
	 *            the Exception containing the message to retrieve, should not
	 *            be <code>null</code>
	 * @return the retrieved string matching the pattern.
	 * @throws Throwable
	 *             rethrows the cause of the argument exception (which might be
	 *             the exception itself) in case no pattern was found in its
	 *             message
	 */
	protected void parseExceptionMessage(HttpServletRequest request, Exception exception, MessageResources messageResources, Locale locale, Collection<String> chaves, Map<String, Collection<String>> parametros) throws Throwable
	{
		String exceptionMessage = null;

		chaves.clear();
		parametros.clear();

		findRootCause(request, exception, chaves, parametros, messageResources, locale);

		if (chaves == null || chaves.size() == 0)
		{
			ActionMessages messages = (ActionMessages) request.getSession().getAttribute(Globals.MESSAGE_KEY);
			if (messages == null || messages.size("org.andromda.bpm4struts.errormessages") == 0)
				if (!parseExceptionMessage(request, exception, messageResources, locale))
					throw new Exception();
		}

	}

	private boolean parseExceptionMessage(HttpServletRequest request, Exception exception, MessageResources messageResources, Locale locale)
	{
		return findRootCause(request, exception, messageResources, locale);
	}

	/**
	 * Finds the root cause of the parent exception by traveling up the
	 * exception tree
	 */
	private void findRootCause(HttpServletRequest request, Throwable throwable, Collection<String> chaves, Map<String, Collection<String>> parametros, MessageResources messageResources, Locale locale)
	{

		if (throwable != null)
		{
			if (throwable.getMessage() != null)
			{
				String message = throwable.getMessage();
				int indice = message.indexOf(" ");
				if (indice != -1)
					message = message.substring(0, indice);
				StringTokenizer st = new StringTokenizer(message, ",");
				Collection<String> parametrosMensagem = new ArrayList<String>();
				boolean key = true;
				while (st.hasMoreTokens())
				{
					String token = st.nextToken().trim();

					if (key)
					{
						key = false;
						if (!messageResources.isPresent(locale, token))
							break;
						chaves.add(token);
						parametros.put(token, parametrosMensagem);
					}
					else
					{
						parametrosMensagem.add(token);
					}
				}
			}

			if (getCause((Exception) throwable) != null)
			{
				throwable = getCause((Exception) throwable);
				findRootCause(request, throwable, chaves, parametros, messageResources, locale);
			}
		}
	}

	private boolean findRootCause(HttpServletRequest request, Throwable throwable, MessageResources messageResources, Locale locale)
	{
		if (throwable != null)
		{
			if (verifyExceptionsDefault(request, throwable))
				return true;
			else if (getCause((Exception) throwable) != null)
			{
				throwable = getCause((Exception) throwable);
				return findRootCause(request, throwable, messageResources, locale);
			}
			else
				return false;
		}

		return false;
	}

	private Throwable getCause(Throwable e)
	{
		if (e instanceof EJBException)
		{
			return ((EJBException) e).getCausedByException();
		}
		else
			return e.getCause();
	}

	private boolean verifyExceptionsDefault(HttpServletRequest request, Throwable throwable)
	{
		Iterator it = listExcecoesPadrao.iterator();

		Collection<ActionMessage> mensagens = new ArrayList<ActionMessage>();

		boolean foundException = false;

		while (it.hasNext())
		{
			Class classe = (Class) it.next();
			if (classe.isAssignableFrom(throwable.getClass()))
			{
				foundException = true;
				mensagens.add(new ActionMessage((String) excecoesPadrao.get(classe)));
				break;
			}
		}
		storeException(request, mensagens);
		return foundException;
	}

	/**
	 * Alternative implementation to the one offered by the parent class.
	 * Exceptions are also stored under
	 * <code>org.apache.struts.Globals.MESSAGE_KEY</code> in session scope.
	 */
	protected void storeException(HttpServletRequest request, Collection<ActionMessage> mensagens)
	{
		final HttpSession session = request.getSession();
		ActionMessages messages = (ActionMessages) session.getAttribute(Globals.MESSAGE_KEY);
		if (messages == null)
		{
			messages = new ActionMessages();
			session.setAttribute(Globals.MESSAGE_KEY, messages);
		}

		Iterator it = mensagens.iterator();

		while (it.hasNext())
			messages.add("org.andromda.bpm4struts.errormessages", (ActionMessage) it.next());
	}
}
