<%@ include file="/taglib-imports.jspf" %>
<%@ include file="/layout-configuration.jsp" %>

<div id="FormLinhaBotoes">
	<security:containsPermission name="mantem.curso.uc.alterando.curso.salva.curso">
		<input id="mantemCursoUCAlterandoCursoSalvaCursoForm" class="btn btn-primary" name="mantemCursoUCAlterandoCursoSalvaCursoForm" value="<s:property value="%{getText('mantem.curso.uc.alterando.curso.salva.curso')}" />" type="button"/>
	</security:containsPermission>

	<security:containsPermission name="mantem.curso.uc.alterando.curso.voltar">
		<input id="mantemCursoUCAlterandoCursoVoltarForm" class="btn btn-primary" name="mantemCursoUCAlterandoCursoVoltarForm" value="<s:property value="%{getText('mantem.curso.uc.alterando.curso.voltar')}" />" type="button"/>
	</security:containsPermission>

</div>
<br class="clr"/>
