// license-header java merge-point
package br.mdarte.exemplo.academico.web.geral.detalharEstudante;

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
public abstract class DetalhaEstudanteControle extends ControllerAbstract
{

	/**
     * 
	 */
	public abstract void carregaEstudante(br.mdarte.exemplo.academico.web.geral.detalharEstudante.CarregaEstudanteForm form,  ViewContainer container) throws java.lang.Exception;


	protected java.util.Collection<String> getModoOperacao(ViewContainer container) {
		return getModoOperacao(this.getNomeCasoUso(), container);
	}
	
	protected String getNomeCasoUso() {
		return "geral/DetalhaEstudanteUC/DetalhaEstudanteUC.action";
	}
}

