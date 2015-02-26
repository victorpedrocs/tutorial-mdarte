// license-header java merge-point
package br.mdarte.exemplo.academico.web.geral.manterCurso;

import br.mdarte.exemplo.academico.util.Constantes;
import br.mdarte.exemplo.academico.util.PaginationStrategy;
import org.andromda.presentation.bpm4struts.ViewContainer;
import org.andromda.presentation.bpm4struts.ControllerAbstract;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.Collection;

/**
 * 
 */
public abstract class MantemCursoControle extends ControllerAbstract
{

	/**
     * 
	 */
	public abstract void carregaCurso(br.mdarte.exemplo.academico.web.geral.manterCurso.CarregaCursoForm form,  ViewContainer container) throws java.lang.Exception;

	/**
     * 
	 */
	public abstract void salvaCurso(br.mdarte.exemplo.academico.web.geral.manterCurso.SalvaCursoForm form,  ViewContainer container) throws java.lang.Exception;


	protected java.util.Collection<String> getModoOperacao(ViewContainer container) {
		return getModoOperacao(this.getNomeCasoUso(), container);
	}
	
	protected String getNomeCasoUso() {
		return "geral/MantemCursoUC/MantemCursoUC.action";
	}
}

