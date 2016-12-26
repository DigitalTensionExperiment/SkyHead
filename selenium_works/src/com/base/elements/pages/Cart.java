package com.base.elements.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import com.base.BaseElements;
import com.base.GetElements;
import com.base.elements.CartElements;

/**
 * 
 * @author zareenwilhelm 
 * This class contains methods that are supposed to get all elements found on a Cart page; 
 *
 */


public class Cart extends BasePage {
	
	public Cart(WebDriver driver) {
		super(driver);
	}

	
	//GetElements cart; // = new BaseElements(this.driver);
	protected List<WebElement> rows;
	
	
	//get pageTitle 
	public String pageTitle(){
		return driver.getTitle();
	}
	
	
	//get cart-table 
	public WebElement cartTable(){
		return GetElements.getElementByID(CartElements.cartTable.locator, super.driver);
	}
	
	//check if cart-table exists: 
	public boolean cartTableVisible(){
		return cartTable().isDisplayed();
	}
	
	
	public WebElement itemNumberCart(){
		return GetElements.getElementByXpath(CartElements.itemNoPerCartRow.locator, super.driver);
	}
	
	public boolean itemNoCartPresent(){
		return itemNumberCart().isDisplayed();
	}
	
	public String itemNoCartString(){
		return itemNumberCart().getText();
	}
	
	
	
	
	//use this one when there are multiple items in cart
	public List<WebElement> itemNumbers(){
		return GetElements.elementLists(CartElements.itemNoPerCartRow.locator, super.driver);
	}
	
	
	
	
	
	public WebElement productNameCart(){
		return GetElements.getElementByXpath(CartElements.productNameCart.locator, super.driver);
	}
	
	public boolean productNameCartVisible(){
		return productNameCart().isDisplayed();
	}
	
	public String productNameCartString(){
		return productNameCart().getText();
	} 
	
	
	
	
	
	
	//use this one when there are multiple items in cart
	public List<WebElement> productNames(){
		return GetElements.elementLists(CartElements.productNameCart.locator, super.driver);
	}
	
	
	public WebElement inventoryInStock(){
		return GetElements.getElementByXpath(CartElements.inStock.locator, super.driver);
	}
	
	
	public boolean inventoryCheckInStock(){
		return inventoryInStock().isDisplayed();
	}
	
	
	
	
	//return the rows in cart-table 
	public List<WebElement> cartTableRows(){
		return GetElements.elementLists(CartElements.cartRows.locator, super.driver);
	}
	//^should cart-table be dealt with like a matrix? 
	
	
	//get List of cells within each row? 
	
	
	//get [an] itemTotal 
	
	
	
	//get update-cart-button 
	public WebElement updateButton(){
		return GetElements.getElementByID(CartElements.updateCartButton.locator, super.driver);
	}
	
	//Click update-cart button 
	public void useUpdateButton(){
		updateButton().click();
	}
		
	
	
	
	
	//get orderSummary table 
	public WebElement orderSummary(){
		return GetElements.getElementByXpath(CartElements.orderTotalsTable.locator, super.driver);	
	}
	
	
	//get subtotal 
	public WebElement subTotal(){
		return GetElements.getElementByXpath(CartElements.subtotalValue.locator, super.driver);
	}
	
	
	//get itemTotal 
	public WebElement itemTotal(){
		return GetElements.getElementByXpath(CartElements.itemTotal.locator, super.driver); 
	} 
	
	public String itemTotalString(){
		return itemTotal().getAttribute("value"); 
	}
	
	public double itemTotalNumeric(){
		String itTot = itemTotalString();
		double itTot2 = Float.parseFloat("itTot");
		return itTot2;
	}
	
	
	
	//get estimatedTotal 
	public WebElement estimatedTotal(){
		return GetElements.getElementByXpath(CartElements.estimatedTotal.locator, super.driver);
	}
	
	public double estimatedTotalNumeric(){
		String estTot = estimatedTotal().getAttribute("value");
		double estTotD = Float.parseFloat("estTot"); 
		return estTotD;
	}
	
	
	//get approximate shipping cost 
	public WebElement shippingCost(){
		return GetElements.getElementByXpath(CartElements.shippingValue.locator, super.driver);
	}
	
	
	//get salesTax info 
	public WebElement salesTax(){
		return GetElements.getElementByXpath(CartElements.salesTax.locator, super.driver);
	}
	
	public double salesTaxNumeric(){
		String tax = salesTax().getAttribute("value"); 
		double salesTax = Float.parseFloat("tax"); 
		return salesTax;
	}
	
	
	//get product-details from 2nd cell in [each] row of cart-table; 
	
	
	
		 
	
	
	//get checkOut button 
	public WebElement startCheckoutButton(){
		return GetElements.getElementByName(CartElements.checkoutButton.locator, super.driver);
	}
	

	
	
	
	

}
