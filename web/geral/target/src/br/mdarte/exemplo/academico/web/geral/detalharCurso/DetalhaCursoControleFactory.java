// license-header java merge-point
package br.mdarte.exemplo.academico.web.geral.detalharCurso;

public class DetalhaCursoControleFactory
{
    private final static DetalhaCursoControle INSTANCE = new DetalhaCursoControleImpl();

    public final static DetalhaCursoControle getDetalhaCursoControleInstance()
    {
        return INSTANCE;
    }
}
