package br.mdarte.exemplo.academico.export;

import br.mdarte.exemplo.academico.cd.AbstractDAO;
import br.mdarte.exemplo.academico.cd.DAOException;
import br.mdarte.exemplo.academico.cd.AbstractEntity;
import br.ufrj.coppetec.ValueObject;

import java.io.File;

public abstract class Import {

	java.io.File file;
	
	public Import(File file){
		this.file = file;
	}

	public abstract void importa(AbstractDAO dao, ValueObject vo) throws DAOException;
}
