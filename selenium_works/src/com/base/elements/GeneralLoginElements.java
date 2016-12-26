package com.base.elements;



public enum GeneralLoginElements {
	
	headerText("My Account Login"),
	
	loginEmail("//input[contains(@id,'login_username')]"), 
	loginPassword("//input[contains(@id,'login_password')]"), 
	rememberMe("//input[contains(@id,'login_rememberme')]"),
	loginButton("//button[contains(@name,'login_login')]"),
	forgotPassword("//a[@id='password-reset']")
	;
	
	public String locator;
	
	private GeneralLoginElements(String locator){
		this.locator = locator;
	}
}
