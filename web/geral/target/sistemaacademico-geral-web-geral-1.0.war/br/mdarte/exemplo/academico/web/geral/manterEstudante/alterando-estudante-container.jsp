<%@ include file="/taglib-imports.jspf"%>
<%@ include file="/layout-configuration.jsp"%>
<div id="salvaEstudante" class="action">
	<div class="trigger">
		<s:form action="AlterandoEstudanteSalvaEstudante" namespace="/MantemEstudanteUC" method="post" enctype="multipart/form-data" cssClass="form-horizontal">
			<s:actionerror />
			<%@ include file="/br/mdarte/exemplo/academico/web/geral/manterEstudante/alterando-estudante-fields.jsp" %>
			<%@ include file="/br/mdarte/exemplo/academico/web/geral/manterEstudante/alterando-estudante-actions.jsp" %>
		</s:form>
	</div>
</div>
