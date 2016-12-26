package com.base.elements;

public enum CartElements {
	
	headerText("Your Shopping Cart"),
	
	cartTable("cart-table"),
	cartRows("//table[@id='cart-table']/tbody/tr"),
	cells("//table[@id='cart-table']/tbody/tr/td"),
	
	itemImageCell("//table[@id='cart-table']/tbody/tr/td[1]"),
	itemDetailsCell("//table[@id='cart-table']/tbody/tr/td[2]"),
	itemQuantityCell("//table[@id='cart-table']/tbody/tr/td[3]"), 
	availabilityInfoCell("//table[@id='cart-table']/tbody/tr/td[4]"), 
	//inventoryInfo(""),
	itemPriceCell("//table[@id='cart-table']/tbody/tr/td[5]"), 
	unitPrice(""),
	itemTotalCell("//table[@id='cart-table']/tbody/tr/td[6]"), 
	
	itemTotal("//span[@class='price-total']"),
	
	itemNoPerCartRow("//div[@class='sku']/span[@class='value']"),
	productNameCart("//div[@class='product-list-item']/div[@class='name']/a"),
	
	//INVENTORY CLASSES
	inStock("//*[contains(@class,'is-in-stock')]"), 
	
	quantitySingleRow("//input[contains(@name,'quantity')]"),
	quantityMultipleRows("//table[@id='cart-table']/tbody/tr/td[3]/input"),
	
	orderTotals("//div[@class='cart-order-totals']"), 
	updateCartButton("update-cart"),
	orderTotalsTable("//table[@class='order-totals-table']"), 
	orderTableRows("//table[@class='order-totals-table']/tbody/tr"),
	subtotalRow(""),
	subtotalValue(""),
	shippingTotalRow(""), 
	shippingValue(""),
	
	salesTaxRow(""),
	salesTax(""),
	estimatedTotalRow(""),
	estimatedTotal(""), 
	
	continueShopping(""), 
	//checkoutButton("//fieldset/button[contains(@name,'checkoutCart')]");    
	checkoutButton("dwfrm_cart_checkoutCart"); //name
	
	
	public String locator;
	
	private CartElements(String locator){
		this.locator = locator;
	}

}
