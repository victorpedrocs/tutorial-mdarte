// license-header java merge-point
// Attention: Generated code! Do not modify by hand!
// Generated by: EntityTOInterface.vsl in andromda-hibernate-cartridge.
//

package br.mdarte.exemplo.academico.cd;

/**
 * 
 */
 
public interface  Estudante extends
br.ufrj.coppetec.Entity
{
    public int getHibernate_version();

    public java.lang.String getMatricula();
    public void setMatricula(java.lang.String matricula);

    public java.lang.String getNome();
    public void setNome(java.lang.String nome);

    public java.lang.Long getId();
    public void setId(java.lang.Long id);

    public br.mdarte.exemplo.academico.cd.Curso getCurso();

    public void setCurso(br.mdarte.exemplo.academico.cd.Curso curso);

    public void setCursoInverse(br.mdarte.exemplo.academico.cd.Curso curso) ;
    public br.ufrj.coppetec.Entity getInstance();

    public boolean instanceOf(Class<?> otherClass);
}