
// license-header java merge-point
package br.mdarte.exemplo.academico.web.geral.detalharCurso;
import br.mdarte.exemplo.academico.util.Constantes;
import org.andromda.presentation.bpm4struts.ViewContainer;
import br.mdarte.exemplo.academico.util.PaginationStrategy;

/**
 * @see br.mdarte.exemplo.academico.web.geral.detalharCurso.DetalhaCursoControle
 */
public class DetalhaCursoControleImpl extends DetalhaCursoControle
{
    /**
     * @see br.mdarte.exemplo.academico.web.geral.detalharCurso.DetalhaCursoControle#carregaCurso(br.mdarte.exemplo.academico.web.geral.detalharCurso.CarregaCursoForm)
     */
    public final void carregaCurso(br.mdarte.exemplo.academico.web.geral.detalharCurso.CarregaCursoForm form, ViewContainer container) throws Exception {
    	/*Caso seja necessario usar paginacao		
    		Integer pagina = ((Double)container.getAttribute(Constantes.PARAMETRO_PAGINA)).intValue();
			br.mdarte.exemplo.academico.util.PaginationDisplaytag paginacao = new br.mdarte.exemplo.academico.util.PaginationDisplaytag(pagina);
		*/	
        // nothing to be done for this operation, there are no properties that can be set
    }

}
