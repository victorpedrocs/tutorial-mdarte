package br.mdarte.exemplo.academico.action;

import br.mdarte.exemplo.academico.cd.AbstractDAO;
import br.mdarte.exemplo.academico.cd.DAOException;
import br.mdarte.exemplo.academico.cd.AbstractEntity;



public abstract class Action {
	
	public java.util.List<AbstractEntity> execute (AbstractEntity AbstractEntity) throws DAOException{
		AbstractDAO dao = AbstractEntity.getDaoImpl();
		return execute(AbstractEntity, dao);
	}

	protected abstract java.util.List<AbstractEntity> execute(AbstractEntity cd, AbstractDAO dao) throws DAOException ;
}
