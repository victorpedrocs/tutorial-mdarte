<%@ include file="/taglib-imports.jspf" %>
<%@ include file="/layout-configuration.jsp" %>

<div id="FormLinhaBotoes">
	<security:containsPermission name="mantem.estudante.uc.alterando.estudante.salva.estudante">
		<input id="mantemEstudanteUCAlterandoEstudanteSalvaEstudanteForm" class="btn btn-primary" name="mantemEstudanteUCAlterandoEstudanteSalvaEstudanteForm" value="<s:property value="%{getText('mantem.estudante.uc.alterando.estudante.salva.estudante')}" />" type="button"/>
	</security:containsPermission>

	<security:containsPermission name="mantem.estudante.uc.alterando.estudante.voltar">
		<input id="mantemEstudanteUCAlterandoEstudanteVoltarForm" class="btn btn-primary" name="mantemEstudanteUCAlterandoEstudanteVoltarForm" value="<s:property value="%{getText('mantem.estudante.uc.alterando.estudante.voltar')}" />" type="button"/>
	</security:containsPermission>

</div>
<br class="clr"/>
