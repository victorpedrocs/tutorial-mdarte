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
		idCurso: {
			integer: true
		},
	},
	messages: {
		idCurso: {
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

	//Javascript do field codigo
	$("input#codigoDetalhaCursoUC").mouseover(function(){hints.show("detalha.curso.uc.detalhando.curso.voltar.param.codigo.hint.key","voltarCodigo$rowIndex") });
	$("input#codigoDetalhaCursoUC").mouseout(function(){hints.hide()});

	//Javascript do field nome
	$("input#nomeDetalhaCursoUC").mouseover(function(){hints.show("detalha.curso.uc.detalhando.curso.voltar.param.nome.hint.key","voltarNome$rowIndex") });
	$("input#nomeDetalhaCursoUC").mouseout(function(){hints.hide()});

	//Javascript do field idCurso
	$("input#idCursoDetalhaCursoUC").mouseover(function(){hints.show("detalha.curso.uc.detalhando.curso.edita.curso.param.id.curso.hint.key","editaCursoIdCurso$rowIndex") });
	$("input#idCursoDetalhaCursoUC").mouseout(function(){hints.hide()});
	$("input#idCursoDetalhaCursoUC").keyup(function(){verifica() });
	$("input#idCursoDetalhaCursoUC").keypress(function(){verifica(); });
	$("input#idCursoDetalhaCursoUC").mouseup(function(event){keySubmit(event); });


//JavaScript dos botoes de acao
	$("input#detalhaCursoUCDetalhandoCursoVoltarForm").mouseover(function(){hints.show('voltar'); }); 
	$("input#detalhaCursoUCDetalhandoCursoVoltarForm").mouseout(function(){hints.hide(); });
	$("input#detalhaCursoUCDetalhandoCursoVoltarForm").click(function(){ setaAcaoStruts2('/DetalhaCursoUC/DetalhandoCursoVoltar' , 'detalhaCursoUCDetalhandoCursoVoltarForm','.action' ); });
	$("input#detalhaCursoUCDetalhandoCursoEditaCursoForm").mouseover(function(){hints.show('editaCurso'); }); 
	$("input#detalhaCursoUCDetalhandoCursoEditaCursoForm").mouseout(function(){hints.hide(); });
	$("input#detalhaCursoUCDetalhandoCursoEditaCursoForm").click(function(){if($("form").valid()) setaAcaoStruts2('/DetalhaCursoUC/DetalhandoCursoEditaCurso' , 'detalhaCursoUCDetalhandoCursoEditaCursoForm','.action' ); });

});
//Fim Javascript dos fields
