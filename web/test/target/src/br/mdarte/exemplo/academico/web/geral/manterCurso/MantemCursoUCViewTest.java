
package br.mdarte.exemplo.academico.web.geral.manterCurso;

import basic.BasicViewTestController;

public class MantemCursoUCViewTest {
	private BasicViewTestController viewTestController;

	private java.lang.String codigo = null;
	
	private java.lang.String nome = null;
	
	private java.lang.String idCurso = null;
	

	public MantemCursoUCViewTest(BasicViewTestController viewTestController) {
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
		this.viewTestController.open("/sistemaacademico/geral/MantemCursoUC/MantemCursoUC.do");
	}

	/**
	 * Opens the URL of the use case from the principal module.
	 */
	public void openUseCaseFromPrincipalModule() {
		this.viewTestController.open("/sistemaacademico/ForwardAction.do?modulo=&path=/geral/MantemCursoUC/MantemCursoUC.do");
	}

	/**
	 * salvaCurso
	 * Action number 1.
	 *
	 * codigo Text or Password.
	 * nome Text or Password.
	 */
	public void action1_salvaCurso() {
		if (codigo != null) {
			viewTestController.type("//input[@id='salvaCursoCodigo']", codigo);
		}

		if (nome != null) {
			viewTestController.type("//input[@id='salvaCursoNome']", nome);
		}

		/* Action Path: /MantemCursoUC/AlterandoCursoSalvaCurso */
		/* viewTestController.click("//input[@id='form_submit' "); */
		/* viewTestController.click("//input[@value='salvaCurso']"); */
		viewTestController.click("//input[@name='mantemCursoUCAlterandoCursoSalvaCursoForm']");

		viewTestController.waitForPageToLoad("30000");
	}

	public void open_action1_salvaCurso() {
		this.viewTestController.open("/sistemaacademico/geral/MantemCursoUC/AlterandoCursoSalvaCurso.do");
	}

	/**
	 * voltar
	 * Action number 2.
	 *
	 */
	public void action2_voltar() {
		/* Action Path: /MantemCursoUC/AlterandoCursoVoltar */
		/* viewTestController.click("//input[@id='form_submit' "); */
		/* viewTestController.click("//input[@value='voltar']"); */
		viewTestController.click("//input[@name='mantemCursoUCAlterandoCursoVoltarForm']");

		viewTestController.waitForPageToLoad("30000");
	}

	public void open_action2_voltar() {
		this.viewTestController.open("/sistemaacademico/geral/MantemCursoUC/AlterandoCursoVoltar.do");
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
