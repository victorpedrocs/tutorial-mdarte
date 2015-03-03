
package br.mdarte.exemplo.academico.web.geral.detalharEstudante;

import basic.BasicViewTestController;

public class DetalhaEstudanteUCViewTest {
	private BasicViewTestController viewTestController;

	private java.lang.String matricula = null;
	
	private java.lang.String nome = null;
	
	private java.lang.String idEstudante = null;
	

	public DetalhaEstudanteUCViewTest(BasicViewTestController viewTestController) {
		this.viewTestController = viewTestController;
	}

	/**
	 * @return The BasicViewTestController.
	 */
	public BasicViewTestController getViewTestController() {
		return viewTestController;
	}

	/**
	 * Opens the URL of the use case from the current module.
	 */
	public void openUseCase() {
		this.viewTestController.open("/sistemaacademico/DetalhaEstudanteUC/DetalhaEstudanteUC.do");
	}

	/**
	 * Opens the URL of the use case from the principal module.
	 */
	public void openUseCaseFromPrincipalModule() {
		this.viewTestController.open("/sistemaacademico/ForwardAction.do?modulo=&path=/DetalhaEstudanteUC/DetalhaEstudanteUC.do");
	}

	/**
	 * voltar
	 * Action number 1.
	 *
	 */
	public void action1_voltar() {
		/* Action Path: /DetalhaEstudanteUC/DetalhandoEstudanteVoltar */
		/* viewTestController.click("//input[@id='form_submit' "); */
		/* viewTestController.click("//input[@value='voltar']"); */
		viewTestController.click("//input[@name='detalhaEstudanteUCDetalhandoEstudanteVoltarForm']");

		viewTestController.waitForPageToLoad("30000");
	}

	public void open_action1_voltar() {
		this.viewTestController.open("/sistemaacademico/DetalhaEstudanteUC/DetalhandoEstudanteVoltar.do");
	}

	/**
	 * editaEstudante
	 * Action number 2.
	 *
	 */
	public void action2_editaEstudante() {
		/* Action Path: /DetalhaEstudanteUC/DetalhandoEstudanteEditaEstudante */
		/* viewTestController.click("//input[@id='form_submit' "); */
		/* viewTestController.click("//input[@value='editaEstudante']"); */
		viewTestController.click("//input[@name='detalhaEstudanteUCDetalhandoEstudanteEditaEstudanteForm']");

		viewTestController.waitForPageToLoad("30000");
	}

	public void open_action2_editaEstudante() {
		this.viewTestController.open("/sistemaacademico/DetalhaEstudanteUC/DetalhandoEstudanteEditaEstudante.do");
	}



	/* PARAMETERS */

	public java.lang.String getMatricula() {
		return matricula;
	}

	public void setMatricula(java.lang.String matricula) {
		this.matricula = matricula;
	}

	public java.lang.String getNome() {
		return nome;
	}

	public void setNome(java.lang.String nome) {
		this.nome = nome;
	}

	public java.lang.String getIdEstudante() {
		return idEstudante;
	}

	public void setIdEstudante(java.lang.String idEstudante) {
		this.idEstudante = idEstudante;
	}

	/**
	 * Clear all parameters.
	 */
	public void clearAll() {
		this.matricula = null;

		this.nome = null;

		this.idEstudante = null;


	}
}
