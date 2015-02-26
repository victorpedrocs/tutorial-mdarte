// license-header java merge-point
package br.mdarte.exemplo.academico.cd.crud;

public final class CursoForm
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
{
    private java.util.List manageableList = null;

    public java.util.List getManageableList()
    {
        return this.manageableList;
    }

    public void setManageableList(java.util.List manageableList)
    {
        this.manageableList = manageableList;
    }

    private java.lang.Long[] selectedRows = null;

    public java.lang.Long[] getSelectedRows()
    {
        return this.selectedRows;
    }

    public void setSelectedRows(java.lang.Long[] selectedRows)
    {
        this.selectedRows = selectedRows;
    }

    private java.lang.String codigo;

    public java.lang.String getCodigo()
    {
        return this.codigo;
    }

    public void setCodigo(java.lang.String codigo)
    {
        this.codigo = codigo;
    }

    private java.lang.String nome;

    public java.lang.String getNome()
    {
        return this.nome;
    }

    public void setNome(java.lang.String nome)
    {
        this.nome = nome;
    }

    private java.lang.Long id;

    public java.lang.Long getId()
    {
        return this.id;
    }

    public void setId(java.lang.Long id)
    {
        this.id = id;
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        codigo = null;
        nome = null;
        id = null;
    }
}