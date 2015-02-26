package br.mdarte.exemplo.academico.action;

import br.mdarte.exemplo.academico.cd.AbstractDAO;
import br.mdarte.exemplo.academico.cd.DAOException;
import br.mdarte.exemplo.academico.cd.AbstractEntity;
import br.ufrj.coppetec.DataObject;
import br.ufrj.coppetec.ValueObject;
import br.mdarte.exemplo.academico.util.PaginationStrategy;
import br.mdarte.exemplo.academico.util.Constantes;

public class FilterAction extends Action {

	private DataObject vo;
	private PaginationStrategy paginacao;
	
	
	public FilterAction(){
		this.vo = null;
		this.paginacao = null;
	}
	
	public FilterAction(DataObject vo, PaginationStrategy paginacao){
		this.vo = vo;
		this.paginacao = paginacao;
	}

	
	protected java.util.List<AbstractEntity> execute(AbstractEntity to, AbstractDAO dao) throws DAOException {
		return dao.filter(vo, paginacao);
	}
		
	public DataObject getVo(){
		return this.vo;
	}
	
	public PaginationStrategy getPaginacao(){
		return this.paginacao;
	}

}
