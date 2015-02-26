<%@ include file="/taglib-imports.jspf" %>
<%@ include file="/layout-configuration.jsp" %>

<div id="FormLinhaBotoes">
	<security:containsPermission name="consulta.estudante.uc.preencha.campos.consulta.estudante">
		<input id="consultaEstudanteUCPreenchaCamposConsultaEstudanteForm" class="btn btn-primary" name="consultaEstudanteUCPreenchaCamposConsultaEstudanteForm" value="<s:property value="%{getText('consulta.estudante.uc.preencha.campos.consulta.estudante')}" />" type="button"/>
	</security:containsPermission>

</div>
<br class="clr"/>
