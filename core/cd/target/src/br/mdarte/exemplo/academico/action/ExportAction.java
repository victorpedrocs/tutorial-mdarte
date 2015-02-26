package br.mdarte.exemplo.academico.action;

import br.mdarte.exemplo.academico.cd.AbstractDAO;
import br.mdarte.exemplo.academico.cd.DAOException;
import br.mdarte.exemplo.academico.cd.AbstractEntity;
import br.ufrj.coppetec.ValueObject;
import br.mdarte.exemplo.academico.export.Export;



public class ExportAction extends Action{

	private ValueObject vo;
	private Export export;
	private AbstractDAO dao;
	
	
	public ExportAction(ValueObject vo, Export export){
		this.vo = vo;
		this.export = export;
	}
	
	protected java.util.List<AbstractEntity> execute(AbstractEntity to, AbstractDAO dao) throws DAOException {
		this.dao = dao;
		export.export(dao, this.vo);
		return null;
	}
	
	public Export getExport(){
		return export;
	}
	
	public ValueObject getVo(){
		return vo;
	}
	
	
}