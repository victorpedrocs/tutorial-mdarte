
// license-header java merge-point
package br.mdarte.exemplo.academico.web.geral.consultarCurso;
import java.util.ArrayList;
import java.util.Collection;

import br.mdarte.exemplo.academico.ServiceLocator;
import br.mdarte.exemplo.academico.action.DefaultFilterAction;
import br.mdarte.exemplo.academico.action.FilterAction;
import br.mdarte.exemplo.academico.cd.Curso;
import br.mdarte.exemplo.academico.cd.CursoImpl;
import br.mdarte.exemplo.academico.to.CursoTO;
import br.mdarte.exemplo.academico.to.CursoTOImpl;
import br.mdarte.exemplo.academico.to.EstudanteTO;
import br.mdarte.exemplo.academico.to.EstudanteTOImpl;
import br.mdarte.exemplo.academico.util.Constantes;
import br.mdarte.exemplo.academico.util.Util;

import org.andromda.presentation.bpm4struts.ViewContainer;

import br.mdarte.exemplo.academico.util.PaginationStrategy;
import br.mdarte.exemplo.academico.vo.CursoVO;

/**
 * @see br.mdarte.exemplo.academico.web.geral.consultarCurso.ConsultaCursoControle
 */
public class ConsultaCursoControleImpl extends ConsultaCursoControle
{
    /**
     * @see br.mdarte.exemplo.academico.web.geral.consultarCurso.ConsultaCursoControle#consultaCurso(br.mdarte.exemplo.academico.web.geral.consultarCurso.ConsultaCursoForm)
     */
    public final void consultaCurso(br.mdarte.exemplo.academico.web.geral.consultarCurso.ConsultaCursoForm form, ViewContainer container) throws Exception {
    			
		Integer pagina = ((Double)container.getAttribute(Constantes.PARAMETRO_PAGINA)).intValue();
		br.mdarte.exemplo.academico.util.PaginationDisplaytag paginacao = new br.mdarte.exemplo.academico.util.PaginationDisplaytag(pagina);
			
    	CursoTO cursoTO = new CursoTOImpl();
    	
    	cursoTO.setNome(form.getNome());
    	cursoTO.setCodigo(form.getCodigo());
    	
    	Collection cursos = ServiceLocator.instance().getCursoHandlerBI().manipulaCurso(new CursoImpl(), new DefaultFilterAction(cursoTO, paginacao));
    	
    	ArrayList<CursoVO> cursoVOs = new ArrayList<CursoVO>();
    	
    	if (!Util.checkEmpty(cursos)) {
			for (Curso curso : (Collection<Curso>) cursos) {
				CursoVO cursoVO = new CursoVO();
				
				cursoVO.setCodigo(curso.getCodigo());
				cursoVO.setNome(curso.getNome());
				cursoVO.setId(curso.getId());
				
				cursoVOs.add(cursoVO);
			}
			form.setCursos(cursoVOs);
    	}

    }
}