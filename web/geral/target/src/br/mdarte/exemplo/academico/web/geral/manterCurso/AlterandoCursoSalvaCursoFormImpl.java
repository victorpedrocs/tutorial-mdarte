
// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: bpm4struts2/forms/ActionForm.java.vsl in andromda-bpm4struts-cartridge-coppetec.
//
package br.mdarte.exemplo.academico.web.geral.manterCurso;

import org.apache.struts.util.MessageResources;
import org.apache.struts.Globals;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class AlterandoCursoSalvaCursoFormImpl
    extends br.mdarte.exemplo.academico.accessControl.LoginFormImpl
    implements java.io.Serializable
        , br.mdarte.exemplo.academico.web.geral.manterCurso.SalvaCursoForm
{

    private final static DecimalFormatSymbols simbolosDecimais = new DecimalFormatSymbols(Locale.US);
    static 
    {
        simbolosDecimais.setGroupingSeparator('.');
        simbolosDecimais.setDecimalSeparator(',');
	}

    private final static int TAMANHO_MAXIMO_LABEL_DESTINO = 250;

    private java.lang.String codigo;


    private java.lang.Long idCurso;


    private java.lang.String nome;


    public AlterandoCursoSalvaCursoFormImpl(){

    }

    /**
     * Resets the given <code>codigo</code>.
     */
    public void resetCodigo()
    {
		this.codigo = null;
    }


    public void setCodigo(java.lang.String codigo)
    {
        this.codigo = codigo;
    }

    /**
     * 
     */
    public java.lang.String getCodigo()
    {
        return this.codigo;
    }
    


    /**
     * Resets the given <code>idCurso</code>.
     */
    public void resetIdCurso()
    {
		this.idCurso = null;
    }


    public void setIdCurso(java.lang.Long idCurso)
    {
        this.idCurso = idCurso;
    }

    /**
     * 
     */
    public java.lang.Long getIdCurso()
    {
        return this.idCurso;
    }
    


    /**
     * Resets the given <code>nome</code>.
     */
    public void resetNome()
    {
		this.nome = null;
    }


    public void setNome(java.lang.String nome)
    {
        this.nome = nome;
    }

    /**
     * 
     */
    public java.lang.String getNome()
    {
        return this.nome;
    }
    


    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
    }

	/**
     * @see org.apache.struts.validator.ValidatorForm#resetCheckBoxes(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void resetCheckBoxes(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("codigo", this.codigo);
        builder.append("idCurso", this.idCurso);
        builder.append("nome", this.nome);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.codigo = null;
        this.idCurso = null;
        this.nome = null;
    }

    /**
     * Override to provide population of current form with request parameters when validation fails.
     *
     * @see org.apache.struts.action.ActionForm#validate(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
     */
    public org.apache.struts.action.ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        final org.apache.struts.action.ActionErrors errors = super.validate(mapping, request);
        if (errors != null && !errors.isEmpty())
        {
			Object formObj = org.andromda.presentation.bpm4struts.PageSessionObjectUtil.getPageForm(request, "MantemCursoUC.AlterandoCurso");

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
        }
        return errors;
    }

 
    /** Verifica se o campo esta sendo exibido na tela */
    public boolean isFieldVisibleInOperationMode(String field, java.util.Collection modosOperacao) {
	String modoPermitido = null;
	java.util.StringTokenizer tokenizerModosPermitidos = null;
        java.util.StringTokenizer tokenizerModosPossuidos = null;

        return true;
    }
    
    public String getOperationModeKey(){
        return "geral/MantemCursoUC/MantemCursoUC.do";
    }
	
}
