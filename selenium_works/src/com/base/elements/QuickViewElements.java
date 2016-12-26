package com.base.elements;

public enum QuickViewElements {
	
	
	itemImage(""),
	itemName(""),
	itemNo(""),
	productPrice("//div[@id='product-content']/div[@class='product-price']/span"),  //located underneath itemNo
	priceInFieldset("//fieldset/div[@class='product-price']/span"),  //located next to add-to-cart button
	allSwatches("//li[@class='attribute']"), 
	emptySwatches("//div[@class='value']/ul/li[@class='emptyswatch']"),
	selectedSwatches("//div[@class='value']/ul/li[@class='selected-value']"),
	quantity("Quantity"), 
	sendToFriend("//ul[@class='menu']/li[3]"), 
	
	alternateViews("//div[@id='thumbnails']/ul/li"),
	
	nextButton(""),
	
	;
	
	
	public String locator; 
	
	private QuickViewElements(String locator){
		this.locator = locator;
	}
	
	
}
