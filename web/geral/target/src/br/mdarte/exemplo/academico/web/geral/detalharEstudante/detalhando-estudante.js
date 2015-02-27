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
		idEstudante: {
			integer: true
		},
	},
	messages: {
		idEstudante: {
			integer: VALID_KEYS['validate.integer']
		},
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

	//Javascript do field matricula
	$("input#matriculaDetalhaEstudanteUC").mouseover(function(){hints.show("detalha.estudante.uc.detalhando.estudante.voltar.param.matricula.hint.key","voltarMatricula$rowIndex") });
	$("input#matriculaDetalhaEstudanteUC").mouseout(function(){hints.hide()});

	//Javascript do field nome
	$("input#nomeDetalhaEstudanteUC").mouseover(function(){hints.show("detalha.estudante.uc.detalhando.estudante.voltar.param.nome.hint.key","voltarNome$rowIndex") });
	$("input#nomeDetalhaEstudanteUC").mouseout(function(){hints.hide()});

	//Javascript do field idEstudante
	$("input#idEstudanteDetalhaEstudanteUC").mouseover(function(){hints.show("detalha.estudante.uc.detalhando.estudante.edita.estudante.param.id.estudante.hint.key","editaEstudanteIdEstudante$rowIndex") });
	$("input#idEstudanteDetalhaEstudanteUC").mouseout(function(){hints.hide()});
	$("input#idEstudanteDetalhaEstudanteUC").keyup(function(){verifica() });
	$("input#idEstudanteDetalhaEstudanteUC").keypress(function(){verifica(); });
	$("input#idEstudanteDetalhaEstudanteUC").mouseup(function(event){keySubmit(event); });


//JavaScript dos botoes de acao
	$("input#detalhaEstudanteUCDetalhandoEstudanteVoltarForm").mouseover(function(){hints.show('voltar'); }); 
	$("input#detalhaEstudanteUCDetalhandoEstudanteVoltarForm").mouseout(function(){hints.hide(); });
	$("input#detalhaEstudanteUCDetalhandoEstudanteVoltarForm").click(function(){ setaAcaoStruts2('/DetalhaEstudanteUC/DetalhandoEstudanteVoltar' , 'detalhaEstudanteUCDetalhandoEstudanteVoltarForm','.action' ); });
	$("input#detalhaEstudanteUCDetalhandoEstudanteEditaEstudanteForm").mouseover(function(){hints.show('editaEstudante'); }); 
	$("input#detalhaEstudanteUCDetalhandoEstudanteEditaEstudanteForm").mouseout(function(){hints.hide(); });
	$("input#detalhaEstudanteUCDetalhandoEstudanteEditaEstudanteForm").click(function(){if($("form").valid()) setaAcaoStruts2('/DetalhaEstudanteUC/DetalhandoEstudanteEditaEstudante' , 'detalhaEstudanteUCDetalhandoEstudanteEditaEstudanteForm','.action' ); });

});
//Fim Javascript dos fields
