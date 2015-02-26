package br.mdarte.exemplo.academico.action;

import br.mdarte.exemplo.academico.cd.AbstractDAO;
import br.mdarte.exemplo.academico.cd.DAOException;
import br.mdarte.exemplo.academico.cd.AbstractEntity;
import br.mdarte.exemplo.academico.util.PaginationStrategy;
import br.ufrj.coppetec.to.AbstractTO;

public class DefaultFilterAction extends Action {

	private AbstractTO to;
	private PaginationStrategy paginacao;
	
	public DefaultFilterAction(){
		to = null;
		paginacao = null;
	}
	
	public DefaultFilterAction(AbstractTO to, PaginationStrategy paginacao){
		this.to = to;
		this.paginacao = paginacao;
	}

	
	protected java.util.List<AbstractEntity> execute(AbstractEntity to, AbstractDAO dao) throws DAOException {
		return dao.defaultFilter(this.to, paginacao);
	}
		
	public AbstractTO getTo(){
		return to;
	}
	
	public PaginationStrategy getPaginacao(){
		return paginacao;
	}
}