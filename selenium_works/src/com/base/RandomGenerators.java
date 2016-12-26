package com.base;

import java.util.Random;


public class RandomGenerators {
	
	
	//remove all "static" after removing main():
	
	
	static Random rand = new Random(); 
	
	//number address1 
	public static int numberGen(int range){
		return rand.nextInt(range);
	}
	
	
	
	//firstName, lastName, streetName
	public static String generateString(String characters, int length)
	{
	    char[] text = new char[length];
	    for (int i = 0; i < length; i++)
	    {
	        text[i] = characters.charAt(rand.nextInt(characters.length()));
	    }
	    return new String(text);
	}
	

	
	//generate alphaNumeric strings 
	
	
	
	//generate phone number
	
	
	
	//random street address generator 
	
	
	
	//generate email address
	public static String emailGen(){ 
		String letter = "frgtfrgtfrgt";  
		String preAt01 = generateString(letter,5); 
		Integer preAt02 = numberGen(999); 
		String preAt = preAt01 + preAt02.toString(); 
		String email = preAt + "@email.com"; 
		return email;
	}
	
	
	//generate password 
	public static String passwordGen(int length){
		return generateString("q1w2e3r4t5y6u7i8o9plkjhgfdsazxcvbm0n",length);
	}
	
	
	
	public static final void main(String... aArgs){
		 
		 log("Generating 10 random integers in range 0..99.");
		    
		 //note a single Random object is reused here
//		 Random randomGenerator = new Random();
//		 for (int idx = 1; idx <= 10; ++idx){
//		   int randomInt = randomGenerator.nextInt(100);
//		   log("Generated : " + randomInt);
//		 }
		 
		 System.out.println(generateString("a76bdfj8349",10));
		 System.out.println(emailGen()); 
		 System.out.println(passwordGen(14));
		 System.out.println(numberGen(999));
		    
		 log("Done.");
	}
	
	 
	private static void log(String aMessage){
	    System.out.println(aMessage);
	}
	
	
}
