
package br.mdarte.exemplo.academico.web.geral.consultarEstudante;

import basic.BasicViewTestController;

public class ConsultaEstudanteUCViewTest {
	private BasicViewTestController viewTestController;

	private java.lang.String matricula = null;
	
	private java.lang.String nome = null;
	
	private java.lang.String idEstudante = null;
	

	public ConsultaEstudanteUCViewTest(BasicViewTestController viewTestController) {
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
		this.viewTestController.open("/sistemaacademico/ConsultaEstudanteUC/ConsultaEstudanteUC.do");
	}

	/**
	 * Opens the URL of the use case from the principal module.
	 */
	public void openUseCaseFromPrincipalModule() {
		this.viewTestController.open("/sistemaacademico/ForwardAction.do?modulo=&path=/ConsultaEstudanteUC/ConsultaEstudanteUC.do");
	}

	/**
	 * consultaEstudante
	 * Action number 1.
	 *
	 * matricula Text or Password.
	 * nome Text or Password.
	 */
	public void action1_consultaEstudante() {
		if (matricula != null) {
			viewTestController.type("//input[@id='consultaEstudanteMatricula']", matricula);
		}

		if (nome != null) {
			viewTestController.type("//input[@id='consultaEstudanteNome']", nome);
		}

		/* Action Path: /ConsultaEstudanteUC/PreenchaCamposConsultaEstudante */
		/* viewTestController.click("//input[@id='form_submit' "); */
		/* viewTestController.click("//input[@value='consultaEstudante']"); */
		viewTestController.click("//input[@name='consultaEstudanteUCPreenchaCamposConsultaEstudanteForm']");

		viewTestController.waitForPageToLoad("30000");
	}

	public void open_action1_consultaEstudante() {
		this.viewTestController.open("/sistemaacademico/ConsultaEstudanteUC/PreenchaCamposConsultaEstudante.do");
	}


	/**
	 * novaConsulta
	 * Action number 2.
	 *
	 */
	public void action2_novaConsulta() {
		/* Action Path: /ConsultaEstudanteUC/ResultadoConsultaNovaConsulta */
		/* viewTestController.click("//input[@id='form_submit' "); */
		/* viewTestController.click("//input[@value='novaConsulta']"); */
		viewTestController.click("//input[@name='consultaEstudanteUCResultadoConsultaNovaConsultaForm']");

		viewTestController.waitForPageToLoad("30000");
	}

	public void open_action2_novaConsulta() {
		this.viewTestController.open("/sistemaacademico/ConsultaEstudanteUC/ResultadoConsultaNovaConsulta.do");
	}

	/**
	 * detalhaEstudante
	 * Action number 3.
	 *
	 */
	public void action3_detalhaEstudante() {
		/* Action Path: /ConsultaEstudanteUC/ResultadoConsultaDetalhaEstudante */
		/* viewTestController.click("//input[@id='form_submit' "); */
		/* viewTestController.click("//input[@value='detalhaEstudante']"); */
		viewTestController.click("//input[@name='consultaEstudanteUCResultadoConsultaDetalhaEstudanteForm']");

		viewTestController.waitForPageToLoad("30000");
	}

	public void open_action3_detalhaEstudante() {
		this.viewTestController.open("/sistemaacademico/ConsultaEstudanteUC/ResultadoConsultaDetalhaEstudante.do");
	}


	/* TABLE: Estudantes */

	/**
	 * Returns the value of the column 'Matricula'
	 * for a specific <code>row</code>.
	 *
	 * @param The row which the value is retrieved.
	 * @return The value of the column 'Matricula'.
	 */
	public String getEstudantesMatricula(int row) {
		return viewTestController.getText("//table[@id='row']/tbody/tr[" + row + "]/td[1]/div");
	}

	/**
	 * Returns the value of the column 'Nome'
	 * for a specific <code>row</code>.
	 *
	 * @param The row which the value is retrieved.
	 * @return The value of the column 'Nome'.
	 */
	public String getEstudantesNome(int row) {
		return viewTestController.getText("//table[@id='row']/tbody/tr[" + row + "]/td[2]/div");
	}

	/**
	 * @return The number of elements of the table's first page.
	 */
	public int getEstudantes() {
		return viewTestController.getXpathCount("//table[@id='row']/tbody/tr").intValue();
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
