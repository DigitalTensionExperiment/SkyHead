package com.base.elements;

public enum GiftRegistryElements {
	
	//GIFT REGISTRY LOGIN PAGE: 
	registryLoginURL(""),
	loginPageHeader(""),
	
	//shopperType = returningCustomer() 
	loginEmail("//input[contains(@id,'login_username')]"), 
	loginPassword("//input[contains(@id,'login_password')]"),
	rememberMe("//input[contains(@id,'login_rememberme')]"),
	loginButton("//button[contains(@name,'login_login')]"),
	forgotPassword("//a[@id='password-reset']"), 
	
	//shopperType = newCustomer()
	createAccount("//button[contains(@name,'login_register')]"), 
	
	//Find someone's gift registry
	lastName("dwfrm_productlists_search_registrantLastName"),
	firstName("dwfrm_productlists_search_registrantFirstName"),
	eventTypeDD("dwfrm_productlists_search_eventType"), 
	findButton("//button[contains(@name,'productlists')]"), 
	advancedSearch("//div[@class='gift-registry-advanced']/a"),
	
	
	
	//GIFT REGISTRY PAGE
	registryPageHeaderText(""), 
	
	//Find someone's gift registry
	lastName2("dwfrm_productlists_search_registrantLastName"),
	firstName2("dwfrm_productlists_search_registrantFirstName"),
	eventTypeDD2("dwfrm_productlists_search_eventType"), 
	findButton2("//button[contains(@name,'productlists')]"), 
	advancedSearch2("//div[@class='gift-registry-advanced']/a"),
	
	createNewRegistryButton("//button[@name='dwfrm_giftregistry_create']"),
	
	
	//Form 1: 
	eventTypeSelect("dwfrm_giftregistry_event_type"),
	eventName("dwfrm_giftregistry_event_name"),
	eventDate("dwfrm_giftregistry_event_date"),
	eventCountry("dwfrm_giftregistry_event_eventaddress_country"),
	eventState("dwfrm_giftregistry_event_eventaddress_states_state"),
	eventCity("dwfrm_giftregistry_event_town"),
	role("dwfrm_giftregistry_event_participant_role"),
	participantFirstname("dwfrm_giftregistry_event_participant_firstName"),
	participantLastname("dwfrm_giftregistry_event_coParticipant_lastName"),
	participantEmail("dwfrm_giftregistry_event_participant_email"),
	continueButton("//button[contains(@name,'event_confirm')]"),
	
	
	//Form 2: 
	selectSavedAddress("dwfrm_giftregistry_eventaddress_addressBeforeList"),
	preEventFirstname("dwfrm_giftregistry_eventaddress_addressBeforeEvent_firstname"),
	preEventLastname(""),
	preEventAddress1(""),
	preEventCountry(""),
	preEventState(""),
	preEventCity(""),
	preEventZip(""),
	preEventPhone(""),
	
	postEventFirstname(""),
	postEventLastname(""),
	postEventAddress1(""),
	postEventCountry(""),
	postEventState(""),
	postEventCity(""),
	postEventZip(""),
	postEventPhone(""),
	
	continueButton2(""),
	previousButton("")
	
	
	
	//ADD TO GIFT REGISTRY PAGE:
	
	
	;
	
	public String locator;
	
	private GiftRegistryElements(String locator){
		this.locator = locator;
	}
	
}
