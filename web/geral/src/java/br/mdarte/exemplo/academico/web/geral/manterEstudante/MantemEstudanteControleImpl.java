
// license-header java merge-point
package br.mdarte.exemplo.academico.web.geral.manterEstudante;
import br.mdarte.exemplo.academico.ServiceLocator;
import br.mdarte.exemplo.academico.cd.Estudante;
import br.mdarte.exemplo.academico.cd.EstudanteImpl;
import br.mdarte.exemplo.academico.util.Constantes;

import org.andromda.presentation.bpm4struts.ViewContainer;

import br.mdarte.exemplo.academico.util.PaginationStrategy;

/**
 * @see br.mdarte.exemplo.academico.web.geral.manterEstudante.MantemEstudanteControle
 */
public class MantemEstudanteControleImpl extends MantemEstudanteControle
{
    /**
     * @see br.mdarte.exemplo.academico.web.geral.manterEstudante.MantemEstudanteControle#carregaEstudante(br.mdarte.exemplo.academico.web.geral.manterEstudante.CarregaEstudanteForm)
     */
    public final void carregaEstudante(br.mdarte.exemplo.academico.web.geral.manterEstudante.CarregaEstudanteForm form, ViewContainer container) throws Exception {
    	
		Integer pagina = ((Double)container.getAttribute(Constantes.PARAMETRO_PAGINA)).intValue();
		br.mdarte.exemplo.academico.util.PaginationDisplaytag paginacao = new br.mdarte.exemplo.academico.util.PaginationDisplaytag(pagina);
		
		Estudante estudante = new EstudanteImpl();
		
		estudante.setId(form.getIdEstudante());
		estudante = (EstudanteImpl) ServiceLocator.instance().getEstudanteHandlerBI().selectEstudante(estudante).get(0);
		
		form.setNome(estudante.getNome());
		form.setMatricula(estudante.getMatricula());
		form.setIdEstudante(estudante.getId());
    }

    /**
     * @see br.mdarte.exemplo.academico.web.geral.manterEstudante.MantemEstudanteControle#salvaEstudante(br.mdarte.exemplo.academico.web.geral.manterEstudante.SalvaEstudanteForm)
     */
    public final void salvaEstudante(br.mdarte.exemplo.academico.web.geral.manterEstudante.SalvaEstudanteForm form, ViewContainer container) throws Exception {
//    	/*Caso seja necessario usar paginacao		
		Integer pagina = ((Double)container.getAttribute(Constantes.PARAMETRO_PAGINA)).intValue();
		br.mdarte.exemplo.academico.util.PaginationDisplaytag paginacao = new br.mdarte.exemplo.academico.util.PaginationDisplaytag(pagina);
		
		Estudante estudante = new EstudanteImpl();
		
		estudante.setId(form.getIdEstudante());
		estudante.setNome(form.getNome());
		estudante.setMatricula(form.getMatricula());
		
		ServiceLocator.instance().getEstudanteHandlerBI().insertOrUpdateEstudante(estudante);
    }

}
