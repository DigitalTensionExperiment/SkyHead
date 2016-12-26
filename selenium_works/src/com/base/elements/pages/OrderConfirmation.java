package com.base.elements.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.base.GetElements;
import com.base.elements.OrderConfirmationElements;

//import com.base.BaseElements;
//import com.base.elements.OrderConfirmationElements;

/**
 * 
 * @author zareenwilhelm 
 * This class contains methods that are supposed to get all elements found on an OrderConfirmation page; 
 *
 */


public class OrderConfirmation extends BasePage  {

	public OrderConfirmation(WebDriver driver) { 
		super(driver);
	}
	
	
	//get page title 
	public String pageTitle(){
		return driver.getTitle();
	}
	
	public WebElement orderNumber(){
		return GetElements.getElementByXpath(OrderConfirmationElements.orderNo.locator, super.driver);
	}
	

}
