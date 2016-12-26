package com.base.elements.pages;

import org.openqa.selenium.WebDriver;

//import com.base.BaseElements;
//import com.base.elements.HomepageElements;

/**
 * 
 * @author zareenwilhelm 
 * This class contains methods that are supposed to get all elements found on a Homepage ; 
 *
 */

public class Homepage extends BasePage {

	public Homepage(WebDriver driver) {
		super(driver);
	}
	
	
	
	//get page title 
	public String pageTitle(){
		return driver.getTitle();
	}
	

}
