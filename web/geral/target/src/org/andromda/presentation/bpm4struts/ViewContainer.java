package org.andromda.presentation.bpm4struts;

public interface ViewContainer
{
	/* lida a sessao */

	public void setOnSession(String key, Object value);

	public Object getFromSession(String key);

	public void removeFromSession(String key);

	/* lida o request */

	public void setAttribute(String key, Object value);

	public Object getAttribute(String key);

	public void removeAttribute(String key);
	
	public String getParameter(String key);

	public javax.servlet.http.HttpServletRequest getRequest();

	/* lida o response */

	public void setCharacterEncoding(String charset);

	public void setContentType(String type);

	public void setHeader(String name, String value);

	public javax.servlet.ServletOutputStream getOutputStream() throws java.io.IOException;

	public java.io.PrintWriter getWriter() throws java.io.IOException;
	
	public javax.servlet.http.HttpServletResponse getResponse();

	/* util */

	public Integer getParametroGrupo();

	public String getMessageText(String key);
}