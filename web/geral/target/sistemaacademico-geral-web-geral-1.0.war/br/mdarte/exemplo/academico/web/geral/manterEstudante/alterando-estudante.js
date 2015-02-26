function getPath() {
	return "/sistemaacademico/geral";
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
		matricula: {
		},
		nome: {
		},
		idEstudante: {
			integer: true
		}
	},
	messages: {
		matricula: {
		},
		nome: {
		},
		idEstudante: {
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

	//Javascript do field matricula
	$("input#matriculaMantemEstudanteUC").mouseover(function(){hints.show("mantem.estudante.uc.alterando.estudante.salva.estudante.param.matricula.hint.key","salvaEstudanteMatricula$rowIndex") });
	$("input#matriculaMantemEstudanteUC").mouseout(function(){hints.hide()});
	$("input#matriculaMantemEstudanteUC").keyup(function(){verifica() });
	$("input#matriculaMantemEstudanteUC").keypress(function(){verifica(); });
	$("input#matriculaMantemEstudanteUC").mouseup(function(event){keySubmit(event); });


	//Javascript do field nome
	$("input#nomeMantemEstudanteUC").mouseover(function(){hints.show("mantem.estudante.uc.alterando.estudante.salva.estudante.param.nome.hint.key","salvaEstudanteNome$rowIndex") });
	$("input#nomeMantemEstudanteUC").mouseout(function(){hints.hide()});
	$("input#nomeMantemEstudanteUC").keyup(function(){verifica() });
	$("input#nomeMantemEstudanteUC").keypress(function(){verifica(); });
	$("input#nomeMantemEstudanteUC").mouseup(function(event){keySubmit(event); });


	//Javascript do field idEstudante
	$("input#idEstudanteMantemEstudanteUC").mouseover(function(){hints.show("mantem.estudante.uc.alterando.estudante.salva.estudante.param.id.estudante.hint.key","salvaEstudanteIdEstudante$rowIndex") });
	$("input#idEstudanteMantemEstudanteUC").mouseout(function(){hints.hide()});
	$("input#idEstudanteMantemEstudanteUC").keyup(function(){verifica() });
	$("input#idEstudanteMantemEstudanteUC").keypress(function(){verifica(); });
	$("input#idEstudanteMantemEstudanteUC").mouseup(function(event){keySubmit(event); });


//JavaScript dos botoes de acao
	$("input#mantemEstudanteUCAlterandoEstudanteSalvaEstudanteForm").mouseover(function(){hints.show('salvaEstudante'); }); 
	$("input#mantemEstudanteUCAlterandoEstudanteSalvaEstudanteForm").mouseout(function(){hints.hide(); });
	$("input#mantemEstudanteUCAlterandoEstudanteSalvaEstudanteForm").click(function(){if($("form").valid()) setaAcaoStruts2('/MantemEstudanteUC/AlterandoEstudanteSalvaEstudante' , 'mantemEstudanteUCAlterandoEstudanteSalvaEstudanteForm','.action' ); });
	$("input#mantemEstudanteUCAlterandoEstudanteVoltarForm").mouseover(function(){hints.show('voltar'); }); 
	$("input#mantemEstudanteUCAlterandoEstudanteVoltarForm").mouseout(function(){hints.hide(); });
	$("input#mantemEstudanteUCAlterandoEstudanteVoltarForm").click(function(){ setaAcaoStruts2('/MantemEstudanteUC/AlterandoEstudanteVoltar' , 'mantemEstudanteUCAlterandoEstudanteVoltarForm','.action' ); });

});
//Fim Javascript dos fields
