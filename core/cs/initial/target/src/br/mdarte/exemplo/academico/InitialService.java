package br.mdarte.exemplo.academico;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import accessControl.ControleAcesso;
import br.mdarte.exemplo.academico.accessControl.ControleAcessoImpl;
import accessControl.Perfil;
import accessControl.ServicosSingleton;

/**
 * Load the processes when the JBoss is started.
 * 
 */
public class InitialService extends org.jboss.system.ServiceMBeanSupport implements InitialServiceMBean
{
	/**
	 * Log.
	 */
	private static Log s_log = LogFactory.getLog(InitialService.class);

	/**
	 * @see org.jboss.system.ServiceMBeanSupport#startService()
	 */
	public void startService() throws Exception
	{
		try
		{
			ControleAcessoImpl controleAcesso = new ControleAcessoImpl();

			HashMap<String, ControleAcesso> controles = ServicosSingleton.instance().getControles();
			if (controles == null)
			{
				controles = new HashMap<String, ControleAcesso>();
			}
			controles.put("sistemaacademico", controleAcesso);

			ServicosSingleton.instance().setControles(controles);

			HashMap listaServicosProjeto = controleAcesso.listaServicos();
			HashMap<String, HashMap<String, java.util.Collection<Perfil>>> listaServicos = ServicosSingleton.instance().getServicos();
			if (listaServicos == null)
			{
				listaServicos = new HashMap<String, HashMap<String, java.util.Collection<Perfil>>>();
			}
			listaServicos.put("sistemaacademico", listaServicosProjeto);
			ServicosSingleton.instance().setServicos(listaServicos);

			HashMap<String, Boolean> demanda = ServicosSingleton.instance().getDemanda();
			if (demanda == null)
			{
				demanda = new HashMap<String, Boolean>();
			}
			demanda.put("sistemaacademico", false);

			ServicosSingleton.instance().setDemanda(demanda);

			controleAcesso.agendaTarefas();
		}
		catch (Exception e)
		{
			s_log.error("Nao foi possivel listar os servicos", new RuntimeException(e));
		}
	}
}
