package com.base.testData;

public enum TestSuite0TestData {
	
	orderSizePDP(""),
	//	large:		/s/SiteGenesis/electronics/televisions/flat screen/pioneer-pdp-6010fd.html#start=6
	//	small:		/s/SiteGenesis/mens/accessories/luggage/P0138.html 	
	smallOrder("/s/SiteGenesis/mens/accessories/luggage/P0138.html"), 
	largeOrder("/s/SiteGenesis/electronics/televisions/flat screen/pioneer-pdp-6010fd.html#start=6"),
	
	shopperType(""),
	//	guest 
	//	login
	
	userEmail(""), 
	password("")
	
	
	
	;
	
	
	public String value;
	
	private TestSuite0TestData(String value){
		this.value = value;
	}
	
	public String getTDvalue(){
		return this.value;
	}
	
	
	
	
}
