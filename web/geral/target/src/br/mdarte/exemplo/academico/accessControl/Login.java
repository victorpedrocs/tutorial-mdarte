// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: Login.java.vsl in andromda-bpm4struts-cartridge-coppetec.
//
package br.mdarte.exemplo.academico.accessControl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import br.mdarte.exemplo.academico.util.Constantes;
import javax.security.auth.Subject;

import java.util.Enumeration;

/**
 * 
 */
public abstract class Login extends Action
{
    protected String __casoDeUso = null;
    protected String __urlCasoDeUso = null;
    protected String __modulo = null;
    protected String __contexto = null;

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        loadUseCaseInfo();

        org.apache.commons.beanutils.BeanUtils.populate(form, request.getParameterMap());

        ActionForward forward = null;
        if(request.getSession().getAttribute(Constantes.TROCA_SENHA_OBRIGATORIA) != null && request.getParameter(Constantes.BUTTON_TROCA_SENHA) == null)
        {
        	forward = _verificaTrocaSenhaObrigatoria(mapping, form, request, response);
        }else{
        	forward = _validarSessao(mapping, form, request, response);
        }
        try
        {
        	request.getSession().setAttribute("mapping", mapping);
            request.getSession().setAttribute("form", form);
        }
        catch (java.lang.Exception exception)
        {
            Object formObj = org.andromda.presentation.bpm4struts.PageSessionObjectUtil.getPageForm(request, "${action.useCase.name}");

            if (formObj != null) {
            	try
            	{
            		formObj.getClass().getMethod("resetCheckBoxes", new Class[] {org.apache.struts.action.ActionMapping.class, javax.servlet.http.HttpServletRequest.class}).invoke(formObj, new Object[]{null, null});
            	}
            	catch (Exception e2)
            	{
            		// ignoring
            	}

            	final java.util.Map parameters = new java.util.HashMap();
            	for (final java.util.Enumeration names = request.getParameterNames(); names.hasMoreElements();)
            	{
            		final String name = String.valueOf(names.nextElement());
            		parameters.put(name, request.getParameterValues(name));
            	}
            	try
            	{
            		org.apache.commons.beanutils.BeanUtils.populate(formObj, parameters);
            	}
            	catch (java.lang.Exception populateException)
            	{
            		// ignore if we have an exception here (we just don't populate).
            	}
            }
            throw exception;
        }

        request.getSession().setAttribute("form", form);

		Boolean aplicacaoGerenciaTrocaDePortas = (Boolean) request.getSession().getServletContext().getAttribute("aplicacaoGerenciaTrocaDePortas");
        if (aplicacaoGerenciaTrocaDePortas)
        {
	        if(forward!=null && !(forward.getPath().contains("ForwardAction"))){
				if(forward != null && forward.getPath().startsWith("/secure")) {
					forward = new ActionForward("https://" + (request.getServerName() + ":" + request.getSession().getServletContext().getAttribute("httpsPort") + "//sistemaacademico" + forward.getPath()).replaceAll("//", "/"), true);
	        	}
				else {
		        	if(forward != null && request.getScheme().equals("https"))
			        {
			        	if (!forward.getPath().startsWith("http")){
							forward = new ActionForward("http://" + (request.getServerName() + ":" + request.getSession().getServletContext().getAttribute("httpPort") + request.getContextPath() + forward.getPath()).replaceAll("//", "/"), true);
						}
						if (forward.getPath().startsWith("https"))
						{
							String httpPort = (String) request.getSession().getServletContext().getAttribute("httpPort");
							String httpsPort = (String) request.getSession().getServletContext().getAttribute("httpsPort");
							forward = new ActionForward(forward.getPath().replaceAll("https", "http").replaceAll(httpsPort, httpPort), true);
						}
					}
		        }
	        }
		}
        
		// invalida sessao https ao trocar para http (passa a ter somente uma sessao para ambos)
        if (request.getScheme().equals("https") && forward != null && forward.getPath().startsWith("http://"))
        	request.getSession().invalidate();
        
        return forward;

    }

    /**
     * 
     */
    private ActionForward _validarSessao(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        ActionForward forward = null;
        forward = __sessaoValida(mapping, form, request, response);
        return forward;
    }
    
    /**
     * 
     */
    private ActionForward _verificaTrocaSenhaObrigatoria(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
	        ActionForward forward = mapping.findForward("troca.de.senha.obrigatoria"); 
            Subject subject = (Subject)request.getSession().getAttribute(Constantes.USER_SESSION);
            String usuario = ControleAcessoImpl.getCallerPrincipal(subject).getName();
            LoginFormImpl formImpl = (LoginFormImpl)form;
            formImpl.setUsuario(usuario); 
            return forward;
    }    

    /**
     * 
     */
    private ActionForward _verificaLoginESenha(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        ActionForward forward = null;
        forward = __possuiLoginSenha(mapping, form, request, response);
        return forward;
    }



    /**
     * 
     */
    private ActionForward _verificaTrocaDeSenha(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        ActionForward forward = null;
        forward = __precisaTrocarSenha(mapping, form, request, response);
        return forward;
    }    

    /**
     * 
     */
    private ActionForward _verificarLogin(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        ActionForward forward = null;
        forward = __verificarLogin(mapping, form, request, response);
        return forward;
    }

    /**
     * 
     */
    private ActionForward __possuiLoginSenha(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final String value = String.valueOf(LoginControllerFactory.getLoginControllerInstance().possuiLoginSenha(mapping, request, response, servlet));

        if (value.equals("false"))
        {
			ActionForward forward = mapping.findForward("entrar.login");

            if (__urlCasoDeUso != null && __contexto != null)
            {
            	Enumeration nomeParametros = request.getParameterNames();
                StringBuffer parametros = new StringBuffer("");
                if(nomeParametros.hasMoreElements())
                {
                    parametros.append("?");
                    while(nomeParametros.hasMoreElements()) 
                    {
                        String nome = nomeParametros.nextElement().toString();
                        parametros.append(nome+"="+request.getParameter(nome));
                        if(nomeParametros.hasMoreElements()) 
                        {
                            parametros.append("@AND@");
                        }
                    }
                }
                org.apache.struts.action.ActionRedirect redirect = new org.apache.struts.action.ActionRedirect(forward);
                redirect.addParameter("nextPath", __contexto + __urlCasoDeUso+parametros.toString());
                forward = redirect;
            }
            return forward;
        }
        if (value.equals("true"))
        {
            return _verificarLogin(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _verificarLogin(mapping, form, request, response);
    }

    /**
     * 
     */
    private ActionForward __precisaTrocarSenha(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final String value = String.valueOf(LoginControllerFactory.getLoginControllerInstance().precisaTrocarSenha(mapping,  form, request, response, servlet));

        if (value.equals("false"))
        {
            return _verificarPermissao(mapping, form, request, response);
        }
        if (value.equals("true"))
        {
        	return mapping.findForward("troca.de.senha.obrigatoria");
        }

        // we take the last action in case we have an invalid return value from the controller
        return mapping.findForward("troca.de.senha.obrigatoria");
    }

    /**
     * 
     */
    private ActionForward __sessaoValida(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final String value = String.valueOf(LoginControllerFactory.getLoginControllerInstance().sessaoValida(mapping, request, response, servlet));

        if (value.equals("true"))
        {
        	return _verificarPermissao(mapping, form, request, response);
        }
        if (value.equals("false"))
        {
            return _verificaLoginESenha(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _verificaLoginESenha(mapping, form, request, response);
    }

    /**
     * 
     */
    private ActionForward __verificarLogin(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final String value = String.valueOf(LoginControllerFactory.getLoginControllerInstance().verificarLogin(mapping, (LoginFormImpl)form, request, response, servlet));

        if (value.equals("false"))
        {
            request.getSession().removeAttribute(Constantes.FORWARD);

			ActionForward forward = mapping.findForward("entrar.login");
			
            if (__urlCasoDeUso != null && __contexto != null)
            {
            	Enumeration nomeParametros = request.getParameterNames();
                StringBuffer parametros = new StringBuffer("");
                if(nomeParametros.hasMoreElements())
                {
                    parametros.append("?");
                    while(nomeParametros.hasMoreElements()) 
                    {
                        String nome = nomeParametros.nextElement().toString();
                        parametros.append(nome+"="+request.getParameter(nome));
                        if(nomeParametros.hasMoreElements()) 
                        {
                            parametros.append("@AND@");
                        }
                    }
                }
                org.apache.struts.action.ActionRedirect redirect = new org.apache.struts.action.ActionRedirect(forward);
                redirect.addParameter("nextPath", __contexto + __urlCasoDeUso+parametros.toString());
                forward = redirect;
            }
            return forward;
        }
        if (value.equals("true"))
        {
            return _verificaTrocaDeSenha(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _verificaTrocaDeSenha(mapping, form, request, response);
    }
    /**
     * Returns true if <strong>NO</strong> errors
     * are present in the request.  This includes default validation
     * errors produced by the struts framework and the exception
     * handler errors caught by the pattern matching
     * exception handler.
     *
     * @return true if errors are <strong>not</strong> present, false otherwise.
     */
    private boolean errorsNotPresent(HttpServletRequest request)
    {
        return this.getExceptionHandlerErrors(request).isEmpty() &&
            (this.getErrors(request) == null || this.getErrors(request).isEmpty());
    }

    /**
     * <p>
     *  Retrieves the exception handler messages (if any).  Creates a new
     *  ActionMessages instance and returns that if one doesn't already exist.
     * </p>
     */
    private org.apache.struts.action.ActionMessages getExceptionHandlerErrors(HttpServletRequest request)
    {
        org.apache.struts.action.ActionMessages errors =
            (org.apache.struts.action.ActionMessages)request.getAttribute(
                "org.andromda.bpm4struts.errormessages");
        if (errors == null)
        {
            errors = new org.apache.struts.action.ActionMessages();
            request.setAttribute("org.andromda.bpm4struts.errormessages", errors);
        }
        return errors;
    }
    
    private ActionForward _verificarPermissao(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        final String value = String.valueOf(LoginControllerFactory.getLoginControllerInstance().verificarPermissao(mapping, request, response, servlet));

        if (value.equals("true"))
        {
        	return particularExecute(mapping, form, request, response);
        }
        else
        {
			ActionForward forward = mapping.findForward("entrar.login");

            if (__urlCasoDeUso != null && __contexto != null)
            {
            	Enumeration nomeParametros = request.getParameterNames();
                StringBuffer parametros = new StringBuffer("");
                if(nomeParametros.hasMoreElements())
                {
                    parametros.append("?");
                    while(nomeParametros.hasMoreElements()) 
                    {
                        String nome = nomeParametros.nextElement().toString();
                        parametros.append(nome+"="+request.getParameter(nome));
                        if(nomeParametros.hasMoreElements()) 
                        {
                            parametros.append("@AND@");
                        }
                    }
                }
                org.apache.struts.action.ActionRedirect redirect = new org.apache.struts.action.ActionRedirect(forward);
                redirect.addParameter("nextPath", __contexto + __urlCasoDeUso+parametros.toString());
                forward = redirect;
            }
            return forward;
        }
    }

    public abstract ActionForward particularExecute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception;
    public abstract void loadUseCaseInfo();
}