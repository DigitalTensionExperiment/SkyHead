package com.base.elements;

public enum BillingPageElements {
	
	
	headerText(""),
	progressIndicator(""),
	
	savedAddressDD("//select[@id='dwfrm_billing_addressList']"),
	
	//RHS 
	orderSummaryRHS("//div[@class='checkout-mini-cart']"),
	itemsRHS("//div[@class='mini-cart-product']"),
	orderTotalRHS("//div[@class='checkout-order-totals']"), 
	orderTotalRowsRHS(""), 
	shippingAddressRHS(""),
	editShipping("//div[contains(@class,'mini-shipment')]/h3[@class='section-header']/a"),
	billingAddressRHS(""),
	editBilling("//div[contains(@class,'mini-billing')]/h3[@class='section-header']/a"),
	paymentMethodRHS(""), 
	editPaymentInfo("//div[contains(@class,'mini-payment')]/h3[@class='section-header']/a"),
	
	//BillingAddress
	firstname("//input[contains(@id,'addressFields_firstName')]"), 
	firstnameID("dwfrm_billing_billingAddress_addressFields_firstName"),
	
	lastname("//input[contains(@id,'addressFields_lastName')]"),
	lastnameID("dwfrm_billing_billingAddress_addressFields_lastName"),
	
	address1("//input[contains(@id,'addressFields_address1')]"),
	address1id("dwfrm_billing_billingAddress_addressFields_address1"),
	
	address2("//input[contains(@id,'addressFields_address2')]"),
	country("//input[contains(@id,'addressFields_country')]"), 
	countryID("dwfrm_billing_billingAddress_addressFields_country"),
	
	state("//input[contains(@id,'addressFields_states')]"),
	stateID("dwfrm_billing_billingAddress_addressFields_states_state"),
	
	city("//input[contains(@id,'addressFields_city')]"),
	cityID("dwfrm_billing_billingAddress_addressFields_city"),
	
	zip("//input[contains(@id,'addressFields_zip')]"),
	zipID("dwfrm_billing_billingAddress_addressFields_zip"),
	
	phone("//input[contains(@id,'addressFields_phone')]"),
	phoneID("dwfrm_billing_billingAddress_addressFields_phone"),
	
	email("//input[contains(@id,'emailAddress')]"),
	emailID("dwfrm_billing_billingAddress_email_emailAddress"),
	
	saveAddress("//input[contains(@id,'Address_addToAddressBook')]"),
	
	creditCard("is-CREDIT_CARD"),
	payPal("is-PayPal"),
	
	CCname("//input[contains(@id,'creditCard_owner')]"), 
	CCnameID("dwfrm_billing_paymentMethods_creditCard_owner"), 
	
	cardTypeDD("//select[contains(@id,'creditCard_type')]"),
	cardTypeDDid("dwfrm_billing_paymentMethods_creditCard_type"),
	
	cardNo("//input[contains(@id,'creditCard_number')]"), 
	cardNoID("dwfrm_billing_paymentMethods_creditCard_number"), 
	
	cardExpMonth("//select[contains(@id,'creditCard_month')]"), 
	cardExpMonthID("dwfrm_billing_paymentMethods_creditCard_month"), 

	cardExpYear("//select[contains(@id,'creditCard_year')]"),
	cardExpYearID("dwfrm_billing_paymentMethods_creditCard_year"),
	
	securityCode("//input[contains(@id,'creditCard_cvn')]"), 
	securityCodeID("dwfrm_billing_paymentMethods_creditCard_cvn"),
	
	saveCard("//input[contains(@id,'creditCard_saveCard')]"),
	
	savedCCList("creditCardList"), //id
	
	//continueButton("//button[@class='button-fancy-large btn-md btn-block']");
	//continueButton("dwfrm_billing_save"),
	continueButton("button-fancy-large")
	;
	
	public String locator; 
	
	private BillingPageElements(String locator){
		this.locator = locator;
	}

}
