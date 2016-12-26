/**
 * 
 */
package com.base.elements.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.base.GetElements;
import com.base.elements.RegistrationElements;



/**
 * @author zareenwilhelm
 *
 */
public class Registration extends BasePage {

	/**
	 * 
	 */
	public Registration(WebDriver driver) {
		super(driver); 
	}
	
	
	//BaseElements reg = new BaseElements(this.driver);
	
	
	public String pageTitle(){
		return driver.getTitle();
	}
	
	//getURL 
	
	//get check h1 header 
	public WebElement headerCheck(){
		return GetElements.getElementByXpath(RegistrationElements.header.locator, super.driver);
	}
	
	
	
	//get firstName field: 
	public WebElement firstname(){
		return GetElements.getElementByID(RegistrationElements.firstName.locator, super.driver); 
	}
	//	check label 

	
	
	//get lastName field: 
	public WebElement lastname(){
		return GetElements.getElementByID(RegistrationElements.lastName.locator, super.driver);
	}
	//	check label 
	
 
	
	//get email textfield: 
	public WebElement emailField(){
		return GetElements.getElementByID(RegistrationElements.email.locator, super.driver);
	}
	//	check label 
	
	
	
	//get confirmEmail textfield: 
	public WebElement emailConfirmField(){
		return GetElements.getElementByID(RegistrationElements.emailConfirm.locator, super.driver);
	}
	//	check label 
	
 
	
	//get password textfield: 
	public WebElement passwordField(){
		return GetElements.getElementByID(RegistrationElements.password.locator, super.driver);
	}
	//	check label 
	

	
	//get passwordConfirm textfield: 
	public WebElement passwordConfirmField(){
		return GetElements.getElementByID(RegistrationElements.passwordConfirm.locator, super.driver);
	}
	//	check label 
	

	
	
	
	//get add-to-emailList Option 
	//	id = dwfrm_profile_customer_addtoemaillist
	public WebElement emailList(){
		return GetElements.getElementByID(RegistrationElements.joinEmailList.locator, super.driver);
	}
	
	
	//get Privacy policy 
	
	
	
	//get Apply button: 
	public WebElement applyButton(){
		//return reg.getElementByXpath(RegistrationElements.submitButton.locator); 
		return GetElements.getElementByName(RegistrationElements.submitButton.locator, super.driver);
	}
	 
	
	
	
	
	
	
	
	
	

}
