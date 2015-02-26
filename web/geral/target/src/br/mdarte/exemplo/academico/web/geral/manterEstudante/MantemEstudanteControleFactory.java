// license-header java merge-point
package br.mdarte.exemplo.academico.web.geral.manterEstudante;

public class MantemEstudanteControleFactory
{
    private final static MantemEstudanteControle INSTANCE = new MantemEstudanteControleImpl();

    public final static MantemEstudanteControle getMantemEstudanteControleInstance()
    {
        return INSTANCE;
    }
}
