package br.mdarte.exemplo.academico.cd;

import br.mdarte.exemplo.academico.cd.AbstractEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.CallbackException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import accessControl.ControleAcesso;

import br.mdarte.exemplo.academico.util.PaginationStrategy;
import br.mdarte.exemplo.academico.cd.LogInterceptor;

public abstract class AbstractDAO {

	private static Log log = LogFactory.getLog(AbstractDAO.class);

	public static final SessionFactory sessionFactory;

	private static String BD_USUARIO = null;
	private static String BD_NOME = null;

	private static final String HIBERNATE_CFG_FILE = "sistemaacademico.cfg.xml";


	static {
		try {
			// Create the SessionFactory
			Configuration configuration = new Configuration().configure(HIBERNATE_CFG_FILE);
            sessionFactory = configuration.buildSessionFactory();
			/*
			 * Hashtable env = new Hashtable();
			 * env.put(Context.INITIAL_CONTEXT_FACTORY,
			 * "org.jnp.interfaces.NamingContextFactory");
			 * env.put(Context.PROVIDER_URL, "localhost");
			 * env.put("java.naming.factory.url.pkgs",
			 * "org.jboss.naming:org.jnp.interfaces"); Context ctx = new
			 * InitialContext(env); String jndiName =
			 * "java:/hibernate/HibernateFactory"; sessionFactory =
			 * (SessionFactory) ctx.lookup(jndiName);
			 */

		} catch (Throwable ex) {
			log.error("Initial SessionFactory creation failed.", ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static final ThreadLocal session = new ThreadLocal();

	public static Session currentSession() throws HibernateException {
		Session s = (Session) session.get();
		// Open a new Session, if this Thread has none yet
		if (s == null) {
			s = sessionFactory.openSession(new LogInterceptor());
			session.set(s);
		}
		return s;
	}
	
	public static boolean getSession(){
	org.hibernate.Session session = (org.hibernate.Session) br.mdarte.exemplo.academico.cd.AbstractDAO.session.get();
	boolean responsibleSession = false;
	if(session == null){
		responsibleSession = true;
		session = br.mdarte.exemplo.academico.cd.AbstractDAO.currentSession();
	}
	return  responsibleSession;
    }
	

	public static void closeSession() throws HibernateException {
		Session s = (Session) session.get();
		session.set(null);
		if (s != null)
			s.close();
	}

	public static String getDatabaseName() throws HibernateException {
		if (BD_NOME == null) {
			String url;
			DatabaseMetaData metadata;
			try {
				metadata = currentSession().connection().getMetaData();
				url = metadata.getURL();
			} catch (SQLException e) {
				throw new HibernateException("erro.recuperar.database.name",e);
			}
			url = url.substring(url.lastIndexOf(':') + 1);
			BD_NOME = url.toUpperCase();
		}
		return BD_NOME;
	}

	public static String getDatabaseUser() throws HibernateException {
		if (BD_USUARIO == null) {
			DatabaseMetaData metadata;
			try {
				metadata = currentSession().connection().getMetaData();
				BD_USUARIO = metadata.getUserName().toLowerCase();
			} catch (SQLException e) {
				throw new HibernateException("erro.recuperar.database.user",e);
			}
		}
		return BD_USUARIO;
	}

	public abstract java.util.List<AbstractEntity> select(long id) throws DAOException;
	
	public abstract java.util.List<AbstractEntity> insert(AbstractEntity objTO) throws DAOException;

	public abstract java.util.List<AbstractEntity> insertOrUpdate(AbstractEntity objTO) throws DAOException;
	
	public abstract java.util.List<AbstractEntity> update(AbstractEntity objTO) throws DAOException;
	
	public abstract java.util.List<AbstractEntity> delete(AbstractEntity objTO) throws DAOException;
	
	public abstract java.util.List<AbstractEntity> list(PaginationStrategy paginacao, String propriedade, Boolean desc) throws DAOException;
	
	public abstract java.util.List<AbstractEntity> filter(br.ufrj.coppetec.DataObject vo, PaginationStrategy paginacao) throws DAOException;
	
	public abstract java.util.List<AbstractEntity> defaultFilter(br.ufrj.coppetec.to.AbstractTO to, PaginationStrategy paginacao) throws DAOException;
	
	public abstract org.hibernate.Criteria xmlExport(br.ufrj.coppetec.ValueObject vo, org.hibernate.Session session) throws DAOException;
	
	public abstract org.dom4j.Element xmlExportEntity(AbstractEntity entity) throws DAOException;
	
	public org.dom4j.Element xmlExportEntity(AbstractEntity entity, org.dom4j.Element raiz) throws DAOException
	{ return null; }	

	public abstract int xmlImportEntity(org.dom4j.Element raiz) throws DAOException;
	
	public abstract void logEvent(String msg , AbstractEntity entity) throws CallbackException; 
}