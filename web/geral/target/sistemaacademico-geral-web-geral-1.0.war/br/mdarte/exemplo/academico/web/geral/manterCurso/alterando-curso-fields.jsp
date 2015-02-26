	<%@ include file="/br/mdarte/exemplo/academico/web/geral/manterCurso/alterando-curso-salva-curso-hidden-params.jspf" %>
<div id="fields">
	<security:containsPermission name="mantem.curso.uc.alterando.curso.salva.curso.param.codigo">
			<s:set name="__value" value="#session.form.codigo"/>
			<div id="divcodigoMantemCursoUC" class="form-group textfield">
				<label class="control-label col-sm-2" for="codigo"><bean:message key="mantem.curso.uc.alterando.curso.salva.curso.param.codigo"/></label>
				<div class="col-xs-4">
					<s:textfield id="codigoMantemCursoUC"  cssClass="form-control" name="codigo" label="%{getText('mantem.curso.uc.alterando.curso.salva.curso.param.codigo')}" value="%{#session.form.codigo}"   title=""    styleId="salvaCursoCodigo"  />
				</div>
			</div>
	</security:containsPermission>
	<security:containsPermission name="mantem.curso.uc.alterando.curso.salva.curso.param.nome">
			<s:set name="__value" value="#session.form.nome"/>
			<div id="divnomeMantemCursoUC" class="form-group textfield">
				<label class="control-label col-sm-2" for="nome"><bean:message key="mantem.curso.uc.alterando.curso.salva.curso.param.nome"/></label>
				<div class="col-xs-4">
					<s:textfield id="nomeMantemCursoUC"  cssClass="form-control" name="nome" label="%{getText('mantem.curso.uc.alterando.curso.salva.curso.param.nome')}" value="%{#session.form.nome}"   title=""    styleId="salvaCursoNome"  />
				</div>
			</div>
	</security:containsPermission>
</div>
