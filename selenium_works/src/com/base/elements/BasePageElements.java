package com.base.elements;

public enum BasePageElements {
	
	
	 
	//Top RHS
	logo("//div[@id='header']/header/h1/a/img"), //logo("//h1[contains(@class,'primary-logo')]") 
	//Top LHS - line 1
	login("//ul[@class='menu-utility-user']/li[1]/a"), 
	register("//li[@class='last']/a[@class='user-register']"),
	
	//emptyCartIndicator("//div[@class='mini-cart-total']/span[2][@class='mini-cart-empty']"), 
	emptyCartIndicator("//*[contains(@class,'mini-cart-empty')]"),
	//miniCart("//a[@class='mini-cart-link']"),
	//miniCart(".mini-cart-link"), 
	miniCart("a.mini-cart-link"),
	//Top LHS - line 2
	wishList("//ul[@class='menu-utility']/li[1]/a"),
	giftRegistry("//ul[@class='menu-utility']/li[2]/a"),
	storeLocator("//ul[@class='menu-utility']/li[3]/a"),
	helpLink("//ul[@class='menu-utility']/li[4]/a"), 
	
	mainHeaderMenu("//ul[@class='menu-category level-1 clearfix']"),
	mainCategories("//ul[@class='menu-category level-1 clearfix']/li/a"), //encased in the mainHeaderMenu
	mainHeaderLevel2("//ul[contains(@class,'menu-category level-1 clearfix')]/li/div[contains(@class,'level-2')]/div/ul/li"),
	
	searchField("q"),
	searchGoButton("//fieldset/input[2]");  
	
	
	public String locator;
	
	
	private BasePageElements(String locator){
		this.locator = locator;
	}

}
