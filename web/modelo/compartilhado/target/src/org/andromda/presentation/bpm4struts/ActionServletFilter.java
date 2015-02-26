package org.andromda.presentation.bpm4struts;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import br.mdarte.exemplo.academico.cd.AbstractDAO;


public class ActionServletFilter implements Filter {
	FilterConfig fc;
	  
	public void doFilter(ServletRequest request ,ServletResponse response, FilterChain chain) throws IOException, ServletException {
		AbstractDAO.currentSession();

		try {
			chain.doFilter(request, response);
		} finally {
			AbstractDAO.closeSession();
		}
	}

	public void init(FilterConfig filterConfig) {
		this.fc = filterConfig;
	}

	public void destroy() {
		this.fc = null;
	}
}
