package br.mdarte.exemplo.academico.action;

import br.mdarte.exemplo.academico.cd.AbstractDAO;
import br.mdarte.exemplo.academico.cd.DAOException;
import br.mdarte.exemplo.academico.cd.AbstractEntity;


public class UpdateAction extends Action{

	protected java.util.List<AbstractEntity> execute(AbstractEntity to, AbstractDAO dao) throws DAOException {
		return dao.update(to);
	}

}
