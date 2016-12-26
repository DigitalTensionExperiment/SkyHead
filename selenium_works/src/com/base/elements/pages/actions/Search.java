package com.base.elements.pages.actions;

import static org.junit.Assert.assertEquals;

import com.base.elements.pages.Homepage;

public class Search {
	
//	public static String searchFilterSmall = "P0138"; 
//	public static String searchFilterLarge = "";
	public static String path;
	
	
	//Confirm that searchTextfield is visible: 
	public static void confirmSearchFieldDisplay(Homepage home){
		assertEquals(home.searchTextfield().isDisplayed(),true);
	} 
	
	
	//RUN BEFORE ENTERING searchTerm: (clears the field)
	public static void clearSearchTerm(Homepage home){
		if(home.readSearchField()!=null){
			home.clearSearchField(); 
		}
	}
	
	
	//DO A SEARCH: 
	public static void search(Homepage home, String searchFilter){ 
		// Enter a search term 
		home.writeSearchField(searchFilter); 
		// click the Go button 
		home.searchGoButton().click(); 
		// check the URL 
		path = home.driver.getCurrentUrl();
	} 
	
	
	

	
	
	
	
}
