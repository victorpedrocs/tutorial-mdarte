package br.mdarte.exemplo.academico.action;

import br.mdarte.exemplo.academico.cd.AbstractDAO;
import br.mdarte.exemplo.academico.cd.DAOException;
import br.mdarte.exemplo.academico.cd.AbstractEntity;
import br.ufrj.coppetec.ValueObject;
import br.mdarte.exemplo.academico.export.Import;



public class ImportAction extends Action{

	private ValueObject vo;
	private Import importa;
	
	
	public ImportAction(ValueObject vo, Import importa){
		this.vo = vo;
		this.importa = importa;
	}
	
	protected java.util.List<AbstractEntity> execute(AbstractEntity to, AbstractDAO dao) throws DAOException {
		importa.importa(dao, this.vo);
		return null;
	}

	public Import getImport(){
		return importa;
	}
	
	public ValueObject getVo(){
		return vo;
	}	
}