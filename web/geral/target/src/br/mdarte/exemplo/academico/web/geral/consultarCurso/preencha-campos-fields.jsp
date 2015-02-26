<div id="fields">
	<security:containsPermission name="consulta.curso.uc.preencha.campos.consulta.curso.param.codigo">
			<s:set name="__value" value="#session.form.codigo"/>
			<div id="divcodigoConsultaCursoUC" class="form-group textfield">
				<label class="control-label col-sm-2" for="codigo"><bean:message key="consulta.curso.uc.preencha.campos.consulta.curso.param.codigo"/></label>
				<div class="col-xs-4">
					<s:textfield id="codigoConsultaCursoUC"  cssClass="form-control" name="codigo" label="%{getText('consulta.curso.uc.preencha.campos.consulta.curso.param.codigo')}" value="%{#session.form.codigo}"   title=""    styleId="consultaCursoCodigo"  />
				</div>
			</div>
	</security:containsPermission>
	<security:containsPermission name="consulta.curso.uc.preencha.campos.consulta.curso.param.nome">
			<s:set name="__value" value="#session.form.nome"/>
			<div id="divnomeConsultaCursoUC" class="form-group textfield">
				<label class="control-label col-sm-2" for="nome"><bean:message key="consulta.curso.uc.preencha.campos.consulta.curso.param.nome"/></label>
				<div class="col-xs-4">
					<s:textfield id="nomeConsultaCursoUC"  cssClass="form-control" name="nome" label="%{getText('consulta.curso.uc.preencha.campos.consulta.curso.param.nome')}" value="%{#session.form.nome}"   title=""    styleId="consultaCursoNome"  />
				</div>
			</div>
	</security:containsPermission>
</div>
