package accessControl;

import basic.BasicViewTestController;

public class AccessControlViewTest {
	protected BasicViewTestController viewTestController;

	public AccessControlViewTest(BasicViewTestController viewTestController) {
		this.viewTestController = viewTestController;

		this.viewTestController.open("/sistemaacademico/");
	}

	public void login(String usuario, String senha) {
		if (usuario != null)
			viewTestController.type("validarLogin", usuario);

		if (senha != null)
			viewTestController.type("validarSenha", senha);

		viewTestController.click("//input[@id='form_submit']");

		viewTestController.waitForPageToLoad("30000");
	}

	public void logout() {
		viewTestController.open("/sistemaacademico/secure/NovaConexao.do");

		viewTestController.waitForPageToLoad("30000");
	}
}
