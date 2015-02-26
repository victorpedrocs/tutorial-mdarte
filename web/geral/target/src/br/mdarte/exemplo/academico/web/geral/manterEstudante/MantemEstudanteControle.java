// license-header java merge-point
package br.mdarte.exemplo.academico.web.geral.manterEstudante;

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
public abstract class MantemEstudanteControle extends ControllerAbstract
{

	/**
     * 
	 */
	public abstract void carregaEstudante(br.mdarte.exemplo.academico.web.geral.manterEstudante.CarregaEstudanteForm form,  ViewContainer container) throws java.lang.Exception;

	/**
     * 
	 */
	public abstract void salvaEstudante(br.mdarte.exemplo.academico.web.geral.manterEstudante.SalvaEstudanteForm form,  ViewContainer container) throws java.lang.Exception;


	protected java.util.Collection<String> getModoOperacao(ViewContainer container) {
		return getModoOperacao(this.getNomeCasoUso(), container);
	}
	
	protected String getNomeCasoUso() {
		return "geral/MantemEstudanteUC/MantemEstudanteUC.action";
	}
}

