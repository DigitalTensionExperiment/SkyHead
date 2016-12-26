package com.base.elements;

public enum MyAccountElements {
	
	//MY ACCOUNT LOGIN PAGE: 
	myAccountLoginURL(""),
	loginPageHeader(""),
	
	//shopperType = returningCustomer() 
	loginEmail("//input[contains(@id,'login_username')]"), 
	loginPassword("//input[contains(@id,'login_password')]"),
	rememberMe("//input[contains(@id,'login_rememberme')]"),
	loginButton("//button[contains(@name,'login_login')]"),
	forgotPassword("//a[@id='password-reset']"), 
		
	//shopperType = newCustomer()
	createAccount("//button[contains(@name,'login_register')]"),
	
	//check an order
	orderNumber("dwfrm_ordertrack_orderNumber"),
	billingZip("dwfrm_ordertrack_postalCode"),
	
	
	
	
	//MY ACCOUNT PAGE: 
	personalDataLink(""),
	addressesLink(""),
	orderHistoryLink(""),
	wishListLink(""),
	giftRegistries("")
	
	;
	
	public String locator; 
	
	private MyAccountElements(String locator){
		this.locator = locator;
	}

}
