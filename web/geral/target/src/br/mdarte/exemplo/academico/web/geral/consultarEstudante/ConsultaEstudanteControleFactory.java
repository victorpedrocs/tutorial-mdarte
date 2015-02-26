// license-header java merge-point
package br.mdarte.exemplo.academico.web.geral.consultarEstudante;

public class ConsultaEstudanteControleFactory
{
    private final static ConsultaEstudanteControle INSTANCE = new ConsultaEstudanteControleImpl();

    public final static ConsultaEstudanteControle getConsultaEstudanteControleInstance()
    {
        return INSTANCE;
    }
}
