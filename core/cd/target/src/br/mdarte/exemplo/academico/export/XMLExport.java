package br.mdarte.exemplo.academico.export;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import br.mdarte.exemplo.academico.cd.AbstractDAO;
import br.mdarte.exemplo.academico.cd.DAOException;
import br.mdarte.exemplo.academico.cd.AbstractEntity;
import br.ufrj.coppetec.ValueObject;

import org.dom4j.Document;
import org.dom4j.Element;
import org.hibernate.EntityMode;
import org.hibernate.Session;


import org.hibernate.Criteria;



public class XMLExport extends Export{

	private static final int PAGINA = 200;

	public XMLExport(File file){
		super(file);
	}
	
	public void export(AbstractDAO dao, ValueObject vo){
		try{
			StringBuffer sb = new StringBuffer();
			OutputStream bos = new FileOutputStream (this.file);
			Criteria criteria = dao.xmlExport(vo, AbstractDAO.currentSession());
			
			Document doc = org.dom4j.DocumentHelper.createDocument();
		    	sb.append(doc.asXML());
		    	sb.append("<raiz_documento>");
		    	
			bos.write(sb.toString().getBytes());
			bos.close();
	
			sb = new StringBuffer();
			for(int i = 0;;i++)
			{
				java.util.List lista = criteria.setFirstResult(i*PAGINA).setMaxResults(PAGINA).list();
    	
				if(lista.size() == 0) break;
				
				for ( int j=0; j < lista.size(); j++) 
				{
					sb.append(dao.xmlExportEntity((AbstractEntity) lista.get(j)).asXML());
				}
				
				bos = new FileOutputStream (this.file, true);
				bos.write(sb.toString().getBytes());
				bos.close();
				
				sb = new StringBuffer();
			}
			
		    	sb.append("</raiz_documento>");
			
			bos = new FileOutputStream (this.file, true);
			bos.write(sb.toString().getBytes());
			bos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void setFile(java.io.File file){
		this.file = file;
	}
	
	public java.io.File getFile(){
		return this.file;
	}
}
