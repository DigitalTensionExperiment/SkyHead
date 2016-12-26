package com.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetElements {
	
//	protected WebDriver driver;
//	public GetElements(WebDriver driver) {
//		//super(driver); 
//		this.driver = driver;
//	} 
	
	
	static List<WebElement> categories; 
	//WebDriver driver = super.driver;
	
	
	public String pageTitle(WebDriver driver){
		return driver.getTitle();
	}
	
	
	//retrieve an element using its xpath location
	public static WebElement getElementByXpath(String locator,WebDriver driver){
		WebElement element = driver.findElement(By.xpath(locator));
		return element;
	}
	
	//retrieve an element using its name
	public static WebElement getElementByName(String locator,WebDriver driver){ 
		WebElement element = driver.findElement(By.name(locator));
		return element;
	}
	
	//retrieve an element by using its ID
	public static WebElement getElementByID(String locator,WebDriver driver){
		WebElement element = driver.findElement(By.id(locator));
		return element;
	} 
	
	public static WebElement getElementByClassName(String locator,WebDriver driver){
		WebElement element = driver.findElement(By.className(locator)); 
		return element;
	}
	
	//retrieve an element using its css location
	public static WebElement getElementByCSS(String locator,WebDriver driver){
		WebElement element = driver.findElement(By.cssSelector(locator));
		return element;
	}
	
	//return a list of all elements which share the input xpath value 
	public static List<WebElement> elementLists(String locator,WebDriver driver){
		return categories = driver.findElements(By.xpath(locator)); 
	}
}
