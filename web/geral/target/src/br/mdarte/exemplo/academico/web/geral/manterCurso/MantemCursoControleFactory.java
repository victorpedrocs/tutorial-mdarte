// license-header java merge-point
package br.mdarte.exemplo.academico.web.geral.manterCurso;

public class MantemCursoControleFactory
{
    private final static MantemCursoControle INSTANCE = new MantemCursoControleImpl();

    public final static MantemCursoControle getMantemCursoControleInstance()
    {
        return INSTANCE;
    }
}
