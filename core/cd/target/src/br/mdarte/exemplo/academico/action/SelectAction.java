package br.mdarte.exemplo.academico.action;

import br.mdarte.exemplo.academico.cd.AbstractDAO;
import br.mdarte.exemplo.academico.cd.DAOException;
import br.mdarte.exemplo.academico.cd.AbstractEntity;



public class SelectAction extends Action{

	protected java.util.List<AbstractEntity> execute(AbstractEntity cd, AbstractDAO dao) throws DAOException {
		return dao.select(cd.getId().longValue());
	}
}
