// license-header java merge-point
package br.mdarte.exemplo.academico.web.geral.consultarEstudante;

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
public abstract class ConsultaEstudanteControle extends ControllerAbstract
{

	/**
     * 
	 */
	public abstract void consultaEstudante(br.mdarte.exemplo.academico.web.geral.consultarEstudante.ConsultaEstudanteForm form,  ViewContainer container) throws java.lang.Exception;


	protected abstract String[] matriculaPreenchaCamposAutoComplete(String query, ViewContainer container) throws Exception;
	
	public void matriculaPreenchaCamposAutoComplete(ViewContainer container) throws Exception
	{	
		String [] result;
    	
    	String query = container.getParameter("query");
    	
    	if(query == null)
    		query = "";
  
		result =  this.matriculaPreenchaCamposAutoComplete(query, container);

		JSONArray jsonArray = new JSONArray();
		
		if(result != null)
		{
			for (String string : result)
			{
				jsonArray.add(string);
		    }
		}
    	
		container.setContentType("application/json;charset=UTF-8");
    	container.getWriter().write(jsonArray.toString());
    	
	}

	protected java.util.Collection<String> getModoOperacao(ViewContainer container) {
		return getModoOperacao(this.getNomeCasoUso(), container);
	}
	
	protected String getNomeCasoUso() {
		return "geral/ConsultaEstudanteUC/ConsultaEstudanteUC.action";
	}
}

