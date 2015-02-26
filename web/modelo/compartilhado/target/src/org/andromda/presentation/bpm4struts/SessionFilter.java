package org.andromda.presentation.bpm4struts;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.security.auth.Subject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import br.mdarte.exemplo.academico.util.Constantes;

public class SessionFilter implements Filter {
	FilterConfig fc;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;

		Map atributos = org.andromda.presentation.bpm4struts.ShareSessionUtil.getMapFromContext(httpRequest, fc.getServletContext().getContext("/sistemaacademico"));

		if(atributos != null) {
			javax.servlet.http.HttpSession sessao = httpRequest.getSession();
			Set chaves = atributos.keySet();
			Iterator it = chaves.iterator();

			while(it.hasNext()) {
				String chave = (String)it.next();
				sessao.setAttribute(chave, atributos.get(chave));
			}

			fc.getServletContext().getContext("/sistemaacademico").removeAttribute("session");
		}

		if (httpRequest.getSession(false) != null) {
			Subject subject = (Subject) httpRequest.getSession().getAttribute(Constantes.USER_SESSION);

			accessControl.SecurityHolder.setSubject(subject);
		}

		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) {
		this.fc = filterConfig;
	}

	public void destroy() {
		this.fc = null;
	}
}
