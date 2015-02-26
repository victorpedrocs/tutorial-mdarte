<%
	Object form = org.andromda.presentation.bpm4struts.PageSessionObjectUtil.getPageForm(request, "ConsultaCursoUC.PreenchaCampos");
	request.getSession().setAttribute("form", form);
	request.setAttribute("form", form);
%>
<%@ include file="/taglib-imports.jspf" %>
<%@ include file="/layout-configuration.jsp" %>
<tiles:insert definition="main.layout2">

<tiles:put name="title" type="string">
	<bean:message key="consulta.curso.uc.preencha.campos.title"/>
</tiles:put>

<tiles:put name="style" type="string">
	<link rel="stylesheet" type="text/css" media="screen" href="<html:rewrite page="/br/mdarte/exemplo/academico/web/geral/consultarCurso/preencha-campos.css"/>"></link>
	<link rel="stylesheet" type="text/css" media="screen" href="<html:rewrite page="/br/mdarte/exemplo/academico/web/geral/consultarCurso/preencha-campos-impl.css"/>"></link>
</tiles:put>

<%@ include file="/br/mdarte/exemplo/academico/web/geral/consultarCurso/preencha-campos-javascript.jspf" %>

<tiles:put name="pathway" type="string">
	<div id="pathway">
		<h2><bean:message key="consulta.curso.uc.preencha.campos.title"/></h2>
		<br/>
	</div>
</tiles:put>

<tiles:put name="vars" type="string">
</tiles:put>

<tiles:put name="tables" type="string">
</tiles:put>

<tiles:put name="other" type="string">
	<script src="preencha-campos.js"></script>
	<script src="preencha-campos-impl.js"></script>
</tiles:put>

<tiles:put name="body" type="string">
	<tiles:insert page="/br/mdarte/exemplo/academico/web/geral/consultarCurso/preencha-campos-container.jsp" flush="false"/>


</tiles:put>
</tiles:insert>
