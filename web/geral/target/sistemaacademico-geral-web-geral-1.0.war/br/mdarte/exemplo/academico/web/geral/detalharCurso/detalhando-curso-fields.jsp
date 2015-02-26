	<%@ include file="/br/mdarte/exemplo/academico/web/geral/detalharCurso/detalhando-curso-edita-curso-hidden-params.jspf" %>
<div id="fields">
	<security:containsPermission name="detalha.curso.uc.detalhando.curso.voltar.param.codigo">
			<s:set name="__value" value="#session.form.codigo"/>
			<div id="divcodigoDetalhaCursoUC" class="exibir form-group">
				<label class="control-label col-sm-2"><bean:message key="detalha.curso.uc.detalhando.curso.voltar.param.codigo"/></label>
				<div class="col-xs-4">
					<p id="codigoDetalhaCursoUC" class="form-control-static"><s:property value="%{getText(#session.form.codigo)}" /></p>
				</div>
			</div>
	</security:containsPermission>
	<security:containsPermission name="detalha.curso.uc.detalhando.curso.voltar.param.nome">
			<s:set name="__value" value="#session.form.nome"/>
			<div id="divnomeDetalhaCursoUC" class="exibir form-group">
				<label class="control-label col-sm-2"><bean:message key="detalha.curso.uc.detalhando.curso.voltar.param.nome"/></label>
				<div class="col-xs-4">
					<p id="nomeDetalhaCursoUC" class="form-control-static"><s:property value="%{getText(#session.form.nome)}" /></p>
				</div>
			</div>
	</security:containsPermission>
</div>
