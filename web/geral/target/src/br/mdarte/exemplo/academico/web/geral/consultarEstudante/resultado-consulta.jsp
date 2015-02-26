<%
	Object form = org.andromda.presentation.bpm4struts.PageSessionObjectUtil.getPageForm(request, "ConsultaEstudanteUC.ResultadoConsulta");
	request.getSession().setAttribute("form", form);
	request.setAttribute("form", form);
%>
<%@ include file="/taglib-imports.jspf" %>
<%@ include file="/layout-configuration.jsp" %>
<tiles:insert definition="main.layout2">

<tiles:put name="title" type="string">
	<bean:message key="consulta.estudante.uc.resultado.consulta.title"/>
</tiles:put>

<tiles:put name="style" type="string">
	<link rel="stylesheet" type="text/css" media="screen" href="<html:rewrite page="/br/mdarte/exemplo/academico/web/geral/consultarEstudante/resultado-consulta.css"/>"></link>
	<link rel="stylesheet" type="text/css" media="screen" href="<html:rewrite page="/br/mdarte/exemplo/academico/web/geral/consultarEstudante/resultado-consulta-impl.css"/>"></link>
</tiles:put>

<%@ include file="/br/mdarte/exemplo/academico/web/geral/consultarEstudante/resultado-consulta-javascript.jspf" %>

<tiles:put name="pathway" type="string">
	<div id="pathway">
		<h2><bean:message key="consulta.estudante.uc.resultado.consulta.title"/></h2>
		<br/>
	</div>
</tiles:put>

<tiles:put name="vars" type="string">
	<%@ include file="/br/mdarte/exemplo/academico/web/geral/consultarEstudante/resultado-consulta-vars.jspf" %>
</tiles:put>

<tiles:put name="tables" type="string">
	<%@ include file="/br/mdarte/exemplo/academico/web/geral/consultarEstudante/resultado-consulta-tabelas.jsp"%>
</tiles:put>

<tiles:put name="other" type="string">
	<script src="resultado-consulta.js"></script>
	<script src="resultado-consulta-impl.js"></script>
</tiles:put>

<tiles:put name="body" type="string">
	<tiles:insert page="/br/mdarte/exemplo/academico/web/geral/consultarEstudante/resultado-consulta-container.jsp" flush="false"/>


</tiles:put>
</tiles:insert>
