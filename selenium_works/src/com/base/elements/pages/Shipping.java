package com.base.elements.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; 
//
//import com.base.BaseElements;
//import com.base.elements.ShippingElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.base.GetElements;
import com.base.elements.ShippingElements;




public class Shipping extends BasePage {
	
	
	
	protected List<WebElement> req; 
	
	

	public Shipping(WebDriver driver) {
		super(driver);
	}
	
	
	//get page title 
	public String pageTitle(){
		return driver.getTitle();
	}
	
	
	public List<WebElement> reqFields(){ 
		return GetElements.elementLists(ShippingElements.reqFieldNames.locator, super.driver);
		//return GetElements.elementLists(ShippingElements.reqFieldNames.locator, super.driver);
	}
	
	
	
	public WebElement first(){
		return GetElements.getElementByID(ShippingElements.firstname.locator, super.driver);
	}
	
	public boolean firstPresent(){
		return first().isDisplayed();
	}
	
	public String firstRead(){
		return first().getAttribute("value");
	}
	
	public void firstWrite(String firstname){
		first().sendKeys(firstname);
	}
	
	
	
	
	
	public WebElement last(){
		return GetElements.getElementByID(ShippingElements.lastname.locator, super.driver); 
	}
	
	public boolean lastPresent(){
		return last().isDisplayed();
	}
	
	public String lastRead(){
		return last().getAttribute("value");
	}
	
	public void lastWrite(String lastname){
		last().sendKeys(lastname); 
	}
	
	
	
	
	
	public WebElement address1(){
		return GetElements.getElementByID(ShippingElements.address1.locator, super.driver);
	} 
	
	public boolean address1Present(){
		return address1().isDisplayed();
	}
	
	public String address1Read(){
		return address1().getAttribute("value");
	}
	
	public void address1Write(String add1){
		address1().sendKeys(add1); 
	}
	
	
	
	
	
	public WebElement country(){
		return GetElements.getElementByID(ShippingElements.country.locator, super.driver);
	}
	
	public boolean countryPresent(){
		return country().isDisplayed();
	}
	
	public String countryRead(){
		return country().getAttribute("value");
	}
	
	public void countryWrite(String country){
		country().sendKeys(country); 
	}
	
	public int allCountriesTotal(){ 
		WebElement we = driver.findElement(By.id(ShippingElements.country.locator));
		Select dd = new Select(we); 
		List countries = dd.getOptions(); 
		return countries.size();
	}
	
	public void selectCountry(String country){
		WebElement we = driver.findElement(By.id(ShippingElements.country.locator));
		Select dd = new Select(we); 
		List countries = dd.getOptions(); 
		Iterator<WebElement> it = countries.iterator(); 
		while(it.hasNext()){
			WebElement elem = it.next();
			//... if statement to make the selection...
			if(elem.getText().equals(country)){
				//getAttribute("value") 
				//System.out.println(elem.getAttribute("value"));
				elem.click();
			}
		}
	}
	
	
	
	
	
	public WebElement state(){
		return GetElements.getElementByID(ShippingElements.state.locator, super.driver);
	}
	
	public boolean statePresent(){
		return state().isDisplayed();
	}
	
	public String stateRead(){
		return state().getAttribute("value");
	}
	
	public void stateWrite(String state){
		state().sendKeys(state); 
	} 
	
	public int allStatesTotal(){
		WebElement we = driver.findElement(By.id(ShippingElements.state.locator));
		Select dd = new Select(we); 
		List states = dd.getOptions();
		return states.size();
	}
	
	public void selectState(String state){
		WebElement we = driver.findElement(By.id(ShippingElements.state.locator));
		Select dd = new Select(we); 
		List states = dd.getOptions(); 
		Iterator<WebElement> it = states.iterator(); 
		while(it.hasNext()){
			WebElement elem = it.next();
			//... if statement to make the selection...
			if(elem.getText().equals(state)){
				//getAttribute("value") 
				//System.out.println(elem.getAttribute("value"));
				elem.click();
			}
		}
	}
	
	
	
	
	
	
	public WebElement city(){
		return GetElements.getElementByID(ShippingElements.city.locator, super.driver);
	}
	
	public boolean cityPresent(){
		return city().isDisplayed();
	}
	
	public String cityRead(){
		return city().getAttribute("value");
	}
	
	public void cityWrite(String city){
		city().sendKeys(city); 
	}
	
	
	
	
	
	public WebElement zip(){
		return GetElements.getElementByID(ShippingElements.zip.locator, super.driver);
	}
	
	public boolean zipPresent(){
		return zip().isDisplayed();
	}
	
	public String zipRead(){
		return zip().getAttribute("value");
	}
	
	public void zipWrite(String zip){
		zip().sendKeys(zip); 
	}
	
	
	
	
	
	
	
	public WebElement phone(){
		return GetElements.getElementByID(ShippingElements.phone.locator, super.driver);
	}
	
	public boolean phonePresent(){
		return phone().isDisplayed();
	}
	
	public String phoneRead(){
		return phone().getAttribute("value");
	}
	
	public void phoneWrite(){
		phone().sendKeys("333-333-3333"); 
	}
	
	
	
	
	
	public WebElement sameBillingAddress(){
		return GetElements.getElementByID(ShippingElements.useThisForBilling.locator, super.driver);
	}
	
	public boolean sbaPresent(){ 
		return sameBillingAddress().isDisplayed();
	}
	
	public boolean sbaSelected(){
		return sameBillingAddress().isSelected();
	}
	
	public void sbaApply(){
		sameBillingAddress().click();
	}
	
	
	
	
	public WebElement continueButton(){
		return GetElements.getElementByName(ShippingElements.continueButton.locator, super.driver);
		//return GetElements.getElementByXpath(ShippingElements.continueButton.locator, super.driver);
	}
	
	public boolean continueButtonPresent(){
		return continueButton().isDisplayed();
	}
	
	public void continueToBilling(){
		continueButton().click();
	}
	
	
	
	
	
	
	
	

}

















