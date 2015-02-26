	<%@ include file="/br/mdarte/exemplo/academico/web/geral/detalharEstudante/detalhando-estudante-edita-estudante-hidden-params.jspf" %>
<div id="fields">
	<security:containsPermission name="detalha.estudante.uc.detalhando.estudante.voltar.param.matricula">
			<s:set name="__value" value="#session.form.matricula"/>
			<div id="divmatriculaDetalhaEstudanteUC" class="exibir form-group">
				<label class="control-label col-sm-2"><bean:message key="detalha.estudante.uc.detalhando.estudante.voltar.param.matricula"/></label>
				<div class="col-xs-4">
					<p id="matriculaDetalhaEstudanteUC" class="form-control-static"><s:property value="%{getText(#session.form.matricula)}" /></p>
				</div>
			</div>
	</security:containsPermission>
	<security:containsPermission name="detalha.estudante.uc.detalhando.estudante.voltar.param.nome">
			<s:set name="__value" value="#session.form.nome"/>
			<div id="divnomeDetalhaEstudanteUC" class="exibir form-group">
				<label class="control-label col-sm-2"><bean:message key="detalha.estudante.uc.detalhando.estudante.voltar.param.nome"/></label>
				<div class="col-xs-4">
					<p id="nomeDetalhaEstudanteUC" class="form-control-static"><s:property value="%{getText(#session.form.nome)}" /></p>
				</div>
			</div>
	</security:containsPermission>
</div>
