<%@ include file="/taglib-imports.jspf" %>
<%@ include file="/layout-configuration.jsp" %>

<div id="FormLinhaBotoes">
	<security:containsPermission name="detalha.curso.uc.detalhando.curso.voltar">
		<input id="detalhaCursoUCDetalhandoCursoVoltarForm" class="btn btn-primary" name="detalhaCursoUCDetalhandoCursoVoltarForm" value="<s:property value="%{getText('detalha.curso.uc.detalhando.curso.voltar')}" />" type="button"/>
	</security:containsPermission>

	<security:containsPermission name="detalha.curso.uc.detalhando.curso.edita.curso">
		<input id="detalhaCursoUCDetalhandoCursoEditaCursoForm" class="btn btn-primary" name="detalhaCursoUCDetalhandoCursoEditaCursoForm" value="<s:property value="%{getText('detalha.curso.uc.detalhando.curso.edita.curso')}" />" type="button"/>
	</security:containsPermission>

</div>
<br class="clr"/>
