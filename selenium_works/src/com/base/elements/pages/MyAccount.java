/**
 * 
 */
package com.base.elements.pages;

import org.openqa.selenium.WebDriver;

//import com.base.BaseElements;
//import com.base.elements.MyAccountElements;

/**
 * @author zareenwilhelm
 *
 */
public class MyAccount extends BasePage  {

	/**
	 * 
	 */
	public MyAccount(WebDriver driver) {
		super(driver);
	}
	
	
	//get page title 
	public String pageTitle(){
		return driver.getTitle();
	}
	

}
