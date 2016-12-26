package com.base;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
//import org.openqa.selenium.WebDriver;
import com.inflectra.spiratest.addons.junitextension.*; 
import junit.framework.JUnit4TestAdapter;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import com.base.elements.pages.CheckoutLogin;


@SpiraTestConfiguration(
	url="https://mediahive.spiraservice.net",
	login="administrator",
	password="=[>7vbhi)z6uYN",
	projectId=11,
	releaseId=-1,  
	testSetId=-1   
)



public class ExampleTest extends BaseTest {
	
	
	CheckoutLogin c;
	public String title;
	
	@Before
	public void setup() {  
		super.runHeadless();
		super.urlLaunch("/s/SiteGenesis/home");
		c = new CheckoutLogin(super.driver); 
		title = c.pageTitle();
	}

	@Test 
	@SpiraTestCase(testCaseId=274)
	public void test() { 
		//String title = c.getTitle(); 
		System.out.println(title); 
		assertEquals(title,"something"); 
		//SiteGenesis Online Store
	}
	
	
	public static void main (String[] args)
	{
		//Instantiate the JUnit core
		JUnitCore core = new JUnitCore();

		//Add the custom SpiraTest listener
		core.addListener(new SpiraTestListener());

		//Finally run the test fixture
		core.run(ExampleTest.class);
	}

	/**
	 * Entry point for JUnit 4.x runners
	 * 
	 * @return		Handle to the test framework
	 */
	public static junit.framework.Test suite() 
	{
		return new JUnit4TestAdapter(ExampleTest.class);
	}

}
