package com.base.elements; 


public enum PDPelements {
	
	primaryImage("//img[contains(@class,'primary-image')]"),
	productName("//h1[@class='product-name']"),
	itemNo("//div[@class='product-number']/span"),
	productPrice("//div[@id='product-content']/div[@class='product-price']/span"),  //located underneath itemNo
	priceInFieldset("//fieldset/div[@class='product-price']/span"),  //located next to add-to-cart button
	//priceVisibleList("//div[@class='product-price']"),
	allSwatches("//li[@class='attribute']"), 
	//totalSwatchOptions("//div[@class='value']/ul/li"),
	emptySwatches("//div[@class='value']/ul/li[@class='emptyswatch']"),
	selectedSwatches("//div[@class='value']/ul/li[@class='selected-value']"),
	
	unitPrice("//div[@id='product-content']/div[@class='product-price']/span[@class='price-sales']"),
	
	quantity("Quantity"),
	quantityInput("Quantity"), //id 
	quantityDD(""), //class="form-control qty"
	
	availability("//div[@class='availability-msg']"),
	addToCartButton("add-to-cart"), 
	
	alternateViews("//div[@id='thumbnails']/ul/li"),
	
	addToWishListLink("//ul[@class='menu']/li[1]"),
	addToGiftRegistry("//ul[@class='menu']/li[2]"),
	sendToFriend("//ul[@class='menu']/li[3]"),
	
	description(""),
	details(""),
	reviews(""), 
	
	;
	
	
	public String locator;
	
	private PDPelements(String locator){
		this.locator = locator;
	}

}