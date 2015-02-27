
// license-header java merge-point
package br.mdarte.exemplo.academico.web.geral.consultarEstudante;
import java.util.ArrayList;
import java.util.Collection;

import br.mdarte.exemplo.academico.ServiceLocator;
import br.mdarte.exemplo.academico.action.DefaultFilterAction;
import br.mdarte.exemplo.academico.cd.Estudante;
import br.mdarte.exemplo.academico.cd.EstudanteImpl;
import br.mdarte.exemplo.academico.to.EstudanteTO;
import br.mdarte.exemplo.academico.to.EstudanteTOImpl;
import br.mdarte.exemplo.academico.util.Constantes;
import br.mdarte.exemplo.academico.util.Util;

import org.andromda.presentation.bpm4struts.ViewContainer;

import br.mdarte.exemplo.academico.util.PaginationStrategy;
import br.mdarte.exemplo.academico.vo.EstudanteVO;

/**
 * @see br.mdarte.exemplo.academico.web.geral.consultarEstudante.ConsultaEstudanteControle
 */
public class ConsultaEstudanteControleImpl extends ConsultaEstudanteControle
{
    /**
     * @see br.mdarte.exemplo.academico.web.geral.consultarEstudante.ConsultaEstudanteControle#consultaEstudante(br.mdarte.exemplo.academico.web.geral.consultarEstudante.ConsultaEstudanteForm)
     */
    public final void consultaEstudante(br.mdarte.exemplo.academico.web.geral.consultarEstudante.ConsultaEstudanteForm form, ViewContainer container) throws Exception {
//    	Caso seja necessario usar paginacao		
    	Integer pagina = ((Double)container.getAttribute(Constantes.PARAMETRO_PAGINA)).intValue();
		br.mdarte.exemplo.academico.util.PaginationDisplaytag paginacao = new br.mdarte.exemplo.academico.util.PaginationDisplaytag(pagina);
		
		EstudanteTO estudanteTO = new EstudanteTOImpl();
		
		estudanteTO.setNome(form.getNome());
		estudanteTO.setMatricula(form.getMatricula());
		
		Collection estudantes = ServiceLocator.instance().getEstudanteHandlerBI().manipulaEstudante(new EstudanteImpl(), new DefaultFilterAction(estudanteTO, paginacao));
		
		ArrayList<EstudanteVO> estudanteVOs = new ArrayList<EstudanteVO>();
		
		if (!Util.checkEmpty(estudantes)) {
			for (Estudante estudante : (Collection<Estudante>)estudantes) {
				EstudanteVO estudanteVO = new EstudanteVO();
				
				estudanteVO.setMatricula(estudante.getMatricula());
				estudanteVO.setNome(estudante.getNome());
				estudanteVO.setId(estudante.getId());
				
				estudanteVOs.add(estudanteVO);
			}
			
			form.setEstudantes(estudanteVOs);
		}
        
    }

}
