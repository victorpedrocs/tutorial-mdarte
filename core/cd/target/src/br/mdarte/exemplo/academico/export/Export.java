package br.mdarte.exemplo.academico.export;

import br.mdarte.exemplo.academico.cd.AbstractDAO;
import br.mdarte.exemplo.academico.cd.DAOException;
import br.mdarte.exemplo.academico.cd.AbstractEntity;
import br.ufrj.coppetec.ValueObject;

import java.io.File;

public abstract class Export {

	java.io.File file;
	
	public Export(File file){
		this.file = file;
	}

	public abstract void export(AbstractDAO dao, ValueObject vo);
}
