package com.base.testSuites;

import static org.junit.Assert.assertEquals;






//import java.util.ArrayList;
//import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.support.ui.Select;

import com.base.BaseTest;
import com.base.elements.pages.Billing;
import com.base.elements.pages.Cart;
import com.base.elements.pages.CheckoutLogin;
import com.base.elements.pages.Homepage;
import com.base.elements.pages.Login;
import com.base.elements.pages.OrderConfirmation;
import com.base.elements.pages.PDP; 
import com.base.elements.pages.PlaceOrder;
import com.base.elements.pages.Shipping;
import com.base.elements.pages.actions.Search;
//import com.base.elements.pages.actions.Search;
import com.base.testData.*;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Scrap extends BaseTest {
	
	static Login login;
	static OrderConfirmation oc;
	static PlaceOrder buy;
	static Billing bill;
	static Shipping ship;
	static CheckoutLogin chLg;
	static Cart cart;
	static PDP pdp;
	//static String path = "/s/SiteGenesis/mens/accessories/luggage/P0138.html";
	static String path = "/s/SiteGenesis/home";
	static Homepage home; 
	String searchFilterSmall = "P0138"; 	
	String searchFilterLarge = "pioneer-pdp-6010fd"; 
	static Select select;
	
	
	String itemNo, productName, unitPrice; 
	String itemNoCart, productNameCart;
	int qty;
	double itemTotal; 
	//boolean inventoryCheck ; 
	double salesTaxCart; 
	double estimatedTotal;
	
	
	String orderSize, shopperType, stateType, sbaDecision;
	
	
	
	@BeforeClass
	public static void setup(){
		runHeadless();
		urlLaunch(path); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		home = new Homepage(driver); 
	}
	
	
	
	@Before
	public void betweenTests(){
		
		
	}
	
	
	@Test
	public void E2Ebasic(){
		
		orderSize = "small";
		
		//check that cart is empty 
		//assertEquals(pdp.isCartEmpty(),true);   <- NOT WORKING (possibly not necessary)
		
		
		//System.out.println("Current page: " + pdp.title()); 
		System.out.println("Current page: " + driver.getCurrentUrl()); 
		
		
		//go to PDP 
		if(orderSize != null && orderSize =="small"){
//			home.writeSearchField(TestSuite0TestData.smallOrder.value);
//			System.out.println("Current page: " + driver.getCurrentUrl()); 
			Search.search(home, searchFilterSmall);
		} else {
//			home.writeSearchField(TestSuite0TestData.largeOrder.value);
//			System.out.println("Current page: " + driver.getCurrentUrl()); 
			Search.search(home, searchFilterLarge);
		}
		
		 
	
		
		
		/////////////////////////// PDP /////////////////////////////////////

		
		pdp = new PDP(home.driver);
		
		//confirm PDP page 
		System.out.println("Current page: " + pdp.title()); 
		System.out.println("Current page: " + driver.getCurrentUrl());
		
		
		
		//swatchManagement 
		assertEquals(pdp.swatchesNotPresent(),true);
		
		
		//button check 
		assertEquals(pdp.buttonActive(),true);
		
		
		//add item to cart 
		pdp.addToCartButton().click(); 
		
		
		
		//READ:	itemNo, productName, unitPrice 
		assertEquals(pdp.itemNoPresent(),true);
		itemNo = pdp.itemNoLiteral(); 
		System.out.println(itemNo);
		
		assertEquals(pdp.productNameVisible(),true);
		productName = pdp.productNameLiteral(); 
		System.out.println(productName);
		
		assertEquals(pdp.unitPriceVisible(),true); 
		unitPrice = pdp.unitPriceString(); 
		System.out.println(pdp.unitPriceString());
//		System.out.println(pdp.unitPriceNumeric());    <-- DOES NOT WORK YET
		
		//assertEquals(searchFilter,itemNo);
		
		
		//go to Cart
		pdp.goToMiniCart(); 
		
	
	
		
		/////////////////////////// CART /////////////////////////////////////
		
		
		cart = new Cart(home.driver); 
		
		//confirm Cart 
		System.out.println(cart.title());				
		System.out.println(driver.getCurrentUrl());
		
		assertEquals(cart.cartTableVisible(),true);
//		if(cart.cartTableVisible()==true){
//			System.out.println("Cart-table is visible;");
//		}
		
		
		
		//READ: itemNoCart, productNameCart, qty, inventoryCheck 
		
		assertEquals(cart.itemNoCartPresent(),true);
		itemNoCart = cart.itemNoCartString(); 
		System.out.println(itemNoCart);
		
		assertEquals(cart.productNameCartVisible(),true); 
		productNameCart = cart.productNameCartString();
		System.out.println(productNameCart);
		
		//qty = ...store the qty value (@ each cartRow)...;
		
		//inventoryCheck = cart.inventoryCheckInStock(); 
		//assertEquals(cart.inventoryCheckInStock(),true); 
		
		
//		salesTaxCart = cart.salesTaxNumeric();
//		estimatedTotal = cart.estimatedTotalNumeric();
//		itemTotal = cart.itemTotalNumeric();
		
		
		
		//double x = qty * unitPrice;
		//assertEquals(x,itemTotal,0.001);
		
		
		
		
		//COMPARE: ... 
		
		
		
		
		//start checkout 
		assertEquals(cart.startCheckoutButton().isDisplayed(),true); 
		cart.startCheckoutButton().click();
		
		
		
		
		/////////////////////////// CHECKOUTLOGIN /////////////////////////////////////
		
		chLg = new CheckoutLogin(home.driver);
		shopperType = "login";
		//login = new Login(home.driver);
		
		//confirm checkoutLoging page 
		//System.out.println(driver.getCurrentUrl()); 
		
		
		
		//TestSuite0TestData.shopperType.value
		
		if(shopperType != null && shopperType == "guest"){
			chLg.guestButton().click();  
		} else {
			//login.login("loneshopper@home.com", "8255characters"); 
			chLg.loginEmail().sendKeys("loneshopper@home.com");
			chLg.loginPassword().sendKeys("8255characters"); 
			System.out.println(driver.getCurrentUrl()); 
			chLg.loginButton().click(); 
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//8255characters
		
		/////////////////////////// SHIPPING /////////////////////////////////////
		
		ship = new Shipping(home.driver);
		sbaDecision = "1";
		
		
		//confirm shippingPage 
		System.out.println(driver.getCurrentUrl()); 	
		//System.out.println(chLg.title());
		
		
		
		//	addressFormFill(): 
//		if(stateType != null && stateType == "nexus"){
//			// shippingAddress(nexus); 
//		} else {
//			// shippingAddress(nonNexus); 
//		}
		
		
		
		
		
		
		
		assertEquals(ship.firstPresent(),true); 
		ship.firstWrite("John"); 
		
		assertEquals(ship.lastPresent(),true); 
		ship.lastWrite("Denver"); 
		
		assertEquals(ship.address1Present(),true); 
		ship.address1Write("1132 38th St.");
		
		assertEquals(ship.countryPresent(),true); 
		System.out.println(ship.allCountriesTotal()); 
		ship.selectCountry("United States"); 
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		System.out.println(ship.countryRead()); 

		assertEquals(ship.statePresent(),true); 
		System.out.println(ship.allStatesTotal());  
		ship.selectState("Alaska"); 
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		System.out.println(ship.stateRead());
		
		assertEquals(ship.cityPresent(),true); 
		ship.cityWrite("Juneau"); 
		
		assertEquals(ship.zipPresent(),true); 
		ship.zipWrite("99801");
		
		assertEquals(ship.phonePresent(),true);
		ship.phoneWrite(); //hardcoded
		
		
		
	
		//sbaSelect();
		assertEquals(ship.sbaSelected(),false); //initialRead
		
		
		if(sbaDecision != null && sbaDecision == "1"){
			ship.sbaApply();  
			assertEquals(ship.sbaSelected(),true); 
		} 
		
		
		
		//ShippingMethodStuff: 
		//	if([] = ...){
		//		shipmentMethod = 001; 
		//		... 
		//	} else { 
		//		...
		//	}
		
		//READ: shippingCost
		
		
		//assertEquals(ship.continueButtonPresent(),true); 
		//ship.continueToBilling();
		
		System.out.println(driver.getCurrentUrl()); //A
		
		assertEquals(ship.continueButtonPresent(),true); 
		ship.continueToBilling();
		try {
			Thread.sleep(1200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(driver.getCurrentUrl());
		
		
		
		
		/////////////////////////// BILLING /////////////////////////////////////
		
		bill = new Billing(home.driver); 
	
	
		//confirm billing page 
		System.out.println(home.pageTitle()); 
		System.out.println(driver.getCurrentUrl()); 
		
		
		//sbaValueCheck(): 
		if(sbaDecision != null && sbaDecision == "1"){
			//  checkBillingAddress(); 
			//bill.emailBillWrite("zareen.wilhelm@mediahive.com"); 
		} 
//			else {
//			
//			if(stateType != null && stateType == "nexus"){
//				//  billingAddress(nexus); 
//			} else {
//				//  billingAddress(nonNexus);
//			}
//			
//		}
		
		
		//For temporary use only: 
//		System.out.println(bill.lastBillRead());
//		System.out.println(bill.add1BillRead());
//		System.out.println(bill.countryBillRead());
//		System.out.println(bill.stateBillRead());
//		System.out.println(bill.cityBillRead());
//		System.out.println(bill.zipBillRead());
//		System.out.println(bill.phoneBillRead());
		System.out.println(bill.emailBillRead());
			
		
		
		if(bill.savedCCpresent() == true){
			System.out.println("Saved cards are available.");
		} else {
			System.out.println("No saved cards are available.");
		}
					
					
		//paymentMethodStuff(); 
		assertEquals(bill.ccOptionPresent(),true); 
					
		bill.cardTypeSelect("MasterCard"); 
		bill.cardNoWrite("5555555555554444");
		bill.ccNameWrite("Master Card"); 
		bill.cardExpYrSelect("2018"); 
		bill.cvnFieldWrite("452");
		
		
		
		//go to PlaceOrder
		bill.continueToPlaceOrder();
		
	
		/////////////////////////// PLACE_ORDER /////////////////////////////////////
		
		buy = new PlaceOrder(home.driver);
		
		//confirm placeOrder page 
		System.out.println(driver.getCurrentUrl());
		
		
		//READ: ... 
		//COMPARE: ...
	
		//buy(); 
		assertEquals(buy.buyButtonCheck(),true); 
		buy.buyButton().click();
		//buy.purchase();
	
	
		/////////////////////////// ORDER_CONFIRMATION /////////////////////////////////////
		
		oc = new OrderConfirmation(home.driver);
	
		//confirm orderConfirmation 
		System.out.println(driver.getCurrentUrl());
		
		
	
		//READ: orderNo 
		System.out.println("Order number: " + oc.orderNumber().getText());
		
		
		
		
		
	
	
	
	}
	
	
	
	@AfterClass 
	public static void teardown(){
		complete();
	}
	
}


