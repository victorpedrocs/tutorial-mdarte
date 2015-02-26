<%@ include file="/taglib-imports.jspf" %>
<%@ include file="/layout-configuration.jsp" %>

<div id="FormLinhaBotoes">
	<security:containsPermission name="detalha.estudante.uc.detalhando.estudante.voltar">
		<input id="detalhaEstudanteUCDetalhandoEstudanteVoltarForm" class="btn btn-primary" name="detalhaEstudanteUCDetalhandoEstudanteVoltarForm" value="<s:property value="%{getText('detalha.estudante.uc.detalhando.estudante.voltar')}" />" type="button"/>
	</security:containsPermission>

	<security:containsPermission name="detalha.estudante.uc.detalhando.estudante.edita.estudante">
		<input id="detalhaEstudanteUCDetalhandoEstudanteEditaEstudanteForm" class="btn btn-primary" name="detalhaEstudanteUCDetalhandoEstudanteEditaEstudanteForm" value="<s:property value="%{getText('detalha.estudante.uc.detalhando.estudante.edita.estudante')}" />" type="button"/>
	</security:containsPermission>

</div>
<br class="clr"/>
