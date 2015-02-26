<%@ include file="/taglib-imports.jspf"%>
<%@ include file="/layout-configuration.jsp"%>
<div id="salvaCurso" class="action">
	<div class="trigger">
		<s:form action="AlterandoCursoSalvaCurso" namespace="/MantemCursoUC" method="post" enctype="multipart/form-data" cssClass="form-horizontal">
			<s:actionerror />
			<%@ include file="/br/mdarte/exemplo/academico/web/geral/manterCurso/alterando-curso-fields.jsp" %>
			<%@ include file="/br/mdarte/exemplo/academico/web/geral/manterCurso/alterando-curso-actions.jsp" %>
		</s:form>
	</div>
</div>
