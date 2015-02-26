
// license-header java merge-point
package br.mdarte.exemplo.academico.web.geral.manterCurso;
import br.mdarte.exemplo.academico.util.Constantes;
import org.andromda.presentation.bpm4struts.ViewContainer;
import br.mdarte.exemplo.academico.util.PaginationStrategy;

/**
 * @see br.mdarte.exemplo.academico.web.geral.manterCurso.MantemCursoControle
 */
public class MantemCursoControleImpl extends MantemCursoControle
{
    /**
     * @see br.mdarte.exemplo.academico.web.geral.manterCurso.MantemCursoControle#carregaCurso(br.mdarte.exemplo.academico.web.geral.manterCurso.CarregaCursoForm)
     */
    public final void carregaCurso(br.mdarte.exemplo.academico.web.geral.manterCurso.CarregaCursoForm form, ViewContainer container) throws Exception {
    	/*Caso seja necessario usar paginacao		
    		Integer pagina = ((Double)container.getAttribute(Constantes.PARAMETRO_PAGINA)).intValue();
			br.mdarte.exemplo.academico.util.PaginationDisplaytag paginacao = new br.mdarte.exemplo.academico.util.PaginationDisplaytag(pagina);
		*/	
        // nothing to be done for this operation, there are no properties that can be set
    }

    /**
     * @see br.mdarte.exemplo.academico.web.geral.manterCurso.MantemCursoControle#salvaCurso(br.mdarte.exemplo.academico.web.geral.manterCurso.SalvaCursoForm)
     */
    public final void salvaCurso(br.mdarte.exemplo.academico.web.geral.manterCurso.SalvaCursoForm form, ViewContainer container) throws Exception {
    	/*Caso seja necessario usar paginacao		
    		Integer pagina = ((Double)container.getAttribute(Constantes.PARAMETRO_PAGINA)).intValue();
			br.mdarte.exemplo.academico.util.PaginationDisplaytag paginacao = new br.mdarte.exemplo.academico.util.PaginationDisplaytag(pagina);
		*/	
        // nothing to be done for this operation, there are no properties that can be set
    }

}
