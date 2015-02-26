<%@ include file="/taglib-imports.jspf"%>
<%@ include file="/layout-configuration.jsp"%>
<div id="novaConsulta" class="action">
	<div class="trigger">
				<s:form id="consultaEstudanteUCResultadoConsultaNovaConsultaForm" action="ResultadoConsultaNovaConsulta" namespace="/ConsultaEstudanteUC" method="post" cssClass="form-horizontal">
			<s:actionerror />
			<%@ include file="/br/mdarte/exemplo/academico/web/geral/consultarEstudante/resultado-consulta-actions.jsp" %>
		</s:form>
	</div>
</div>
