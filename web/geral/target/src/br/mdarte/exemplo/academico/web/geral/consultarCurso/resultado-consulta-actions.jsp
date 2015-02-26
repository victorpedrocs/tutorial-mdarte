<%@ include file="/taglib-imports.jspf" %>
<%@ include file="/layout-configuration.jsp" %>

<div class="FormLinhaBotoes">
	<security:containsPermission name="consulta.curso.uc.resultado.consulta.nova.consulta">
		<input id="consultaCursoUCResultadoConsultaNovaConsultaForm" class="btn btn-primary" name="consultaCursoUCResultadoConsultaNovaConsultaForm" value="<s:property value="%{getText('consulta.curso.uc.resultado.consulta.nova.consulta')}" />" type="button"/>
	</security:containsPermission>

</div>
<br class="clr"/>
