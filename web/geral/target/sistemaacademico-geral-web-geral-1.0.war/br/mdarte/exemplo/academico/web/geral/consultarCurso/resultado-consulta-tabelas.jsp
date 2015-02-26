<%@ include file="/taglib-imports.jspf" %>

<div id="tabbable">
	<ul class="nav nav-tabs">
		<li class="active"><a href="#tab-cursos" data-toggle="tab"><bean:message key="consulta.curso.uc.resultado.consulta.param.cursos"/></a></li>
	</ul>
	<div class="tab-content">
		<div class="tab-pane active" id="tab-cursos">
  			<%@ include file="/br/mdarte/exemplo/academico/web/geral/consultarCurso/resultado-consulta-cursos.jspf" %>
  		</div>
	</div>
</div>
