package com.base.elements.pages;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;

import java.util.List;


//import org.junit.Assert;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.WebDriver;







//import org.openqa.selenium.firefox.FirefoxDriver;
import com.base.GetElements;
import com.base.elements.BasePageElements;

/**
 * 
 * @author zareenwilhelm 
 * This class contains methods which get all elements that are accessible outside of any particular page; 
 * Gets all elements that are general too all pages;
 * 
 */



public class BasePage { // extends BaseClass {

	
	//public String searchFilter;
	
	public WebDriver driver;
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	GetElements elem; // = new GetElements(this.driver);
	protected List<WebElement> mainCategories; // = getWebDriver().findElements(By.xpath(xpath));
	

	
	
	
	
	//Get page title 
	public String title(){
		return this.driver.getTitle();
	}
	
	
	//Get catalog navigation header - might need to return a List  
	public List<WebElement> catalogNavHeader(){
		return GetElements.elementLists("//ul[contains(@class,'menu-category level-1 clearfix')]/li/a", this.driver);
	}
	
	//Count no# of links returned by mainCategoryHeader link list: 
	public int mainCategoryCount(){
		return catalogNavHeader().size();
	}
	
	//Loop through each of the mainCategory links returned above, 
		// do a mouse-over and check how many links each category makes visible: 
		// return lists at each loop; 
	
	//These are the next level down from mainCategories: 
	public List<WebElement> catalogSubCategories(){
		//return mainCategories =GetElements.elementLists("//ul[contains(@class,'menu-category level-1 clearfix')]/li/div[contains(@class,'level-2')]/div/ul/li");
		return mainCategories = GetElements.elementLists(BasePageElements.mainHeaderLevel2.locator, this.driver);
	}
	
	
	
	
	
	
	
	//Get Logo 
	public WebElement logo(){
		return GetElements.getElementByXpath(BasePageElements.logo.locator, this.driver);
	} 
	
	//logo.isDisplayed(); 
	
	//logo.click(); 
	
	
	
	
	
	
	//Get LOGIN link 
	public WebElement loginLink(){
		return GetElements.getElementByXpath(BasePageElements.login.locator, this.driver);
	}
	
	//loginLink.isDisplayed(); 
	
	//loginLink.click(); 
	public void startLogin(){
		loginLink().click();
	}
	
	
	
	//Get REGISTER link 
	public WebElement registerLink(){
		return GetElements.getElementByXpath(BasePageElements.register.locator, this.driver);
	}
	
	
	//registerLink.isDisplayed(); 
	
	
	//registerLink.click(); 
	public void startRegistration(){
		registerLink().click();
	}
	
	
	
	
	//BasePageElementLocations.searchField.locator 
	public WebElement searchTextfield(){
		return GetElements.getElementByID("q", this.driver); 
	} 
	
	//searchTextField.isDisplayed(); 
//	public void searchFieldPresent(BasePage page){
//		assertEquals(page.searchTextfield().isDisplayed(),true);
//	}
	
	//readSearchField 
	public String readSearchField(){
		return searchTextfield().getAttribute("value"); 
	}
	
	//clearSearchField 
	public void clearSearchField(){
		searchTextfield().clear();
	}
	
	//inputSearchFilter 
	public void writeSearchField(String searchFilter){
		searchTextfield().sendKeys(searchFilter);  //insert some search term 
		//System.out.println("Search term: " +  readSearchField());
	}
	
	
	public WebElement searchGoButton(){
		return GetElements.getElementByXpath(BasePageElements.searchGoButton.locator, this.driver);
	}
	
	
	//Get mini-cart 
	public WebElement minicart(){
		return GetElements.getElementByCSS(BasePageElements.miniCart.locator, this.driver);
	} 
	
	
	//minicart.isDisplayed(); 
	public boolean miniCartLinkDisplay(){
		return minicart().isDisplayed();
	}
	
	
	//minicart.click(); 
	public void goToCart(){
		minicart().click();
	}
	
	
	
	
	public void minicartMouseOver(){
		//minicart(); 
	}
	
	
	//Get empty-mini-cart 
	public WebElement cartEmpty(){
		return GetElements.getElementByXpath(BasePageElements.emptyCartIndicator.locator, this.driver); 
	}
	
	//cartEmpty.isDisplayed(); 
	public boolean isCartEmpty(){
		return cartEmpty().isDisplayed(); 
	}
	
	//check if cart is empty 
//	public boolean cartEmptyPDP(){
//		return cartEmpty().isDisplayed();
//	}
	
	//if cart != empty: go to cart: 
	
	
	
	
	
	
	//Get HELP link 
	public WebElement helpLink(){
		return GetElements.getElementByXpath(BasePageElements.helpLink.locator, this.driver);
	}
	
	//helpLink.isDisplayed(); 
	
	//helpLink.click(); 
	
	
	
	
	//Get StoreLocator link 
	public WebElement storeFinder(){
		return GetElements.getElementByXpath(BasePageElements.storeLocator.locator, this.driver);
	}
	
	
	
	
	

}
