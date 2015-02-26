package basic;

import com.thoughtworks.selenium.DefaultSelenium;

public class BasicViewTestController extends DefaultSelenium {

	public BasicViewTestController() {
		super("localhost", 5444, "*chrome", "http://localhost:8080/sistemaacademico/");
	}
}
