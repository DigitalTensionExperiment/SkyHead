package com.base.elements.pages;

import com.base.GetElements;
import com.base.elements.BasePageElements;
import com.base.elements.PDPelements;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * 
 * @author zareenwilhelm 
 * This class contains methods that are supposed to get all elements found on a PDP page; 
 *
 */


public class PDP extends BasePage{

	public PDP(WebDriver driver) {
		super(driver);
	}
	
	
	//BaseElements pdp = new BaseElements(this.driver); 
	BasePageElements bpe; 
	protected List<WebElement> swatches;
	
	
	//go to a PDP and get page title 
	public String pageTitle(){ 
		//driver.get(pdpURL);
		return driver.getTitle(); 
	}
	
	
	
	
	//check for PRIMARY IMAGE
	public WebElement primaryImage(){
		return GetElements.getElementByXpath(PDPelements.primaryImage.locator, super.driver);
	}
	
	//check that primary image is present 
	public boolean primaryImgPresent(){
		return primaryImage().isDisplayed(); 
	}
	
	
	
	
	//ALTERNATE VIEW CAROUSEL: 
	public WebElement altViewsCarousel(){
		return GetElements.getElementByID("thumbnails", super.driver);
	}
	
	
	//LIST OF ALL ALTERNATE VIEWS:
	public List<WebElement> altViews(){
		return GetElements.elementLists("//ul[@id='thumbnails']/li", super.driver);
	}
	
	
	
	//PRODUCT CONTENT
	public WebElement productContent(){
		//return pdp.getElementByID("product-content"); 
		return GetElements.getElementByXpath("//div[@id='product-content']", super.driver);
	}
	
	
	
	//PRODUCT DESCRIPTION 
	//		xpath("//div[@class='product-tabs ui-tabs ui-widget ui-widget-content ui-corner-all']") 
	public WebElement descript(){
		return GetElements.getElementByXpath(PDPelements.description.locator, super.driver);
	}
	
	
	
	//get product availability 
	public WebElement inventoryInfo(){
		return GetElements.getElementByXpath(PDPelements.availability.locator, super.driver);
	}
	
	
	//itemNo#
	public WebElement itemNo(){
		return GetElements.getElementByXpath(PDPelements.itemNo.locator, super.driver);
	}
	//	class='product-number' > return String itemNo 
	//Some sites will have a productID appear several times: count it
	//^Should all these elements be returned as a list, and then checked for list.size() > 1 ? 
	
	
	public boolean itemNoPresent(){
		return itemNo().isDisplayed();
	}
	
	public boolean itemNumber(){
		return itemNo().isDisplayed();
	}
	
	public String itemNoLiteral(){
		return itemNo().getText();
	}
	
	
	
	
	//PRODUCT NAME
	public WebElement productName(){
		return GetElements.getElementByXpath(PDPelements.productName.locator, super.driver); 
	}
	
	public boolean productNameVisible(){ 
		return productName().isDisplayed();
	}
	
	public String productNameLiteral(){ 
        return productName().getText();
	} 
	
	
	
	//PRODUCT PRICE
	public WebElement unitPrice(){
		return GetElements.getElementByXpath(PDPelements.unitPrice.locator, super.driver);
	}
	
	public boolean unitPriceVisible(){
		return unitPrice().isDisplayed();
	}
	
	public String unitPriceString(){
		return unitPrice().getText();
	}
	
	public double unitPriceNumeric(){ 
		String price = unitPriceString();
		double unitPrice = Float.parseFloat("price");  //	THIS DOESN'T WORK YET
		return unitPrice;
	}
	//	class='product-price' > return double unitPrice
	//How does a WebElement get converted to a double? 
	
	
	
	
	
	//QTY - the label and the box 
	public WebElement quantityBox(){
		return GetElements.getElementByXpath("//div[@class='quantity']", super.driver); 
	}
	
	//ACTION: check if qty is a textbox or a DD
	public WebElement qty(){
		return GetElements.getElementByID(PDPelements.quantity.locator, super.driver); 
	}
	
	//check if qty box is present 
	public boolean qtyBoxPresent(){
		return quantityBox().isDisplayed();
	}
		
		
	//check if Qty is a textfield or a DDmenu 
	//		if the following returns true,  then Qty is input textfield 
	public boolean qtyTypeTextfieldCheck(){
		return qty().isDisplayed();
	}
	//if returns false: Qty is a DDmenu 
		
		
	//if qtyType=true:  
	public void qtyTextInput(String string){ 
		qty().clear();
		qty().sendKeys(string); 
	}
	//i really want x to be an int
		
		
	//read input Qty value (give that its a textfield) 
	public String readQtyInputText(){
		return qty().getAttribute("value");
	}
	//turn this value into an int
	
		
	//check # of items in cart (must get compared to Qty value) 
	public String readQtyDDselected(){
		return qty().getText();
	}
	//turn this value into an int
	
	
	
	
	
	
	//get list of all swatches 
	public List<WebElement> swatches(){
		return swatches = GetElements.elementLists("//*[contains(@class,'swatches')]", super.driver);
	}

	//check if NO swatches are on PDP  
	public boolean swatchesNotPresent(){
		return swatches().isEmpty();
	}
	
	
	
	
	
	//ADD-TO-CART BUTTON 
	public WebElement addToCartButton(){
		return GetElements.getElementByID(PDPelements.addToCartButton.locator, super.driver); 
	}
	
	//addToCartButton 
	public boolean buttonPresent(){
		return addToCartButton().isDisplayed();
	}

	//check if add-to-cart button is disabled or not 
	public boolean buttonActive(){
		return addToCartButton().isEnabled();
	}
	
	
	
	
	
	
	public WebElement getMiniCart(){
		return GetElements.getElementByCSS(BasePageElements.miniCart.locator, super.driver);
		//return pdp.getElementByXpath("//a[@class='mini-cart-link']");
	} 
	
	public boolean minicartLives(){
		return getMiniCart().isDisplayed();
	}
	
	public void goToMiniCart(){
		getMiniCart().click();  
	}
	
	
	
	
	
	

}
