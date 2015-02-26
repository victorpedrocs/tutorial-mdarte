package br.mdarte.exemplo.academico.export;

import java.io.File;
import java.util.HashMap;

import br.mdarte.exemplo.academico.cd.AbstractDAO;
import br.mdarte.exemplo.academico.cd.DAOException;
import br.ufrj.coppetec.ValueObject;

import org.dom4j.Element;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 * Classe responsavel por fazer a importacao de
 * dados para a base atraves da leitura de um 
 * arquivo XML.
 * 
 * @author vinicius
 *
 */
public class XMLImport extends Import {

	private AbstractDAO dao;
	private HashMap mapErros = new HashMap();
	private boolean inicioLoop;
	private int tot;
	private int sucesso;
	private int ultimoSucesso;

	public XMLImport(File file){
		super(file);
	}
	
	/**
	 * Classe invocada pelo SAX parser que gera uma arvore DOM
	 * para cada elemento identificado por <raiz_elemento>
	 * e chama o metodo xmlImportEntity do dao
	 * 
	 * @author vinicius
	 *
	 */
	private class ExportXMLHandler extends DefaultHandler
	{
		private Element raiz;
		private Element pai;
		
		public ExportXMLHandler ()
		{
			super();
		}
		
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
		{
			if (qName.equalsIgnoreCase("raiz_documento"))
			{
				tot = 0; 
				sucesso = 0;
			}
			else if (qName.equalsIgnoreCase("raiz_elemento"))
			{
				if (!inicioLoop && !mapErros.containsKey(new Integer(tot)))
					return;
			
				raiz = org.dom4j.DocumentHelper.createElement("raiz_elemento");
				pai = raiz;
			}
			else 
			{
				if (!inicioLoop && !mapErros.containsKey(new Integer(tot)))
					return;
			
				pai = pai.addElement(qName);
			}
		}
		
		public void endElement(String uri, String localName, String qName) throws SAXException
		{
			if (qName.equalsIgnoreCase("raiz_elemento"))
			{
				try {
					int retorno = 0;
					
					if (inicioLoop || mapErros.containsKey(new Integer(tot)))
					{
						retorno = dao.xmlImportEntity(raiz);
						if (retorno == 0) 
							mapErros.remove(new Integer(tot));
					}
										
					if (retorno == 0) 
					{
						sucesso++;
					}
					else if (retorno == 1)
					{
						mapErros.put(new Integer(tot), null);
					}
						
				}
				catch (DAOException e)
				{
					throw new SAXException(e);
				}
				tot++;
			}
			else if (!qName.equalsIgnoreCase("raiz_documento"))
			{
				pai = pai.getParent();
			}
		}
		
		public void characters(char[] ch, int start, int length) throws SAXException
		{
			if (!inicioLoop && !mapErros.containsKey(new Integer(tot)))
				return;
		
			pai.addText(String.copyValueOf(ch, start, length));
		}
	}
	
	public void importa(AbstractDAO dao, ValueObject vo) throws DAOException
	{
		DefaultHandler handler = new ExportXMLHandler();
		
		this.dao = dao;
		
		SAXParserFactory factory = SAXParserFactory.newInstance();

		inicioLoop = true;
		
		try 
		{
			SAXParser saxParser = factory.newSAXParser();		
			saxParser.parse(file, handler); 
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
		
		while (sucesso < tot)
		{
			ultimoSucesso = sucesso;
		
			try 
			{
				SAXParser saxParser = factory.newSAXParser();
				saxParser.parse(file, handler); 
			} 
			catch (Throwable t) 
			{
				throw new RuntimeException(t);
			}
			
			if (ultimoSucesso == sucesso) break;
		}
		
		if (sucesso < tot)
		{
			throw new RuntimeException("error.default.importaction.exception");
		}
		
		System.out.println("Importacao executada.");
		System.out.println("Total de objetos no arquivo: " + String.valueOf(tot));
		System.out.println("Total importado com sucesso: " + String.valueOf(sucesso));
	}
	
	public void setFile(java.io.File file){
		this.file = file;
	}
	
	public java.io.File getFile(){
		return this.file;
	}
}
