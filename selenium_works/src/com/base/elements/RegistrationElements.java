package com.base.elements;

public enum RegistrationElements {
	
	header("//div[@id='primary']/h1"),
	headerText("Create Account"),
	
	firstName("dwfrm_profile_customer_firstname"), //id
	lastName("dwfrm_profile_customer_lastname"),  //id
	email("dwfrm_profile_customer_email"),  //id
	emailConfirm("dwfrm_profile_customer_emailconfirm"),  //id
	password("dwfrm_profile_login_password"),  //id
	passwordConfirm("dwfrm_profile_login_passwordconfirm"),  //id 
	submitButton("dwfrm_profile_confirm"), //name
	
	joinEmailList("") 
	;
	
	
	
	
	public String locator; 
	
	private RegistrationElements(String locator){
		this.locator = locator;
	}

}
