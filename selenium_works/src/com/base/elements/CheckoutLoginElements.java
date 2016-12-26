package com.base.elements;

public enum CheckoutLoginElements { 
	
	headerText("Checkout Login"),
	
	//shopperType = guest() 
	//guestButton("//button[contains(@name,'unregistered')]"),
	guestButton("dwfrm_login_unregistered"),  //name
	//shopperType = returningCustomer() 
	loginEmail("//input[contains(@id,'login_username')]"), 
	loginPassword("//input[contains(@id,'login_password')]"),
	rememberMe("//input[contains(@id,'login_rememberme')]"),
	loginButton("//button[contains(@name,'login_login')]"),
	forgotPassword("//a[@id='password-reset']"), 
	
	//shopperType = newCustomer()
	createAcctButton("//button[contains(@name,'login_register')]");
	
	public String locator; 
	
	private CheckoutLoginElements(String locator){
		this.locator = locator;
	}
	
	

}
