
// license-header java merge-point
package br.mdarte.exemplo.academico.web.geral.detalharEstudante;
import br.mdarte.exemplo.academico.util.Constantes;
import org.andromda.presentation.bpm4struts.ViewContainer;
import br.mdarte.exemplo.academico.util.PaginationStrategy;

/**
 * @see br.mdarte.exemplo.academico.web.geral.detalharEstudante.DetalhaEstudanteControle
 */
public class DetalhaEstudanteControleImpl extends DetalhaEstudanteControle
{
    /**
     * @see br.mdarte.exemplo.academico.web.geral.detalharEstudante.DetalhaEstudanteControle#carregaEstudante(br.mdarte.exemplo.academico.web.geral.detalharEstudante.CarregaEstudanteForm)
     */
    public final void carregaEstudante(br.mdarte.exemplo.academico.web.geral.detalharEstudante.CarregaEstudanteForm form, ViewContainer container) throws Exception {
    	/*Caso seja necessario usar paginacao		
    		Integer pagina = ((Double)container.getAttribute(Constantes.PARAMETRO_PAGINA)).intValue();
			br.mdarte.exemplo.academico.util.PaginationDisplaytag paginacao = new br.mdarte.exemplo.academico.util.PaginationDisplaytag(pagina);
		*/	
        // nothing to be done for this operation, there are no properties that can be set
    }

}
