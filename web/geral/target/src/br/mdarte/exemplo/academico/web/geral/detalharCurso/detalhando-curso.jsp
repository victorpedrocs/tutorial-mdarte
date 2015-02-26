<%
	Object form = org.andromda.presentation.bpm4struts.PageSessionObjectUtil.getPageForm(request, "DetalhaCursoUC.DetalhandoCurso");
	request.getSession().setAttribute("form", form);
	request.setAttribute("form", form);
%>
<%@ include file="/taglib-imports.jspf" %>
<%@ include file="/layout-configuration.jsp" %>
<tiles:insert definition="main.layout2">

<tiles:put name="title" type="string">
	<bean:message key="detalha.curso.uc.detalhando.curso.title"/>
</tiles:put>

<tiles:put name="style" type="string">
	<link rel="stylesheet" type="text/css" media="screen" href="<html:rewrite page="/br/mdarte/exemplo/academico/web/geral/detalharCurso/detalhando-curso.css"/>"></link>
	<link rel="stylesheet" type="text/css" media="screen" href="<html:rewrite page="/br/mdarte/exemplo/academico/web/geral/detalharCurso/detalhando-curso-impl.css"/>"></link>
</tiles:put>

<%@ include file="/br/mdarte/exemplo/academico/web/geral/detalharCurso/detalhando-curso-javascript.jspf" %>

<tiles:put name="pathway" type="string">
	<div id="pathway">
		<h2><bean:message key="detalha.curso.uc.detalhando.curso.title"/></h2>
		<br/>
	</div>
</tiles:put>

<tiles:put name="vars" type="string">
</tiles:put>

<tiles:put name="tables" type="string">
</tiles:put>

<tiles:put name="other" type="string">
	<script src="detalhando-curso.js"></script>
	<script src="detalhando-curso-impl.js"></script>
</tiles:put>

<tiles:put name="body" type="string">
	<tiles:insert page="/br/mdarte/exemplo/academico/web/geral/detalharCurso/detalhando-curso-container.jsp" flush="false"/>


</tiles:put>
</tiles:insert>
