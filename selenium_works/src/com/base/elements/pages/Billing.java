package com.base.elements.pages;

//import com.base.elements.pages.actions.WebDriver;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.base.GetElements;
import com.base.elements.BillingPageElements;
import com.base.elements.ShippingElements;

//import com.base.BaseElements;
//import com.base.elements.BillingPageElements;

/**
 * 
 * @author zareenwilhelm 
 * This class contains methods that are supposed to get all elements found on a Billing page; 
 *
 */


public class Billing extends BasePage {
	
	
	public Billing(WebDriver driver) {
		super(driver);
	}
	
	public String pageTitle(){
		return driver.getTitle();
	}
	
	
	
	public WebElement firstnameBilling(){
		return GetElements.getElementByID(BillingPageElements.firstnameID.locator, super.driver);
	}
	
	public boolean firstBillPresent(){
		return firstnameBilling().isDisplayed();
	}
	
	public String firstBillRead(){
		return firstnameBilling().getAttribute("value");
	}
	
	public void firstBillWrite(String fn){
		firstnameBilling().sendKeys(fn);
	}
	
	
	public WebElement lastnameBilling(){
		return GetElements.getElementByID(BillingPageElements.lastnameID.locator, super.driver);
	}
	
	public boolean lastBillPresent(){
		return lastnameBilling().isDisplayed();
	}
	
	public String lastBillRead(){
		return lastnameBilling().getAttribute("value");
	}
	
	public void lastBillWrite(String ln){
		lastnameBilling().sendKeys(ln);
	}
	
	
	public WebElement address1Billing(){
		return GetElements.getElementByID(BillingPageElements.address1id.locator, super.driver);
	}
	
	public boolean add1BillPresent(){
		return address1Billing().isDisplayed();
	}
	
	public String add1BillRead(){
		return address1Billing().getAttribute("value");
	}
	
	public void add1BillWrite(String add1){
		address1Billing().sendKeys(add1);
	}
	
	public WebElement countryBilling(){
		return GetElements.getElementByID(BillingPageElements.countryID.locator, super.driver);
	} 
	
	public boolean countryBillPresent(){
		return countryBilling().isDisplayed();
	}
	
	public String countryBillRead(){
		return countryBilling().getAttribute("value");
	}
	
	public void countryBillWrite(String nation){
		countryBilling().sendKeys(nation);
	}
	
	public WebElement stateBilling(){
		return GetElements.getElementByID(BillingPageElements.stateID.locator, super.driver);
	}
	
	public boolean stateBillPresent(){
		return stateBilling().isDisplayed();
	}
	
	public String stateBillRead(){
		return stateBilling().getAttribute("value");
	}
	
	public void stateBillWrite(String state){
		stateBilling().sendKeys(state);
	}
	
	public WebElement cityBilling(){
		return GetElements.getElementByID(BillingPageElements.cityID.locator, super.driver);
	}
	
	public boolean cityBillPresent(){
		return cityBilling().isDisplayed();
	}
	
	public String cityBillRead(){
		return cityBilling().getAttribute("value");
	}
	
	public void cityBillWrite(String city){
		cityBilling().sendKeys(city);
	}
	
	public WebElement zipBilling(){
		return GetElements.getElementByID(BillingPageElements.zipID.locator, super.driver);
	}
	
	public boolean zipBillPresent(){
		return zipBilling().isDisplayed();
	}
	
	public String zipBillRead(){
		return zipBilling().getAttribute("value");
	}
	
	public void zipBillWrite(String zip){
		zipBilling().sendKeys(zip);
	}
	
	public WebElement phoneBilling(){
		return GetElements.getElementByID(BillingPageElements.phoneID.locator, super.driver);
	}
	
	public boolean phoneBillPresent(){
		return phoneBilling().isDisplayed();
	}
	
	public String phoneBillRead(){
		return phoneBilling().getAttribute("value");
	}
	
	public void phoneBillWrite(String phone){
		phoneBilling().sendKeys(phone);
	}
	
	public WebElement emailBilling(){
		return GetElements.getElementByID(BillingPageElements.emailID.locator, super.driver);
	}
	
	public boolean emailBillPresent(){
		return emailBilling().isDisplayed();
	}
	
	public String emailBillRead(){
		return emailBilling().getAttribute("value");
	}
	
	public void emailBillWrite(String email){
		emailBilling().sendKeys(email);
	}
	
	public WebElement creditCardOption(){
		return GetElements.getElementByID(BillingPageElements.creditCard.locator, super.driver);
	}
	
	public boolean ccOptionPresent(){
		return creditCardOption().isDisplayed();
	}
	
	public boolean ccOptionRead(){
		return creditCardOption().isSelected();
	}
	
	public void ccOptionSelect(){
		creditCardOption().click();
	}
	
	
	
	public WebElement savedCCList(){
		return GetElements.getElementByID(BillingPageElements.savedCCList.locator, super.driver);
	} 
	
	public boolean savedCCpresent(){
		return savedCCList().isDisplayed();
	}
	
	
	
	
	public WebElement ccNameField(){
		return GetElements.getElementByID(BillingPageElements.CCnameID.locator,super.driver);
	}
	
	public boolean ccNameFieldPresent(){
		return ccNameField().isDisplayed();
	}
	
	public String ccNameRead(){
		return ccNameField().getAttribute("value");
	}
	
	public void ccNameWrite(String ccname){
		ccNameField().sendKeys(ccname);
	}
	
	
	
	
	public WebElement cardTypeDD(){
		return GetElements.getElementByID(BillingPageElements.cardTypeDDid.locator, super.driver);
	}
	
	public boolean cardTypeDDPresent(){
		return cardTypeDD().isDisplayed();
	}
	
	public String cardTypeRead(){
		return cardTypeDD().getAttribute("value");
	}
	
//	public void cardTypeSelect(){
//		//...
//	}
	
	public int totalCardTypes(){ 
		WebElement we = driver.findElement(By.id(BillingPageElements.cardTypeDDid.locator));
		Select dd = new Select(we); 
		List cardTypes = dd.getOptions(); 
		return cardTypes.size();
	}
	
	public void cardTypeSelect(String type){
		WebElement we = driver.findElement(By.id(BillingPageElements.cardTypeDDid.locator));
		Select dd = new Select(we); 
		List cardTypes = dd.getOptions(); 
		Iterator<WebElement> it = cardTypes.iterator(); 
		while(it.hasNext()){
			WebElement elem = it.next();
			//... if statement to make the selection...
			if(elem.getText().equals(type)){
				//getAttribute("value") 
				//System.out.println(elem.getAttribute("value"));
				elem.click();
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	public WebElement cardNumberField(){
		return GetElements.getElementByID(BillingPageElements.cardNoID.locator,super.driver);
	}
	
	public boolean cardNumberFieldPresent(){
		return cardNumberField().isDisplayed();
	}
	
	public String cardNoRead(){
		return cardNumberField().getAttribute("value");
	}
	
	public void cardNoWrite(String number){
		cardNumberField().sendKeys(number);
	}
	
	
	public WebElement cardExpMonthDD(){
		return GetElements.getElementByID(BillingPageElements.cardExpMonthID.locator, super.driver);
	}
	
	public boolean cardExpMnthPresent(){
		return cardExpMonthDD().isDisplayed();
	}
	
	public String cardExpMnthRead(){
		return cardExpMonthDD().getAttribute("value");
	}
	
	public void cardExpMnthSelect(){
		//...
	}
	
	
	public WebElement cardExpYrDD(){
		return GetElements.getElementByID(BillingPageElements.cardExpYearID.locator, super.driver);
	}
	
	public boolean cardExpYrPresent(){
		return cardExpYrDD().isDisplayed();
	}
	
	public String cardExpYrRead(){
		return cardExpYrDD().getAttribute("value");
	}
	
	public void cardExpYrSelect(String year){
		WebElement we = driver.findElement(By.id(BillingPageElements.cardExpYearID.locator));
		Select dd = new Select(we); 
		List expYrs = dd.getOptions(); 
		Iterator<WebElement> it = expYrs.iterator(); 
		while(it.hasNext()){
			WebElement elem = it.next();
			//... if statement to make the selection...
			if(elem.getText().equals(year)){
				//getAttribute("value") 
				//System.out.println(elem.getAttribute("value"));
				elem.click();
			}
		}
	}
	
	public WebElement cvnField(){
		return GetElements.getElementByID(BillingPageElements.securityCodeID.locator,super.driver);
	}
	
	public boolean cvnFieldPresent(){
		return cvnField().isDisplayed();
	}
	
	public String cvnFieldRead(){
		return cvnField().getAttribute("value");
	}
	
	public void cvnFieldWrite(String code){
		cvnField().sendKeys(code);
	}
	
	public WebElement continueButton(){
		//return GetElements.getElementByName(BillingPageElements.continueButton.locator, super.driver);
		return GetElements.getElementByClassName(BillingPageElements.continueButton.locator, super.driver);
	}
	
	public boolean continueButtonPresent(){
		return continueButton().isDisplayed();
	}
	
	public void continueToPlaceOrder(){
		continueButton().click();
	}
	
	
	
	
	

}
