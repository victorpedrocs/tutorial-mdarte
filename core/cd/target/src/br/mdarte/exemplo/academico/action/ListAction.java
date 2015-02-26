package br.mdarte.exemplo.academico.action;

import br.mdarte.exemplo.academico.cd.AbstractDAO;
import br.mdarte.exemplo.academico.cd.DAOException;
import br.mdarte.exemplo.academico.cd.AbstractEntity;
import br.mdarte.exemplo.academico.util.PaginationStrategy;

public class ListAction extends Action{

	private String propriedade;
	private PaginationStrategy paginacao;
	private Boolean desc;
	
	public ListAction(){
		this.propriedade = null;
		this.paginacao = null;
		this.desc = Boolean.FALSE;
	}
	
	public ListAction(String propriedade, Boolean desc){
		this.propriedade = propriedade;
		this.paginacao = null;
		this.desc = desc;
	}
	
	public ListAction(String propriedade, Boolean desc, PaginationStrategy paginacao) {
		this.propriedade = propriedade;
		this.paginacao = paginacao;
		this.desc = desc;
	}

	protected java.util.List<AbstractEntity> execute(AbstractEntity to, AbstractDAO dao) throws DAOException {
		return dao.list(paginacao, propriedade, desc);
	}
	
	public String getPropriedade(){
		return this.propriedade;
	}
	
	public Boolean getDesc(){
		return this.desc;
	}
		
	public PaginationStrategy getPaginacao(){
		return this.paginacao;
	}

}
