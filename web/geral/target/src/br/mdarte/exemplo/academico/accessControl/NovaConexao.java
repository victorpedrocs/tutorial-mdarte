// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: NovaConexao.java.vsl in andromda-bpm4struts-cartridge-coppetec.
//
package br.mdarte.exemplo.academico.accessControl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.andromda.presentation.bpm4struts.ShareSessionUtil;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class NovaConexao extends Action {


	private class SistemaModulo {
		public String sistema;
		public String modulo;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ActionForward forward = null;

		// redireciona para o NovaConexao do modulo principal
		String uriForward = request.getScheme() + "://" + (request.getServerName() + (request.getServerPort( ) != 80 ? ":" + request.getServerPort( ) : "")).replace("//","/");
		forward = new ActionForward(uriForward + "/sistemaacademico/secure/NovaConexao.do", true);
		return forward;
	}
}