
package br.mdarte.exemplo.academico.web.geral.manterEstudante;

import basic.BasicViewTestController;

public class MantemEstudanteUCViewTest {
	private BasicViewTestController viewTestController;

	private java.lang.String matricula = null;
	
	private java.lang.String nome = null;
	
	private java.lang.String idEstudante = null;
	

	public MantemEstudanteUCViewTest(BasicViewTestController viewTestController) {
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
		this.viewTestController.open("/sistemaacademico/MantemEstudanteUC/MantemEstudanteUC.do");
	}

	/**
	 * Opens the URL of the use case from the principal module.
	 */
	public void openUseCaseFromPrincipalModule() {
		this.viewTestController.open("/sistemaacademico/ForwardAction.do?modulo=&path=/MantemEstudanteUC/MantemEstudanteUC.do");
	}

	/**
	 * salvaEstudante
	 * Action number 1.
	 *
	 * matricula Text or Password.
	 * nome Text or Password.
	 */
	public void action1_salvaEstudante() {
		if (matricula != null) {
			viewTestController.type("//input[@id='salvaEstudanteMatricula']", matricula);
		}

		if (nome != null) {
			viewTestController.type("//input[@id='salvaEstudanteNome']", nome);
		}

		/* Action Path: /MantemEstudanteUC/AlterandoEstudanteSalvaEstudante */
		/* viewTestController.click("//input[@id='form_submit' "); */
		/* viewTestController.click("//input[@value='salvaEstudante']"); */
		viewTestController.click("//input[@name='mantemEstudanteUCAlterandoEstudanteSalvaEstudanteForm']");

		viewTestController.waitForPageToLoad("30000");
	}

	public void open_action1_salvaEstudante() {
		this.viewTestController.open("/sistemaacademico/MantemEstudanteUC/AlterandoEstudanteSalvaEstudante.do");
	}

	/**
	 * voltar
	 * Action number 2.
	 *
	 */
	public void action2_voltar() {
		/* Action Path: /MantemEstudanteUC/AlterandoEstudanteVoltar */
		/* viewTestController.click("//input[@id='form_submit' "); */
		/* viewTestController.click("//input[@value='voltar']"); */
		viewTestController.click("//input[@name='mantemEstudanteUCAlterandoEstudanteVoltarForm']");

		viewTestController.waitForPageToLoad("30000");
	}

	public void open_action2_voltar() {
		this.viewTestController.open("/sistemaacademico/MantemEstudanteUC/AlterandoEstudanteVoltar.do");
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
