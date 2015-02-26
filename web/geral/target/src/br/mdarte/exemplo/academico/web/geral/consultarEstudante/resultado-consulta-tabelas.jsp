<%@ include file="/taglib-imports.jspf" %>

<div id="tabbable">
	<ul class="nav nav-tabs">
		<li class="active"><a href="#tab-estudantes" data-toggle="tab"><bean:message key="consulta.estudante.uc.resultado.consulta.param.estudantes"/></a></li>
	</ul>
	<div class="tab-content">
		<div class="tab-pane active" id="tab-estudantes">
  			<%@ include file="/br/mdarte/exemplo/academico/web/geral/consultarEstudante/resultado-consulta-estudantes.jspf" %>
  		</div>
	</div>
</div>
