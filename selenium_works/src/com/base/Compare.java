package com.base;

public class Compare {
	
	
	String readPath = ""; 
	String writePath = ""; 
	 
	
	public boolean lengthCheck( String var01, String var02 ){
		
    	int readSize = readPath.length();
    	int writeSize = writePath.length(); 
    	int diff = readSize - writeSize; 
    	if(diff > 0){
    		// test will fail 
    	}
		return false; //just a place holder 
	}
	
	
}
