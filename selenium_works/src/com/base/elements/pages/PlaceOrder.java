package com.base.elements.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.base.GetElements;
import com.base.elements.PlaceOrderElements;

//import com.base.BaseElements;
//import com.base.elements.PlaceOrderElements;

/**
 * 
 * @author zareenwilhelm 
 * This class contains methods that are supposed to get all elements found on a PlaceOrder page; 
 *
 */


public class PlaceOrder extends BasePage {

	public PlaceOrder(WebDriver driver) {
		super(driver);
	}
	
	
	//get page title 
	public String pageTitle(){
		return driver.getTitle();
	}
	
	
	public WebElement cartTable(){
		return GetElements.getElementByID(PlaceOrderElements.cartTable.locator, super.driver);
	}
	
	public boolean cartTablePresent(){
		return cartTable().isDisplayed();
	}
	
	
	
	
	public WebElement buyButton(){
		return GetElements.getElementByName(PlaceOrderElements.buyButton.locator, super.driver); 
	}
	
	public boolean buyButtonCheck(){
		return buyButton().isDisplayed();
	} 
	
	public void purchase(){
		buyButton().click();
	}
	
	
	

}
