package org.andromda.presentation.bpm4struts; 

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import br.mdarte.exemplo.academico.util.Constantes;

import com.opensymphony.xwork2.ActionSupport;

public class Struts2ViewContainer implements ViewContainer
{
	private ActionSupport action;

	private HttpSession session;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public Struts2ViewContainer(ActionSupport action, HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		this.action = action;
		this.request = request;
		this.response = response;
		this.session = session;
	}

	public Struts2ViewContainer(ActionSupport action, HttpServletRequest request, HttpServletResponse response)
	{
		this(action, request, response, request.getSession());
	}

	public Struts2ViewContainer(ActionSupport action, HttpServletRequest request, HttpServletResponse response, boolean createSession)
	{
		this(action, request, response, request.getSession(createSession));
	}

	/* lida a sessao */

	public void setOnSession(String key, Object value)
	{
		session.setAttribute(key, value);
	}

	public Object getFromSession(String key)
	{
		return session.getAttribute(key);
	}

	public void removeFromSession(String key)
	{
		session.removeAttribute(key); 
	}

	/* lida o request */

	public void setAttribute(String key, Object value)
	{
		request.setAttribute(key, value);
	}

	public Object getAttribute(String key)
	{
		return request.getAttribute(key);
	}

	public void removeAttribute(String key)
	{
		request.removeAttribute(key); 
	}
	
	public String getParameter(String key) {
		return request.getParameter(key);
	}

	/* lida o response */

	public void setCharacterEncoding(String charset)
	{
		response.setCharacterEncoding(charset);
	}

	public void setContentType(String type)
	{
		response.setContentType(type);
	}

	public void setHeader(String name, String value)
	{
		response.setHeader(name, value);
	}

	public javax.servlet.ServletOutputStream getOutputStream() throws java.io.IOException
	{
		return response.getOutputStream();
	}

	public java.io.PrintWriter getWriter() throws java.io.IOException
	{
		return response.getWriter();
	}

	/* util */

	public Integer getParametroGrupo()
	{
		Object o = request.getAttribute(Constantes.PARAMETRO_GRUPO);

		if (o == null)
			return null;

		return (Integer) o;
	}

	public String getMessageText(String key)
	{
		return action.getText(key);
	}
	
	public HttpServletRequest getRequest() {
		return this.request;
	}
	
	public HttpServletResponse getResponse() {
		return this.response;
	}
}