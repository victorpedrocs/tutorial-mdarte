
// license-header java merge-point
package br.mdarte.exemplo.academico.web.geral.detalharCurso;
import br.mdarte.exemplo.academico.ServiceLocator;
import br.mdarte.exemplo.academico.cd.Curso;
import br.mdarte.exemplo.academico.cd.CursoImpl;
import br.mdarte.exemplo.academico.cd.Estudante;
import br.mdarte.exemplo.academico.cd.EstudanteImpl;
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

    	Integer pagina = ((Double)container.getAttribute(Constantes.PARAMETRO_PAGINA)).intValue();
		br.mdarte.exemplo.academico.util.PaginationDisplaytag paginacao = new br.mdarte.exemplo.academico.util.PaginationDisplaytag(pagina);
		
		Estudante estudante = new EstudanteImpl();
		Curso curso = new CursoImpl();
		
		curso.setId(form.getIdCurso());
		
		curso = (Curso) ServiceLocator.instance().getCursoHandlerBI().selectCurso(curso).iterator().next();
		
		if (curso != null) {
			form.setNome(curso.getNome());
			form.setCodigo(curso.getCodigo());
			form.setIdCurso(curso.getId());
		}
    }

}
