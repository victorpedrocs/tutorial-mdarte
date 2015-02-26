<%@ include file="/taglib-imports.jspf"%>
<%@ include file="/layout-configuration.jsp"%>
<div id="novaConsulta" class="action">
	<div class="trigger">
				<s:form id="consultaCursoUCResultadoConsultaNovaConsultaForm" action="ResultadoConsultaNovaConsulta" namespace="/ConsultaCursoUC" method="post" cssClass="form-horizontal">
			<s:actionerror />
			<%@ include file="/br/mdarte/exemplo/academico/web/geral/consultarCurso/resultado-consulta-actions.jsp" %>
		</s:form>
	</div>
</div>
