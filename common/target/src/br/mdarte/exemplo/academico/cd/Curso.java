// license-header java merge-point
// Attention: Generated code! Do not modify by hand!
// Generated by: EntityTOInterface.vsl in andromda-hibernate-cartridge.
//

package br.mdarte.exemplo.academico.cd;

/**
 * 
 */
 
public interface  Curso extends
br.ufrj.coppetec.Entity
{
    public int getHibernate_version();

    public java.lang.String getCodigo();
    public void setCodigo(java.lang.String codigo);

    public java.lang.String getNome();
    public void setNome(java.lang.String nome);

    public java.lang.Long getId();
    public void setId(java.lang.Long id);

    public java.util.Collection getEstudantes();

    public void setEstudantes(java.util.Collection estudantes);

    public void setEstudantesInverse(java.util.Collection estudantes) ;

    public void addEstudantes(br.mdarte.exemplo.academico.cd.Estudante estudanteTemp) ;

    public void removeEstudantes(br.mdarte.exemplo.academico.cd.Estudante estudanteTemp) ;

    public br.ufrj.coppetec.Entity getInstance();

    public boolean instanceOf(Class<?> otherClass);
}