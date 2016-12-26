package com.base.elements.pages;

import org.openqa.selenium.WebDriver; 
//import com.base.elements.BaseElements;  



public class ProductsLanding extends BasePage {

	public ProductsLanding(WebDriver driver) {
		super(driver); 
	}
	
	
	//get page title 
	public String pageTitle(){
		return driver.getTitle();
	}
	
}
