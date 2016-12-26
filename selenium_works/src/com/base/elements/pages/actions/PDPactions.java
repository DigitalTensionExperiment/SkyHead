package com.base.elements.pages.actions;

import static org.junit.Assert.assertEquals;
import com.base.elements.pages.PDP;
import com.base.elements.pages.Homepage; 



public class PDPactions  {
	
	//PDP pdp;
	Homepage home;
	
	//go to PDP page and check it's title: 
	public void arriveAtPDP(PDP pdp){ 
		pdp = new PDP(home.driver);
		System.out.println("Current page: " + pdp.title()); 
	}
	
	//check if cart is empty from PDP page: (might not be necessary)
	public void isCartEmpty(PDP pdp){ 
		pdp = new PDP(home.driver);
		assertEquals(pdp.isCartEmpty(),true);
	}
	
	
	//check for swatches on page: 
	public void C_swatchCheck(PDP pdp){ 
		pdp = new PDP(home.driver);
		assertEquals(pdp.swatchesNotPresent(),true);
	}
	
	
	//check if add-to-cart button is available: 
	public void AddToCartButtonCheck(PDP pdp){ 
		pdp = new PDP(home.driver);
		assertEquals(pdp.buttonActive(),true);
	}
	
	
	//click add-to-cart button 
	public void E_addItemToCart(PDP pdp){ 
		pdp = new PDP(home.driver);
		assertEquals(pdp.buttonActive(),true); 
		pdp.addToCartButton().click();	//	add item to cart 
	}
	
	
	
	
	
	
}
