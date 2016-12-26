package com.base.elements.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.base.GetElements;
import com.base.elements.CheckoutLoginElements;

public class GeneralLogin extends BasePage {
	
	//BaseElements genLogin = new BaseElements(this.driver); 
	
	public GeneralLogin(WebDriver driver) {
		super(driver); 
	}
	
	public String pageTitle(){
		return driver.getTitle();
	}
	
	
	//Select returningCustomer() option: 
	public WebElement loginEmail(){
		return GetElements.getElementByXpath(CheckoutLoginElements.loginEmail.locator, super.driver);
	}
	
	public WebElement loginPassword(){
		return GetElements.getElementByXpath(CheckoutLoginElements.loginPassword.locator, super.driver);
	}
	
	public WebElement loginClick(){
		return GetElements.getElementByXpath(CheckoutLoginElements.loginButton.locator, super.driver);
	}
	
	
}
