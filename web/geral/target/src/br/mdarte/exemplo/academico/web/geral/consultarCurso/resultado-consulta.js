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


function setaParametroscursos(param1, param2) {
	document.cursos.action = "";
	document.cursos.action = getPath() + '/' + param2 + '.do';
	document.cursos.name=param1;						   
	document.cursos.submit(); 
	return true;
}


//Javascript de validaï¿½ï¿½o

$('form').validate({
	rules: {
	},
	messages: {
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

//Javascript da tabela cursos
	//$table.tableType 	
	//Table Global Actions tabela cursos
	
	//Fim Table Global Actions tabela cursos

	//Table Form Actions tabela cursos
	// Fim Table Form Actions tabela cursos
	
	//Table Look up Grid actions tabela cursos
	// Fim Table Look up Grid actions tabela cursos

	//Table Column Actions tabela cursos
	//Fim Table Column Actions tabela cursos
//Fim do Javascript da tabela cursos

//Javascript dos fields

//JavaScript dos botoes de acao
	$("input#consultaCursoUCResultadoConsultaNovaConsultaForm").mouseover(function(){hints.show('novaConsulta'); }); 
	$("input#consultaCursoUCResultadoConsultaNovaConsultaForm").mouseout(function(){hints.hide(); });
	$("input#consultaCursoUCResultadoConsultaNovaConsultaForm").click(function(){ setaAcaoStruts2('/ConsultaCursoUC/ResultadoConsultaNovaConsulta' , 'consultaCursoUCResultadoConsultaNovaConsultaForm','.action' ); });


});
//Fim Javascript dos fields
