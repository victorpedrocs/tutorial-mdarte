package org.andromda.presentation.bpm4struts;

public abstract class LayoutConfiguration{

	protected abstract String handleGetLayoutConfiguration();
	
	private static LayoutConfiguration layout = null;
	
	public String getLayoutConfiguration(){
		String layout = handleGetLayoutConfiguration();
		if(layout == null) layout = "default";
		return layout;
	}
	
	public static LayoutConfiguration instance(){
		if(layout == null) layout = new LayoutConfigurationImpl();
		return layout;
	}
	
}
