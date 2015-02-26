
package org.andromda.presentation.bpm4struts;

import java.io.PrintWriter;

import java.util.Map;
import java.util.HashMap;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.andromda.presentation.bpm4struts.ShareSessionUtil;

import org.apache.struts.action.ActionForward;

public class ActionUtil{
	//Usado em Actions que sï¿½o requisitadas por ajax
	public static void criaXml(PrintWriter out , Object campoAlterado, String nomeCampo, String fieldType){
		if(fieldType.equals("Collection")|| fieldType.equals("List")){
    		for(Object obj : (java.util.Collection)campoAlterado){
    			out.print("<"+nomeCampo+">");
        		out.print(obj.toString());
        		out.print("</"+nomeCampo+">");
    		}
		}else{
			if(fieldType.equals("Map")){
				for(Object obj : ((Map)campoAlterado).keySet()){
        			out.print("<"+nomeCampo+" chave=\""+obj.toString()+"\">");
            		out.print(((Map)campoAlterado).get(obj).toString());
            		out.print("</"+nomeCampo+">");
				}
			}else{
        		out.print("<"+nomeCampo+">");
        		out.print(campoAlterado);
        		out.print("</"+nomeCampo+">");
			}
		}
        
	}
	public static void copiaParametrosSessao(HttpServletRequest request , HttpServletResponse response, String contexto){
			org.apache.struts.action.ActionForward forward = null;

		Enumeration atributosName = request.getSession().getAttributeNames();
		
		Map atributos = new java.util.HashMap();
        
		while(atributosName.hasMoreElements()){
			String atributo = (String)atributosName.nextElement();
			atributos.put(atributo, request.getSession().getAttribute(atributo));
		}
	
		// salva mapa da sessao no contexto
		ShareSessionUtil.saveMapIntoContext(request, response, atributos, request.getSession().getServletContext().getContext(contexto));
	}
}