// license-header java merge-point
package br.mdarte.exemplo.academico.web.geral.consultarCurso;

public class ConsultaCursoControleFactory
{
    private final static ConsultaCursoControle INSTANCE = new ConsultaCursoControleImpl();

    public final static ConsultaCursoControle getConsultaCursoControleInstance()
    {
        return INSTANCE;
    }
}
