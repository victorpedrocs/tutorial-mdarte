<div id="fields">
	<security:containsPermission name="consulta.estudante.uc.preencha.campos.consulta.estudante.param.matricula">
			<s:set name="__value" value="#session.form.matricula"/>
			<div id="divmatriculaConsultaEstudanteUC" class="form-group autocomplete">
				<label class="control-label col-sm-2" for="matricula"><bean:message key="consulta.estudante.uc.preencha.campos.consulta.estudante.param.matricula"/></label>
				<div class="col-xs-4">
					<s:textfield id="matriculaConsultaEstudanteUC"  name="matricula" cssClass="form-control" label="%{getText('consulta.estudante.uc.preencha.campos.consulta.estudante.param.matricula')}"  value="%{#session.form.matricula}"   title=""    styleId="consultaEstudanteMatricula"  />
				</div>
			</div>
	</security:containsPermission>
	<security:containsPermission name="consulta.estudante.uc.preencha.campos.consulta.estudante.param.nome">
			<s:set name="__value" value="#session.form.nome"/>
			<div id="divnomeConsultaEstudanteUC" class="form-group textfield">
				<label class="control-label col-sm-2" for="nome"><bean:message key="consulta.estudante.uc.preencha.campos.consulta.estudante.param.nome"/></label>
				<div class="col-xs-4">
					<s:textfield id="nomeConsultaEstudanteUC"  cssClass="form-control" name="nome" label="%{getText('consulta.estudante.uc.preencha.campos.consulta.estudante.param.nome')}" value="%{#session.form.nome}"   title=""    styleId="consultaEstudanteNome"  />
				</div>
			</div>
	</security:containsPermission>
	<security:containsPermission name="consulta.estudante.uc.preencha.campos.consulta.estudante.param.cpf">
			<s:set name="__value" value="#session.form.cpf"/>
			<div id="divcpfConsultaEstudanteUC" class="custom form-group">
				<%@ include file="cpf.jsp"  %>
			</div>
	</security:containsPermission>
</div>
