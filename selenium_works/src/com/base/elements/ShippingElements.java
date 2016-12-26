package com.base.elements;

public enum ShippingElements {
	
	
	headerText(""),
	progressIndicator(""),
	
	savedAddressDD("//select[@id='dwfrm_singleshipping_addressList']"),
	
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
	
	//ShippingAddress
	//firstname("//input[contains(@id,'addressFields_firstName')]"),
	firstname("dwfrm_singleshipping_shippingAddress_addressFields_firstName"),
	//lastname("//input[contains(@id,'addressFields_lastName')]"), 
	lastname("dwfrm_singleshipping_shippingAddress_addressFields_lastName"),
	//address1("//input[contains(@id,'addressFields_address1')]"), 
	address1("dwfrm_singleshipping_shippingAddress_addressFields_address1"),
	//address2("//input[contains(@id,'addressFields_address2')]"),
	//country("//input[contains(@id,'addressFields_country')]"),
	country("dwfrm_singleshipping_shippingAddress_addressFields_country"),
	//state("//input[contains(@id,'addressFields_states')]"), 
	state("dwfrm_singleshipping_shippingAddress_addressFields_states_state"),
	//city("//input[contains(@id,'addressFields_city')]"), 
	city("dwfrm_singleshipping_shippingAddress_addressFields_city"), 
	//zip("//input[contains(@id,'addressFields_zip')]"),
	zip("dwfrm_singleshipping_shippingAddress_addressFields_zip"),
	//phone("//input[contains(@id,'addressFields_phone')]"),
	phone("dwfrm_singleshipping_shippingAddress_addressFields_phone"),
	
	//requiredFields("//*[@class='required-indicator']"), 
	requiredFields("//div[@class='form-row   required ']"), 
	reqFieldNames("//div[@class='form-row   required ']/label/span[2]"),
	requiredTextFields("//*[@class='input-text required']"), 
	requiredDD("//*[@class='bt-dropdown-toggle ']"),
	
	saveAddress("//input[contains(@id,'Address_addToAddressBook')]"),
	//useAsBillingAddress("input[contains(@id,'useAsBillingAddress')]"), 
	useThisForBilling("dwfrm_singleshipping_shippingAddress_useAsBillingAddress"),
	
	shippingMethodsList(""),
	ground(""),
	twoDay(""),
	threeDay(""),
	overnight(""), 
	express(""), 
	
	continueButton("dwfrm_singleshipping_shippingAddress_save") //name
	//continueButton("//button[contains(@name,'shippingAddress_save')]")
	; 
	


	public String locator; 
	
	private ShippingElements(String locator){
		this.locator = locator;
	}
}
