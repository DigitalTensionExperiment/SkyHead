package com.base.elements.pages;

import org.openqa.selenium.WebDriver;
import com.base.elements.pages.CheckoutLogin;

public class Login extends BasePage {
	
	Homepage home; 
	 
	
	
	public Login(WebDriver driver){
		super(driver);
	}
	
	public void login(String email,String pw){
		CheckoutLogin ck = new CheckoutLogin(home.driver); 
		ck.loginEmail().sendKeys(email); 
		ck.loginPassword().sendKeys(pw); 
		System.out.println(home.driver.getCurrentUrl()); 
		//ck.loginClick();
	}
	
	public void loginEmailWrite(CheckoutLogin ck,String email){ 
		ck = new CheckoutLogin(home.driver); 
		ck.loginEmail().sendKeys(email);
	} 
	
	public void loginPwWrite(CheckoutLogin ck,String pw){ 
		ck = new CheckoutLogin(home.driver); 
		ck.loginPassword().sendKeys(pw);
	}
	
	public void go(CheckoutLogin ck){
		ck = new CheckoutLogin(home.driver);  
		//ck.loginClick();
	}
	
	
	
}
