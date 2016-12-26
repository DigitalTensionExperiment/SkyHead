package com.base.testSuites;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import junit.framework.JUnit4TestAdapter;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.JUnitCore;
//import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.junit.runners.MethodSorters;
import com.base.BaseTest;
import com.base.elements.pages.Billing;
import com.base.elements.pages.Cart;
import com.base.elements.pages.CheckoutLogin;
import com.base.elements.pages.Homepage;
import com.base.elements.pages.PDP;
import com.base.elements.pages.PlaceOrder;
import com.base.elements.pages.Shipping;
import com.base.elements.pages.actions.Search;
import com.inflectra.spiratest.addons.junitextension.SpiraTestConfiguration;
import com.inflectra.spiratest.addons.junitextension.SpiraTestListener;


@SpiraTestConfiguration(
		url="https://mediahive.spiraservice.net",
		login="administrator",
		password="=[>7vbhi)z6uYN",
		projectId=12,
		releaseId=-1,  
		testSetId=-1   
	)


@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestSuite0 extends BaseTest {  // extends BasePageTest {
	
	
	
	//READ THIS: 	http://selenium-suresh.blogspot.com/2013/09/selenium-webdriver-methods-with-examples.html
	
	static PDP pdp; 
	static Cart cart; 
	static CheckoutLogin chLg; 
	static Shipping ship; 
	static Billing bill; 
	static PlaceOrder buy;
	static String path = "/s/SiteGenesis/home"; 
	static String path2 = "/s/SiteGenesis/cart";
	static Homepage home; 
	String searchFilter = "P0138"; 	//*	readCSV( orderSize );
	static Select select;
	
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
	
	
	

//	public void searchTests(): 
	@Test 
	public void A0_searchTextfieldVisible(){ 
		Search.confirmSearchFieldDisplay(home);
	} 
////	
////	
	@Test 
	public void A1_clearSearchTerm(){
		Search.clearSearchTerm(home);
	} 
//	
//	
	@Test 
	public void A2_goToPDPbySearch(){ 
		Search.search(home,searchFilter);
	} 
//	
//	
	@Test  		//	arrive at PDP (based on orderSize) 
	public void A3_arriveAtPDP(){ 
		pdp = new PDP(home.driver); 
		System.out.println("Current page: " + pdp.title()); 
		System.out.println("Current page: " + driver.getCurrentUrl()); 
	}
	//If pageTitle = productName: result(searchTest) = Pass;  
	
	
	
	
	@Test 		//	expecting cart to be empty 
	public void B_isCartEmpty(){
		assertEquals(pdp.isCartEmpty(),true);
		//assertEquals(pdp.miniCartLinkDisplay(),false);
	}
	
	
	
	

	//			determine #/items currently in cart 
	
	
	
	//	check if Qty = textField or DDmenu 
	//		if textField: writeQtyValu();  
	//		else:	selectQtyValue();
	
	
	@Test 
	public void C0_swatchCheck(){	
		assertEquals(pdp.swatchesNotPresent(),true);	//confirm that swatches are not present
	}
	
	
//	public void gear(){
//	if(pdp.swatchesPresent()==true){		//		if swatches = 1: 
////			determine element type of swatches (checkbox, DDmenu, etc.) 
////			addToCartButtonActive() - is add-to-cart button active? (ER: false)
////			select swatches 
////			addToCartButtonActive() - is add-to-cart button active? (ER: true) 
////			add item to cart 
//	}
//}

	
	
	@Test 
	public void C1_addToCartButtonCheck(){
		assertEquals(pdp.buttonActive(),true); 			//confrim that add-to-cart button is still active 
	}
	
	
	@Test 
	public void C2_addItemCheckMinicart(){
		pdp.addToCartButton().click(); 					//add item to the cart 
		try {
			Thread.sleep(3000);							//wait 3sec
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		assertEquals(pdp.isCartEmpty(),false);			//check to make sure that cart is not longer empty
	}
	
	
	@Test 
	public void D0_goToCart(){
		pdp.goToMiniCart(); 							//go to cart
		System.out.println(cart.title());				//confirm arrival to cart 
		System.out.println(driver.getCurrentUrl());		//check URL
	}
	
	
	//	Confirms that no swatches are on page:  
	@Test
	public void D1_beginCheckoutProcess(){ 
		
		cart = new Cart(home.driver); 
				
		
	//* writeCSV:	
	//		itemNo 
	//		productName 
	//		unitPrice 
	//		description 
	//		inventory 
	//		swatchInfo
	
	//	compare(itemNo, productName, inventory, swatchInfo, unitPrice, Qty) -  
	//*		readCSV( itemNo, productName, inventory, swatchInfo, unitPrice, Qty ); 
	//		getValuesFromPage( itemNo, productName, inventory, swatchInfo, unitPrice, Qty ); 
	//		compare; 
		
	//* readCSV( useUpdateButton = 0/1 ) 
	//		Qty : Inventory;  
	//		Qty * unitPrice : itemTotal, estimatedTotal; 
	//		var = diff( subtotal, estimatedToal )
	//* writeCSV:	
	//		var 
	//		salesTax 
	//		<other> 
	//	begin checkout process 
		
			
		
		assertEquals(cart.startCheckoutButton().isDisplayed(),true); 
		cart.startCheckoutButton().click();
		System.out.println(driver.getCurrentUrl()); 
	}
	
	
	
	@Test 
	public void D2_shopperTypeIdentifier(){
		
		chLg = new CheckoutLogin(home.driver);
		
		
	//*	readCSV( shopperType ) 
	//		if(shopperType = login): 
	//*			readCSV( useremail, password ): login(useremail,password);   
	//		elseif (shopperType = createNewAccount): 
	//			...go through registration steps... 
	//		else 
	//			selectGuestOption(); 
		assertEquals(chLg.guestButton().isDisplayed(),true);
		chLg.guestButton().click(); 
		System.out.println(driver.getCurrentUrl()); 	//		arrive @ shippingPage 
		System.out.println(chLg.title());	//"SiteGenesis Checkout" = shippingPage 
	}
	
	
	
	
	@Test 
	public void E_checkoutProcess(){
		
		
		
		ship = new Shipping(home.driver);
	
		
	//	get all required fields 
		//System.out.println("This might be a list [of required fields]: " + ship.reqFields());
		//It IS a list, but not in the needed format
		
		
		assertEquals(ship.firstPresent(),true); 
		//System.out.println("read0> " + ship.firstRead()); 
		ship.firstWrite("John"); 
		//System.out.println("fieldRead: " + ship.firstRead());
		
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
		
		
		//this is just for play
		System.out.println(ship.firstRead());
		System.out.println(ship.lastRead());
		System.out.println(ship.address1Read()); 
		System.out.println(ship.countryRead()); 
		System.out.println(ship.stateRead());
		System.out.println(ship.cityRead()); 
		System.out.println(ship.zipRead());
		System.out.println(ship.phoneRead()); 
		
		
		
		assertEquals(ship.sbaSelected(),false); 
		ship.sbaApply(); 
		assertEquals(ship.sbaSelected(),true);  //HERE we selected the same address for Billing: go to billing and check
		
		
		
		
		//BEFORE MOVING TO BILLING: 
		//		must checkout shipping methods 
		//		figure out a selection-and-check process for radioButtons 
		//		and store $info regarding the selected method 
		
		
		
		
		
		//THE FOLLOWING CHUNK MAKES SURE THAT WE MOVE FROM Shipping TO Billing SUCCESSFULLY: 
		
		System.out.println(driver.getCurrentUrl()); //A
		
		assertEquals(ship.continueButtonPresent(),true); 
		ship.continueToBilling();
		try {
			Thread.sleep(1200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(driver.getCurrentUrl()); //B   > if(B != A): testResult = pass; 
		
		
		
		
		
	//	compare(itemNo, productName, inventory, swatchInfo, unitPrice) 
	//	for( shopperType != guest ): 
	//		check for savedAddressDDElementPresent(); 
	//		if( savedAddressDDElementPresent() = 1 ): 
	//			...use saved address... 
	//		else: 
	//*			readCSV( address1, country, state, city, zip, phone, email ): fill address form;
	//	check that all required address fields are filled
	//		read all req textFields 
	//	if( (textFieldContent = null) && (field = required) ): 
	//		...insert value into textField... 
	//	check for all DDmenus:
	//		store DDlabel
	//		store all DDoptions: listName = DDlable[i] 
	//		Logs.DDoptionUseTracker() 
	//	check that all required fields are filled 
	//	get all shipping methods: list[] 
	//*	readCSV( shippingMethod ): 
	//		compare(shippingMethod, list[i]) 
	//		if values match: select shippingType = list[i] 
	//		else: ...select one of the available options...  
	//*	readCSV( shippingAddbillingAdd ): check (1) or not-select (0) this option 
	//*	writeCSV( selectedShippingMethod, shippingMethodCost ) 
	
		
		
	//	go to Billing 
		
		bill = new Billing(home.driver); 
		
		//We set sbaSelected() = true: therefore, read the address fields in billing page: 
		System.out.println(bill.firstBillRead());
		System.out.println(bill.lastBillRead());
		System.out.println(bill.add1BillRead());
		System.out.println(bill.countryBillRead());
		System.out.println(bill.stateBillRead());
		System.out.println(bill.cityBillRead());
		System.out.println(bill.zipBillRead());
		System.out.println(bill.phoneBillRead());
		System.out.println(bill.emailBillRead());
		
		bill.emailBillWrite("zareen.wilhelm@mediahive.com"); 
		System.out.println(bill.emailBillRead()); 
		
		//make sure CCoption is selected: 
		assertEquals(bill.ccOptionPresent(),true);
		
		System.out.println(bill.cardTypeRead());
		System.out.println(bill.cardExpMnthRead()); 
		System.out.println(bill.cardExpYrRead()); 
		
		//assertEquals(bill.cardTypeDDPresent(),true);
		bill.cardTypeSelect("MasterCard"); 
		bill.cardNoWrite("5555555555554444");
		bill.ccNameWrite("Master Card"); 
		//bill.cardExpMnthSelect();
		bill.cardExpYrSelect("2018"); 
		bill.cvnFieldWrite("452");
		
		System.out.println(driver.getCurrentUrl()); 
		//assertEquals(bill.continueButtonPresent(),true);
		bill.continueToPlaceOrder();
		System.out.println(driver.getCurrentUrl());
		
		
		buy = new PlaceOrder(home.driver);
		
		
		assertEquals(buy.cartTablePresent(),true); 
		assertEquals(buy.buyButtonCheck(),true); 
		
		System.out.println(driver.getCurrentUrl()); 
		buy.purchase();
		System.out.println(driver.getCurrentUrl());
		
		
		
		
		
	//*	readCSV( shippingAddbillingAdd ): 
	//		if( shippingAddbillingAdd = 1 ): read textFields and compare(...); 
	//		else: 
	//			check if savedAddressElementPresent = 1 ; 
	//			if(savedAddressElementPresent = 1): select an option; read fields; 
	//			else: 
	//*				readCSV(address1, country, state, city, zip, etc.); 				
	//	confirm payment methods elements present
	//*	readCSV( paymentMethod ): select paymentMethod
	//	if( selectedPaymentMethod = CC ): 
	//		check for saved CC 
	//		get all required fields; read required fields; 
	//		if(savedCC = 1): store all CCtype options, store selectedCCtype; read required fields; 
	//		else: 
	//*			readCSV( nameOnCC, CCtype, CCnumber, ExpMnth, ExpYr, Sec ): fill required fields; 
	//	check all form elements present 
	//	get all required fields are filled 
	//	compare(itemNo, productName, inventory, swatchInfo, unitPrice, Qty)
	//	go to OrderPlacement 
	
	//	arrive @ orderPlacement 
	//	compare(itemNo, productName, inventory, swatchInfo, unitPrice, Qty, totalPrice, shippingMethod, shippingAddress, shippingCost, paymentMethod, paymentMethodInfo); 
	//	place order 
	
	//	arrive @ orderConfirmationPage 
	//	writeCSV( orderNumber ) 
	
	
	
	
	
	

	}
	
	
	
	@AfterClass 
	public static void teardown(){
		complete();
	}
	
	
	
	

	public static void main(String[] args) {
		
		//BasePage bp; 
		//String searchFilter;  //* readCSV( searchFilter )
		//Homepage home; 
		//CheckHomepageTitle hpt;
		//String title;  
		//String expectedTitle = "SiteGenesis Online Store";
		JUnitCore core = new JUnitCore();
		// go to homepage 

				//Add the custom SpiraTest listener
		core.addListener(new SpiraTestListener());

				//Finally run the test fixture
		core.run(TestSuite0.class);
	}

	
	
	public static junit.framework.Test suite() 
	{
		return new JUnit4TestAdapter(TestSuite0.class);
	}
		
	
	
	
}
