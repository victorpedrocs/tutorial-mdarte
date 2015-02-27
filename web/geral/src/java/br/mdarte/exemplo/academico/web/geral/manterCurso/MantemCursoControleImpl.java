
// license-header java merge-point
package br.mdarte.exemplo.academico.web.geral.manterCurso;
import br.mdarte.exemplo.academico.ServiceLocator;
import br.mdarte.exemplo.academico.cd.Curso;
import br.mdarte.exemplo.academico.cd.CursoImpl;
import br.mdarte.exemplo.academico.cd.Estudante;
import br.mdarte.exemplo.academico.cd.EstudanteImpl;
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
	
		Integer pagina = ((Double)container.getAttribute(Constantes.PARAMETRO_PAGINA)).intValue();
		br.mdarte.exemplo.academico.util.PaginationDisplaytag paginacao = new br.mdarte.exemplo.academico.util.PaginationDisplaytag(pagina);
		
		Curso curso = new CursoImpl();
		
		curso.setId(form.getIdCurso());
		curso = (CursoImpl) ServiceLocator.instance().getCursoHandlerBI().selectCurso(curso).iterator().next();
		
		form.setNome(curso.getNome());
		form.setCodigo(curso.getCodigo());
		form.setIdCurso(curso.getId());
    }

    /**
     * @see br.mdarte.exemplo.academico.web.geral.manterCurso.MantemCursoControle#salvaCurso(br.mdarte.exemplo.academico.web.geral.manterCurso.SalvaCursoForm)
     */
    public final void salvaCurso(br.mdarte.exemplo.academico.web.geral.manterCurso.SalvaCursoForm form, ViewContainer container) throws Exception {
    	
    	Integer pagina = ((Double)container.getAttribute(Constantes.PARAMETRO_PAGINA)).intValue();
		br.mdarte.exemplo.academico.util.PaginationDisplaytag paginacao = new br.mdarte.exemplo.academico.util.PaginationDisplaytag(pagina);
		
		Curso curso = new CursoImpl();
		curso.setId(form.getIdCurso());
		
		curso.setId(form.getIdCurso());
		curso.setNome(form.getNome());
		curso.setCodigo(form.getCodigo());
		
		ServiceLocator.instance().getCursoHandlerBI().insertOrUpdateCurso(curso);
    }

}
