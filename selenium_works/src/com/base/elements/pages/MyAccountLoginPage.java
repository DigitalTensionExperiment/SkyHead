package com.base.elements.pages;

import org.openqa.selenium.WebDriver;

public class MyAccountLoginPage extends BasePage {
	
	
	public MyAccountLoginPage(WebDriver driver) {
		super(driver);
	}
	
	
	//get page title 
	public String pageTitle(){
		return driver.getTitle();
	}
	

}
