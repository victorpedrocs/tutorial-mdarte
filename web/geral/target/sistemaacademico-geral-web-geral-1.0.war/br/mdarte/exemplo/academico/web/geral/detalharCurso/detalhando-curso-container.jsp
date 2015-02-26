<%@ include file="/taglib-imports.jspf"%>
<%@ include file="/layout-configuration.jsp"%>
<div id="voltar" class="action">
	<div class="trigger">
		<s:form action="DetalhandoCursoVoltar" namespace="/DetalhaCursoUC" method="post" enctype="multipart/form-data" cssClass="form-horizontal">
			<s:actionerror />
			<%@ include file="/br/mdarte/exemplo/academico/web/geral/detalharCurso/detalhando-curso-fields.jsp" %>
			<%@ include file="/br/mdarte/exemplo/academico/web/geral/detalharCurso/detalhando-curso-actions.jsp" %>
		</s:form>
	</div>
</div>
