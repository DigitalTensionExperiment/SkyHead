package com.base.elements;

public enum PlaceOrderElements {
	
	
	headerText(""),
	progressIndicator(""),
	
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
	
	cartTable("cart-table"), //id
	cartRows("//table[@id='cart-table']/tbody/tr"), 
	cells("//table[@id='cart-table']/tbody/tr/td"), 
	
	itemImageCell("//table[@id='cart-table']/tbody/tr/td[1]"),
	itemDetailsCell("//table[@id='cart-table']/tbody/tr/td[2]"),
	itemQuantityCell("//table[@id='cart-table']/tbody/tr/td[3]"), 
	availabilityInfoCell("//table[@id='cart-table']/tbody/tr/td[4]"),
	itemPriceCell("//table[@id='cart-table']/tbody/tr/td[5]"),
	itemTotalCell("//table[@id='cart-table']/tbody/tr/td[6]"), 
	
	orderSummary("//table[@class='order-totals-table']"), 
	subtotal("//table[@class='order-totals-table']/tbody/tr[1]/td[2]"),
	shipping("//table[@class='order-totals-table']/tbody/tr[2]/td[2]"),
	salesTax("//table[@class='order-totals-table']/tbody/tr[3]/td[2]"),
	orderTotal("//table[@class='order-totals-table']/tbody/tr[4]/td[2]"), 
	
	editCart("//fieldset/div[@class='form-row']/a"),
	//buyButton("//fieldset/div[@class='form-row']/button")
	buyButton("submit") //name
	;
	
	
	
	public String locator; 
	
	private PlaceOrderElements(String locator){
		this.locator = locator;
	}
	

}
