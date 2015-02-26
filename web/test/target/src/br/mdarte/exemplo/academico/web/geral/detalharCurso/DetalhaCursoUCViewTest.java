
package br.mdarte.exemplo.academico.web.geral.detalharCurso;

import basic.BasicViewTestController;

public class DetalhaCursoUCViewTest {
	private BasicViewTestController viewTestController;

	private java.lang.String idCurso = null;
	
	private java.lang.String codigo = null;
	
	private java.lang.String nome = null;
	

	public DetalhaCursoUCViewTest(BasicViewTestController viewTestController) {
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
		this.viewTestController.open("/sistemaacademico/geral/DetalhaCursoUC/DetalhaCursoUC.do");
	}

	/**
	 * Opens the URL of the use case from the principal module.
	 */
	public void openUseCaseFromPrincipalModule() {
		this.viewTestController.open("/sistemaacademico/ForwardAction.do?modulo=&path=/geral/DetalhaCursoUC/DetalhaCursoUC.do");
	}

	/**
	 * voltar
	 * Action number 1.
	 *
	 */
	public void action1_voltar() {
		/* Action Path: /DetalhaCursoUC/DetalhandoCursoVoltar */
		/* viewTestController.click("//input[@id='form_submit' "); */
		/* viewTestController.click("//input[@value='voltar']"); */
		viewTestController.click("//input[@name='detalhaCursoUCDetalhandoCursoVoltarForm']");

		viewTestController.waitForPageToLoad("30000");
	}

	public void open_action1_voltar() {
		this.viewTestController.open("/sistemaacademico/geral/DetalhaCursoUC/DetalhandoCursoVoltar.do");
	}

	/**
	 * editaCurso
	 * Action number 2.
	 *
	 */
	public void action2_editaCurso() {
		/* Action Path: /DetalhaCursoUC/DetalhandoCursoEditaCurso */
		/* viewTestController.click("//input[@id='form_submit' "); */
		/* viewTestController.click("//input[@value='editaCurso']"); */
		viewTestController.click("//input[@name='detalhaCursoUCDetalhandoCursoEditaCursoForm']");

		viewTestController.waitForPageToLoad("30000");
	}

	public void open_action2_editaCurso() {
		this.viewTestController.open("/sistemaacademico/geral/DetalhaCursoUC/DetalhandoCursoEditaCurso.do");
	}



	/* PARAMETERS */

	public java.lang.String getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(java.lang.String idCurso) {
		this.idCurso = idCurso;
	}

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

	/**
	 * Clear all parameters.
	 */
	public void clearAll() {
		this.idCurso = null;

		this.codigo = null;

		this.nome = null;


	}
}
