<%@ include file="/taglib-imports.jspf"%>
<%@ include file="/layout-configuration.jsp"%>
<div id="consultaCurso" class="action">
	<div class="trigger">
		<s:form action="PreenchaCamposConsultaCurso" namespace="/ConsultaCursoUC" method="post" enctype="multipart/form-data" cssClass="form-horizontal">
			<s:actionerror />
			<%@ include file="/br/mdarte/exemplo/academico/web/geral/consultarCurso/preencha-campos-fields.jsp" %>
			<%@ include file="/br/mdarte/exemplo/academico/web/geral/consultarCurso/preencha-campos-actions.jsp" %>
		</s:form>
	</div>
</div>
