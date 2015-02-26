// license-header java merge-point
package br.mdarte.exemplo.academico.web.geral.detalharEstudante;

public class DetalhaEstudanteControleFactory
{
    private final static DetalhaEstudanteControle INSTANCE = new DetalhaEstudanteControleImpl();

    public final static DetalhaEstudanteControle getDetalhaEstudanteControleInstance()
    {
        return INSTANCE;
    }
}
