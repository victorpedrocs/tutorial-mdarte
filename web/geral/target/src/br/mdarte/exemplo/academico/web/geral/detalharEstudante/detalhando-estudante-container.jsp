<%@ include file="/taglib-imports.jspf"%>
<%@ include file="/layout-configuration.jsp"%>
<div id="voltar" class="action">
	<div class="trigger">
		<s:form action="DetalhandoEstudanteVoltar" namespace="/DetalhaEstudanteUC" method="post" enctype="multipart/form-data" cssClass="form-horizontal">
			<s:actionerror />
			<%@ include file="/br/mdarte/exemplo/academico/web/geral/detalharEstudante/detalhando-estudante-fields.jsp" %>
			<%@ include file="/br/mdarte/exemplo/academico/web/geral/detalharEstudante/detalhando-estudante-actions.jsp" %>
		</s:form>
	</div>
</div>
