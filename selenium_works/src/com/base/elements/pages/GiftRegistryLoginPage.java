package com.base.elements.pages;

import org.openqa.selenium.WebDriver;

public class GiftRegistryLoginPage extends BasePage {
	
	public GiftRegistryLoginPage(WebDriver driver) {
		super(driver);
	}
	
	
	
	//get page title 
	public String pageTitle(){
		return driver.getTitle();
	}
	
	
}
