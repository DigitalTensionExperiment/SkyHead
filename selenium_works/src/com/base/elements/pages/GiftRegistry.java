package com.base.elements.pages;
import org.openqa.selenium.WebDriver; 

//import com.base.BaseElements;
//import com.base.elements.GiftRegistryElements;


/**
 * 
 * @author zareenwilhelm 
 * This class contains methods that are supposed to get all elements found on the GiftRegistry page; 
 *
 */


public class GiftRegistry extends BasePage {

	public GiftRegistry(WebDriver driver) {
		super(driver); 
	}
	
	
	//get page title
	public String pageTitle(){
		return driver.getTitle();
	}
	
	
}
