	<%@ include file="/br/mdarte/exemplo/academico/web/geral/manterEstudante/alterando-estudante-salva-estudante-hidden-params.jspf" %>
<div id="fields">
	<security:containsPermission name="mantem.estudante.uc.alterando.estudante.salva.estudante.param.matricula">
			<s:set name="__value" value="#session.form.matricula"/>
			<div id="divmatriculaMantemEstudanteUC" class="form-group textfield">
				<label class="control-label col-sm-2" for="matricula"><bean:message key="mantem.estudante.uc.alterando.estudante.salva.estudante.param.matricula"/></label>
				<div class="col-xs-4">
					<s:textfield id="matriculaMantemEstudanteUC"  cssClass="form-control" name="matricula" label="%{getText('mantem.estudante.uc.alterando.estudante.salva.estudante.param.matricula')}" value="%{#session.form.matricula}"   title=""    styleId="salvaEstudanteMatricula"  />
				</div>
			</div>
	</security:containsPermission>
	<security:containsPermission name="mantem.estudante.uc.alterando.estudante.salva.estudante.param.nome">
			<s:set name="__value" value="#session.form.nome"/>
			<div id="divnomeMantemEstudanteUC" class="form-group textfield">
				<label class="control-label col-sm-2" for="nome"><bean:message key="mantem.estudante.uc.alterando.estudante.salva.estudante.param.nome"/></label>
				<div class="col-xs-4">
					<s:textfield id="nomeMantemEstudanteUC"  cssClass="form-control" name="nome" label="%{getText('mantem.estudante.uc.alterando.estudante.salva.estudante.param.nome')}" value="%{#session.form.nome}"   title=""    styleId="salvaEstudanteNome"  />
				</div>
			</div>
	</security:containsPermission>
</div>
