// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: bpm4struts2/actions/Action.java.vsl in andromda-bpm4struts-cartridge-coppetec.
//

package br.mdarte.exemplo.academico.web.geral.consultarEstudante;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.ServletActionContext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Enumeration;
import java.io.PrintWriter;
import org.andromda.presentation.bpm4struts.ActionUtil;
import org.andromda.presentation.bpm4struts.Struts2ViewContainer;
import br.mdarte.exemplo.academico.util.Constantes;

import com.opensymphony.xwork2.ActionSupport;

import br.mdarte.exemplo.academico.web.geral.consultarEstudante.ConsultaEstudanteControleFactory;

public class PreenchaCamposConsultaEstudante extends br.mdarte.exemplo.academico.accessControl.Login2
{

	private java.util.Collection estudantes;
	public java.util.Collection getEstudantes() 
	{
		return estudantes;
	}

	public void setEstudantes(java.util.Collection estudantes)
	{
		this.estudantes = estudantes;
	}

	private java.lang.String cpf;
	public java.lang.String getCpf() 
	{
		return cpf;
	}

	public void setCpf(java.lang.String cpf)
	{
		this.cpf = cpf;
	}

	private java.lang.String nome;
	public java.lang.String getNome() 
	{
		return nome;
	}

	public void setNome(java.lang.String nome)
	{
		this.nome = nome;
	}

	private java.lang.Long idEstudante;
	public java.lang.Long getIdEstudante() 
	{
		return idEstudante;
	}

	public void setIdEstudante(Object idEstudante)
	{
		if(idEstudante == null) this.idEstudante = null;
		else if (idEstudante instanceof  String[]) {
			String temp = ((String[])idEstudante)[0];
			if (temp.isEmpty()) this.idEstudante = null;
			else this.idEstudante = java.lang.Long.valueOf(((String[])idEstudante)[0]);
		}
		else this.idEstudante = (java.lang.Long) idEstudante;
	}

	private java.lang.String matricula;
	public java.lang.String getMatricula() 
	{
		return matricula;
	}

	public void setMatricula(java.lang.String matricula)
	{
		this.matricula = matricula;
	}
	public void saveErrorMessage(String message)
	{
		org.apache.struts.action.ActionMessages messages = (org.apache.struts.action.ActionMessages)request.getSession().getAttribute(org.apache.struts.Globals.MESSAGE_KEY);
		if (messages == null)
		{
			messages = new org.apache.struts.action.ActionMessages();
			request.getSession().setAttribute(org.apache.struts.Globals.MESSAGE_KEY, messages);
		}
		messages.add("org.andromda.bpm4struts.errormessages", new org.apache.struts.action.ActionMessage(message, null));
	}

	public void validate()
	{
		//Removendo mensagens antigas
		//request.getSession().setAttribute(org.apache.struts.Globals.MESSAGE_KEY, new org.apache.struts.action.ActionMessages());

		//Validando campos

	}

	public String particularExecute() throws Exception
	{
		String casoDeUso = null;
		String urlCasoDeUso = null;
		String modulo = null;

		boolean adicionaBreadCrumb = true;
		casoDeUso = "ConsultaEstudanteUC";
		urlCasoDeUso = "/ConsultaEstudanteUC/PreenchaCamposConsultaEstudante";

		modulo = "geral";
		Iterator breadCrumbIt = null;
		ArrayList breadCrumbCollection = new ArrayList();
		breadCrumbCollection.add("<a href='javascript:window.location=getPath()+\"/ForwardAction.do?modulo=ConsultaEstudanteUC&path=/" + casoDeUso + ".action\"'>ConsultaEstudanteUC</a>");

		request.getSession().setAttribute("breadCrumb", breadCrumbCollection);
		request.getSession().setAttribute("nomeDeTela", casoDeUso);

		Boolean aplicacaoPermiteUsoBackBrowser = (Boolean) request.getSession().getServletContext().getAttribute("aplicacaoPermiteUsoBackBrowser");
		
		if (!aplicacaoPermiteUsoBackBrowser ^ false)
		{
			if(getInvalidatePageControlCounter(request).get("ConsultaEstudanteUC.PreenchaCampos") != null && request.getParameter("invalidatePageControlCounter") != null && !(((Integer)getInvalidatePageControlCounter(request).get("ConsultaEstudanteUC.PreenchaCampos")).equals(Integer.valueOf(request.getParameter("invalidatePageControlCounter")))))
			{
				javax.servlet.http.HttpSession session = request.getSession();
				org.apache.struts.action.ActionMessages messages = (org.apache.struts.action.ActionMessages)session.getAttribute(org.apache.struts.Globals.MESSAGE_KEY);
				if (messages == null)
				{
					messages = new org.apache.struts.action.ActionMessages();
					session.setAttribute(org.apache.struts.Globals.MESSAGE_KEY, messages);
				}
				messages.add("org.andromda.bpm4struts.errormessages", new org.apache.struts.action.ActionMessage("pagina.expirou"));
				
				return "forwardAction";
			}
		}

		String forward = null;
		String redirect = "";
		forward = "resultado.consulta";

		boolean copyParameters = true;

		if (request.getSession().getAttribute(Constantes.COPY_PARAMETERS) != null) {
			copyParameters = (Boolean) request.getSession().getAttribute(Constantes.COPY_PARAMETERS);
			request.getSession().removeAttribute(Constantes.COPY_PARAMETERS);
		}


		PreenchaCamposConsultaEstudanteFormImpl form = new PreenchaCamposConsultaEstudanteFormImpl();

		form.setEstudantes(this.estudantes);
		form.setCpf(this.cpf);
		form.setNome(this.nome);
		form.setIdEstudante(this.idEstudante);
		form.setMatricula(this.matricula);

		final PreenchaCamposConsultaEstudanteFormImpl specificForm = (PreenchaCamposConsultaEstudanteFormImpl)form;

		if(getInvalidatePageControlCounter(request).get("ConsultaEstudanteUC.PreenchaCampos") == null) 
			getInvalidatePageControlCounter(request).put("ConsultaEstudanteUC.PreenchaCampos", 0);
		getInvalidatePageControlCounter(request).put("ConsultaEstudanteUC.PreenchaCampos", ((Integer)getInvalidatePageControlCounter(request).get("ConsultaEstudanteUC.PreenchaCampos")).intValue() + 1);

		request.getSession().setAttribute("form", form);

		try
		{
			request.getSession().setAttribute(Constantes.ACAO_ATUAL, "/ConsultaEstudanteUC/PreenchaCamposConsultaEstudante.action");
			
			if(request.getParameter(Constantes.PARAMETRO_PAGINA) == null)
			{
				request.setAttribute(Constantes.PARAMETRO_GRUPO, 1);
				request.getSession().setAttribute("formPaginacao", form);
			}
			else
			{
				Object previusForm = (org.apache.struts.action.ActionForm)request.getSession().getAttribute("formPaginacao");
				org.apache.commons.beanutils.PropertyUtils.copyProperties(form, previusForm);
				request.setAttribute(Constantes.PARAMETRO_GRUPO, Integer.parseInt(request.getParameter(Constantes.PARAMETRO_PAGINA)));
				request.setAttribute(Constantes.ATTRIBUTE_TABLE, request.getParameter(Constantes.PARAMETRO_TABLE));
			}

			forward = _consultandoEstudante(form);

		}//fim try
		catch (java.lang.Exception exception)
		{
			Object formObj = org.andromda.presentation.bpm4struts.PageSessionObjectUtil.getPageForm(request, "ConsultaEstudanteUC.PreenchaCampos");

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
 		
		if(request.getAttribute("$forwardKeyModule") != null && !request.getAttribute("$forwardKeyModule").equals("geral")){
			java.util.Enumeration atributosName = request.getSession().getAttributeNames();
			java.util.Map atributos = new java.util.HashMap();

			while(atributosName.hasMoreElements()){
				String atributo = (String)atributosName.nextElement();
				atributos.put(atributo, request.getSession().getAttribute(atributo));
			}

			org.andromda.presentation.bpm4struts.ShareSessionUtil.saveMapIntoContext(request, response, atributos, ServletActionContext.getServletContext().getContext("/sistemaacademico"));
		}

		if (redirect != "") {//troca de modules - to be tested
			response.sendRedirect(redirect);
		}
		
		request.removeAttribute("$forwardKey");
		request.removeAttribute("$forwardKeyModule");
		
		return forward;
	}

	/**
	 * 
	 */
	private String _consultandoEstudante(org.apache.struts.validator.ValidatorForm form) throws java.lang.Exception
	{
		String forward = null;
		String redirect ="";
		request.getSession().setAttribute(org.apache.struts.Globals.MESSAGE_KEY, new org.apache.struts.action.ActionMessages());
	
		ConsultaEstudanteControleFactory.getConsultaEstudanteControleInstance().consultaEstudante((PreenchaCamposConsultaEstudanteFormImpl) form, new Struts2ViewContainer(this, request, response));
		if(getInvalidatePageControlCounter(request).get("ConsultaEstudanteUC.ResultadoConsulta") == null)
			getInvalidatePageControlCounter(request).put("ConsultaEstudanteUC.ResultadoConsulta", 0);
		getInvalidatePageControlCounter(request).put("ConsultaEstudanteUC.ResultadoConsulta", ((Integer)getInvalidatePageControlCounter(request).get("ConsultaEstudanteUC.ResultadoConsulta")).intValue() + 1);

		org.andromda.presentation.bpm4struts.PageSessionObjectUtil.setPageSO(request, new org.andromda.presentation.bpm4struts.FormSessionObject("ConsultaEstudanteUC.ResultadoConsulta", form, 5));

		if (request.getAttribute("$forwardKey") != null) {
			forward = (String)request.getAttribute("$forwardKey"); 
		} else {
			forward ="resultado.consulta"; 
		}



		return forward;
	}
 

	private java.util.Map getInvalidatePageControlCounter(javax.servlet.http.HttpServletRequest request)
	{
		java.util.Map invalidatePageControlCounter = (java.util.Map)request.getSession().getAttribute("invalidatePageControlCounter");

		if(invalidatePageControlCounter == null)
		{
			invalidatePageControlCounter = new java.util.HashMap();
			request.getSession().setAttribute("invalidatePageControlCounter", invalidatePageControlCounter);
		}

		return invalidatePageControlCounter;
	}

	public void loadUseCaseInfo()
	{
		__casoDeUso = "ConsultaEstudanteUC";
		__urlCasoDeUso = "/ConsultaEstudanteUC/PreenchaCamposConsultaEstudante.action";
		__modulo = "geral";
		__contexto = "";
	}
}
