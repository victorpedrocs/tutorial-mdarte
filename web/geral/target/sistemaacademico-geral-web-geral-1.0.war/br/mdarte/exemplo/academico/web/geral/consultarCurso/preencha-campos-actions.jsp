<%@ include file="/taglib-imports.jspf" %>
<%@ include file="/layout-configuration.jsp" %>

<div id="FormLinhaBotoes">
	<security:containsPermission name="consulta.curso.uc.preencha.campos.consulta.curso">
		<input id="consultaCursoUCPreenchaCamposConsultaCursoForm" class="btn btn-primary" name="consultaCursoUCPreenchaCamposConsultaCursoForm" value="<s:property value="%{getText('consulta.curso.uc.preencha.campos.consulta.curso')}" />" type="button"/>
	</security:containsPermission>

</div>
<br class="clr"/>
