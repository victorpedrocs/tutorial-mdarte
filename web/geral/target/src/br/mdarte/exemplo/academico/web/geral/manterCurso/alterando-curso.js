function getPath() {
	return "/sistemaacademico";
}

function setaLocation(nomeAcao, parameters){
	var action;
	parameters = typeof parameters !== 'undefined' ? parameters : '';
	
	if (nomeAcao.indexOf("/") == 0) {
		action=getPath() + nomeAcao + '.action' + parameters;
	}else{
		action=getPath() + '/' + nomeAcao + '.action' + parameters;
	}
		window.open(action, '', 'width=700,height=500,top=50,left=100,scrollbars=yes');
}

function apaga() {
	document.forms[0].reset();
	for (i=0;i<document.forms[0].elements.length;i++) {
		var strtype = document.forms[0].elements[i].type;

		if(strtype.match("select")=="select") {
			document.forms[0].elements[i].selectedIndex=0;
		}
		if (strtype == "text" || strtype == "password") {
			document.forms[0].elements[i].value="";
		}
		if (strtype == "radio" || strtype == "checkbox") {
			document.forms[0].elements[i].checked=false;
		}
	}
} 

function keySubmit(e){
}

<!--Operacao de Habilitar-->

function verificaHabilitados() {
}

<!--Operacao de Desabilitar-->

function verificaDesabilitados() {
}

<!--Operacao de tornar visivel-->

function verificaVisiveis() {
}

<!--Operacao de Esconder-->

function verificaEscondidos() {
}

function verifica() {
	verificaHabilitados();
	verificaDesabilitados();
	verificaEscondidos();
	verificaVisiveis();
}

$(document).ready(function(){			
	//$('textarea').elastic();
	//$('textarea').trigger('update');
});


function atualizaElementos(){
}



//Javascript de validaï¿½ï¿½o

$('form').validate({
	rules: {
		codigo: {
		},
		nome: {
		},
		idCurso: {
			integer: true
		}
	},
	messages: {
		codigo: {
		},
		nome: {
		},
		idCurso: {
			integer: VALID_KEYS['validate.integer']
		}
	},
	highlight: function(element) {
		$(element).closest('.form-group').addClass('has-error');
	},
	unhighlight: function(element) {
		$(element).closest('.form-group').removeClass('has-error');
	},
	onkeyup: function (element, event) {
	    if (event.which === 9 && this.elementValue(element) === "") {
	        return;
	    } else {
	        this.element(element);
	    }
	},
	errorElement: 'span',
	errorClass: 'help-block',
	errorPlacement: function(error, element) {
		if(element.parent('.input-group').length) {
			error.insertAfter(element.parent());
		} else {
			error.insertAfter(element.parent());
		}
	}
});

//Fim do Javascript de validaï¿½ï¿½o

$(document).ready(function(){

	atualizaElementos();

	//Botao Select/Deselect all
	$(".select-deselect").click(function(){
		selecionaDeseleciona();
	});
	
	//Botao Clean
	$(".clean-btn").click(function(){apaga() });
	
	//Botao Close
	$(".close-btn").click(function(){close() });


//Javascript dos fields

	//Javascript do field codigo
	$("input#codigoMantemCursoUC").mouseover(function(){hints.show("mantem.curso.uc.alterando.curso.salva.curso.param.codigo.hint.key","salvaCursoCodigo$rowIndex") });
	$("input#codigoMantemCursoUC").mouseout(function(){hints.hide()});
	$("input#codigoMantemCursoUC").keyup(function(){verifica() });
	$("input#codigoMantemCursoUC").keypress(function(){verifica(); });
	$("input#codigoMantemCursoUC").mouseup(function(event){keySubmit(event); });


	//Javascript do field nome
	$("input#nomeMantemCursoUC").mouseover(function(){hints.show("mantem.curso.uc.alterando.curso.salva.curso.param.nome.hint.key","salvaCursoNome$rowIndex") });
	$("input#nomeMantemCursoUC").mouseout(function(){hints.hide()});
	$("input#nomeMantemCursoUC").keyup(function(){verifica() });
	$("input#nomeMantemCursoUC").keypress(function(){verifica(); });
	$("input#nomeMantemCursoUC").mouseup(function(event){keySubmit(event); });


	//Javascript do field idCurso
	$("input#idCursoMantemCursoUC").mouseover(function(){hints.show("mantem.curso.uc.alterando.curso.salva.curso.param.id.curso.hint.key","salvaCursoIdCurso$rowIndex") });
	$("input#idCursoMantemCursoUC").mouseout(function(){hints.hide()});
	$("input#idCursoMantemCursoUC").keyup(function(){verifica() });
	$("input#idCursoMantemCursoUC").keypress(function(){verifica(); });
	$("input#idCursoMantemCursoUC").mouseup(function(event){keySubmit(event); });


//JavaScript dos botoes de acao
	$("input#mantemCursoUCAlterandoCursoSalvaCursoForm").mouseover(function(){hints.show('salvaCurso'); }); 
	$("input#mantemCursoUCAlterandoCursoSalvaCursoForm").mouseout(function(){hints.hide(); });
	$("input#mantemCursoUCAlterandoCursoSalvaCursoForm").click(function(){if($("form").valid()) setaAcaoStruts2('/MantemCursoUC/AlterandoCursoSalvaCurso' , 'mantemCursoUCAlterandoCursoSalvaCursoForm','.action' ); });
	$("input#mantemCursoUCAlterandoCursoVoltarForm").mouseover(function(){hints.show('voltar'); }); 
	$("input#mantemCursoUCAlterandoCursoVoltarForm").mouseout(function(){hints.hide(); });
	$("input#mantemCursoUCAlterandoCursoVoltarForm").click(function(){ setaAcaoStruts2('/MantemCursoUC/AlterandoCursoVoltar' , 'mantemCursoUCAlterandoCursoVoltarForm','.action' ); });

});
//Fim Javascript dos fields
