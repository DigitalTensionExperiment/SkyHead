package com.base.elements.pages;

import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;

import com.base.GetElements;
import com.base.elements.CheckoutLoginElements;


public class CheckoutLogin extends BasePage  {
	
	
	public CheckoutLogin(WebDriver driver) {
		super(driver); 
	}
	
	
	//BaseElements checkout = new BaseElements(this.driver);
	
	
	
	
	
	public String pageTitle(){
		return driver.getTitle();
	}
	
	
	
	//Select guest() option: 
	//		confirm guest button present 
	public WebElement guestButton(){
		return GetElements.getElementByName(CheckoutLoginElements.guestButton.locator, super.driver);
	}
	
	
	
	//Select returningCustomer() option: 
	public WebElement loginEmail(){
		return GetElements.getElementByXpath(CheckoutLoginElements.loginEmail.locator, super.driver);
	}
	
	public boolean loginEmailFieldPresent(){
		return loginEmail().isDisplayed();
	}
	
	
	
	
	
	public WebElement loginPassword(){
		return GetElements.getElementByXpath(CheckoutLoginElements.loginPassword.locator, super.driver);
	}
	
	public boolean loginPwFieldPresent(){
		return loginPassword().isDisplayed();
	}
	
	
	
	
	public WebElement loginButton(){
		return GetElements.getElementByXpath(CheckoutLoginElements.loginButton.locator, super.driver);
	}
	
	public boolean loginButtonPresent(){
		return loginButton().isDisplayed();
	}
	
	
	
	
	
	public WebElement rememberMe(){
		return GetElements.getElementByXpath(CheckoutLoginElements.rememberMe.locator, super.driver);
	}
	
	public boolean rememberMeChecked(){
		return rememberMe().isSelected();
	}
	
	
	
	public WebElement resetPassword(){
		return GetElements.getElementByXpath(CheckoutLoginElements.forgotPassword.locator, super.driver);
	}
	
	
	
	//Select newUser() option: 
	public WebElement newUser(){
		return GetElements.getElementByXpath(CheckoutLoginElements.createAcctButton.locator, super.driver);
	}

}
