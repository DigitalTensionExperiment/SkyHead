package com.base.elements;

public enum OrderConfirmationElements {
	
	headerText(""), 
	
	orderNo("//div[@class='order-number ']/span[@class='value']"),
	
	orderSummaryTable(""),
	orderInfoCell(""),
	billingAddressCell(""),
	paymentMethodCell(""),
	paymentTotalCell(""),
	
	shipmentTable(""),
	itemInfoCell(""),
	quantityCell(""),
	priceCell(""),
	shippingInfoCell(""),
	
	returnToShippingButton(""),
	
	
	;
	
	
	public String locator; 
	
	private OrderConfirmationElements(String locator){
		this.locator = locator;
	}
	

}
