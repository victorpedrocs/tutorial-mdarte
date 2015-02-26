package br.mdarte.exemplo.academico;

/**
 * Load the processes when the JBoss is started.
 * 
 */
public interface InitialServiceMBean extends org.jboss.system.ServiceMBean
{
	public void startService() throws Exception;
}
