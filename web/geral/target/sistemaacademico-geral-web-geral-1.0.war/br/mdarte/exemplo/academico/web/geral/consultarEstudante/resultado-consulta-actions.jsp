<%@ include file="/taglib-imports.jspf" %>
<%@ include file="/layout-configuration.jsp" %>

<div class="FormLinhaBotoes">
	<security:containsPermission name="consulta.estudante.uc.resultado.consulta.nova.consulta">
		<input id="consultaEstudanteUCResultadoConsultaNovaConsultaForm" class="btn btn-primary" name="consultaEstudanteUCResultadoConsultaNovaConsultaForm" value="<s:property value="%{getText('consulta.estudante.uc.resultado.consulta.nova.consulta')}" />" type="button"/>
	</security:containsPermission>

</div>
<br class="clr"/>
