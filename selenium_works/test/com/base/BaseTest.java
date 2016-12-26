package com.base;

//import junit.framework.JUnit4TestAdapter;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver; 
//import com.inflectra.spiratest.addons.junitextension.*; 

//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver; 
//import org.openqa.selenium.remote
//import com.MJI.cart.numbers.CartPriceTest;


import com.base.elements.pages.BasePage;
//import com.base.elements.pages.Registration;

//@SpiraTestConfiguration(
//		url="https://mediahive.spiraservice.net",
//		login="administrator",
//		password="=[>7vbhi)z6uYN",
//		projectId=11,
//		releaseId=-1,  
//		testSetId=-1   
//	)

public class BaseTest { 
	
	
	static protected WebDriver driver; // = new FirefoxDriver();
	String title;
	
	final static String host = "http://dev05-lab03b-dw.demandware.net";
			
			//"https://production.sitegenesis.dw.demandware.net";
			
			//"http://dev05-lab03b-dw.demandware.net"; 
	
	
	public static void urlLaunch(String path){ 
        driver.get(host + path); 
	}
	
	public static void runHeadless(){
		System.setProperty("phantomjs.binary.path", "/Users/zareenwilhelm/Documents/jars/phantomjs-1.9.7-macosx/bin/phantomjs"); 
		driver = new PhantomJSDriver(); 
		driver.manage().window().maximize();
	}
	
	public void refresh(){
		
	}
	
	public static void complete(){
		driver.close();
	}
	
	
	public void setup(BasePage bp, String url){
		//runHeadless();
		urlLaunch(url);
		title = bp.title();
	}
	
	

}