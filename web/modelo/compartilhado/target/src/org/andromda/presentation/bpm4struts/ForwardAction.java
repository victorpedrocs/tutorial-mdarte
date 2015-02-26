package org.andromda.presentation.bpm4struts;

import org.apache.commons.lang.StringUtils;

public final class ForwardAction
	extends org.apache.struts.action.Action
{

	public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
	{
		org.apache.struts.action.ActionForward forward = null;
		final ForwardForm forwardForm = (ForwardForm)form;

		java.util.Enumeration atributosName = request.getSession().getAttributeNames();

		java.util.Map atributos = new java.util.HashMap();

		while(atributosName.hasMoreElements()){
			String atributo = (String)atributosName.nextElement();
			atributos.put(atributo, request.getSession().getAttribute(atributo));
		}

		// salva mapa da sessao no contexto
		org.andromda.presentation.bpm4struts.ShareSessionUtil.saveMapIntoContext(request, response, atributos, this.getServlet().getServletContext().getContext("/sistemaacademico"));

		// permite passar o nome da aplicacao como parametro
		String applicationName = "/sistemaacademico";
		if (!StringUtils.isEmpty(forwardForm.getApplicationName()))
			applicationName = "/" + forwardForm.getApplicationName();

		// redireciona para o modulo/acao (substitui @AND@ por & para permitir mais de um parametro)
		String uri = request.getScheme() + "://" + (request.getServerName() + (request.getServerPort( ) != 80 ? ":" + request.getServerPort( ) : "").replace("//", "/"));
		String path = (applicationName + "/" + forwardForm.getModulo() + forwardForm.getPath()).replaceAll("//", "/").replaceAll("@AND@", "&");
		forward = new org.apache.struts.action.ActionForward(uri + path, true);

		return forward;
	}
}