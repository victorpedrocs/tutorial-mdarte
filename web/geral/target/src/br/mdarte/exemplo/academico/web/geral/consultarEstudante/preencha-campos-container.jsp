<%@ include file="/taglib-imports.jspf"%>
<%@ include file="/layout-configuration.jsp"%>
<div id="consultaEstudante" class="action">
	<div class="trigger">
		<s:form action="PreenchaCamposConsultaEstudante" namespace="/ConsultaEstudanteUC" method="post" enctype="multipart/form-data" cssClass="form-horizontal">
			<s:actionerror />
			<%@ include file="/br/mdarte/exemplo/academico/web/geral/consultarEstudante/preencha-campos-fields.jsp" %>
			<%@ include file="/br/mdarte/exemplo/academico/web/geral/consultarEstudante/preencha-campos-actions.jsp" %>
		</s:form>
	</div>
</div>
