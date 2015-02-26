
package br.mdarte.exemplo.academico.web.geral.consultarCurso;

import basic.BasicViewTestController;

public class ConsultaCursoUCViewTest {
	private BasicViewTestController viewTestController;

	private java.lang.String codigo = null;
	
	private java.lang.String nome = null;
	
	private java.lang.String idCurso = null;
	

	public ConsultaCursoUCViewTest(BasicViewTestController viewTestController) {
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
		this.viewTestController.open("/sistemaacademico/geral/ConsultaCursoUC/ConsultaCursoUC.do");
	}

	/**
	 * Opens the URL of the use case from the principal module.
	 */
	public void openUseCaseFromPrincipalModule() {
		this.viewTestController.open("/sistemaacademico/ForwardAction.do?modulo=&path=/geral/ConsultaCursoUC/ConsultaCursoUC.do");
	}

	/**
	 * consultaCurso
	 * Action number 1.
	 *
	 * codigo Text or Password.
	 * nome Text or Password.
	 */
	public void action1_consultaCurso() {
		if (codigo != null) {
			viewTestController.type("//input[@id='consultaCursoCodigo']", codigo);
		}

		if (nome != null) {
			viewTestController.type("//input[@id='consultaCursoNome']", nome);
		}

		/* Action Path: /ConsultaCursoUC/PreenchaCamposConsultaCurso */
		/* viewTestController.click("//input[@id='form_submit' "); */
		/* viewTestController.click("//input[@value='consultaCurso']"); */
		viewTestController.click("//input[@name='consultaCursoUCPreenchaCamposConsultaCursoForm']");

		viewTestController.waitForPageToLoad("30000");
	}

	public void open_action1_consultaCurso() {
		this.viewTestController.open("/sistemaacademico/geral/ConsultaCursoUC/PreenchaCamposConsultaCurso.do");
	}


	/**
	 * novaConsulta
	 * Action number 2.
	 *
	 */
	public void action2_novaConsulta() {
		/* Action Path: /ConsultaCursoUC/ResultadoConsultaNovaConsulta */
		/* viewTestController.click("//input[@id='form_submit' "); */
		/* viewTestController.click("//input[@value='novaConsulta']"); */
		viewTestController.click("//input[@name='consultaCursoUCResultadoConsultaNovaConsultaForm']");

		viewTestController.waitForPageToLoad("30000");
	}

	public void open_action2_novaConsulta() {
		this.viewTestController.open("/sistemaacademico/geral/ConsultaCursoUC/ResultadoConsultaNovaConsulta.do");
	}

	/**
	 * detalhaCurso
	 * Action number 3.
	 *
	 */
	public void action3_detalhaCurso() {
		/* Action Path: /ConsultaCursoUC/ResultadoConsultaDetalhaCurso */
		/* viewTestController.click("//input[@id='form_submit' "); */
		/* viewTestController.click("//input[@value='detalhaCurso']"); */
		viewTestController.click("//input[@name='consultaCursoUCResultadoConsultaDetalhaCursoForm']");

		viewTestController.waitForPageToLoad("30000");
	}

	public void open_action3_detalhaCurso() {
		this.viewTestController.open("/sistemaacademico/geral/ConsultaCursoUC/ResultadoConsultaDetalhaCurso.do");
	}


	/* TABLE: Cursos */

	/**
	 * Returns the value of the column 'Codigo'
	 * for a specific <code>row</code>.
	 *
	 * @param The row which the value is retrieved.
	 * @return The value of the column 'Codigo'.
	 */
	public String getCursosCodigo(int row) {
		return viewTestController.getText("//table[@id='row']/tbody/tr[" + row + "]/td[1]/div");
	}

	/**
	 * Returns the value of the column 'Nome'
	 * for a specific <code>row</code>.
	 *
	 * @param The row which the value is retrieved.
	 * @return The value of the column 'Nome'.
	 */
	public String getCursosNome(int row) {
		return viewTestController.getText("//table[@id='row']/tbody/tr[" + row + "]/td[2]/div");
	}

	/**
	 * @return The number of elements of the table's first page.
	 */
	public int getCursos() {
		return viewTestController.getXpathCount("//table[@id='row']/tbody/tr").intValue();
	}



	/* PARAMETERS */

	public java.lang.String getCodigo() {
		return codigo;
	}

	public void setCodigo(java.lang.String codigo) {
		this.codigo = codigo;
	}

	public java.lang.String getNome() {
		return nome;
	}

	public void setNome(java.lang.String nome) {
		this.nome = nome;
	}

	public java.lang.String getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(java.lang.String idCurso) {
		this.idCurso = idCurso;
	}

	/**
	 * Clear all parameters.
	 */
	public void clearAll() {
		this.codigo = null;

		this.nome = null;

		this.idCurso = null;


	}
}
