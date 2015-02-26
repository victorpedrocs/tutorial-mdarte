// license-header java merge-point
package br.mdarte.exemplo.academico.web.geral.detalharCurso;

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
public abstract class DetalhaCursoControle extends ControllerAbstract
{

	/**
     * 
	 */
	public abstract void carregaCurso(br.mdarte.exemplo.academico.web.geral.detalharCurso.CarregaCursoForm form,  ViewContainer container) throws java.lang.Exception;


	protected java.util.Collection<String> getModoOperacao(ViewContainer container) {
		return getModoOperacao(this.getNomeCasoUso(), container);
	}
	
	protected String getNomeCasoUso() {
		return "geral/DetalhaCursoUC/DetalhaCursoUC.action";
	}
}

