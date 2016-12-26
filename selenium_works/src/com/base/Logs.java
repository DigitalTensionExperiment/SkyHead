package com.base;

import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class Logs {
	
	
	BufferedReader read;
    BufferedWriter write;
    
    
    
    public void DDoptionUseTracker(){
    	// confirm presence of a DDmenu 
    	// get all DDoptions: create list 
    	// for(int i=1; i =< list.length(); i++): 
    	//*		readCSV( selectThisOptionFromDD ) > use this value
    	//		read selected Value: store the value/name of selectedOption: writeCSV( selectedOption ) 
    	// compare( selectThisOptionFromDD, selectedOption ) 
    }
    
    
    
    public void RecordAccount(String name, String email){ 
    	
    	try{
    		write = new BufferedWriter (new FileWriter (""));
    		write.write(name + "," + email + "\n");
    		write.close();
    	}catch(Exception e){
    		System.out.println("could not open file");
    	}
    	
    }
    
    public List<String[]> GetData(String filename){
    	String line = "";
    	List<String[]> rowlist = new ArrayList<String[]>();
    	try{
    		read = new BufferedReader(new FileReader (filename));
    		while((line = read.readLine()) != null){
    			String[] data = line.split(",");
    			//do stuff with data
    			rowlist.add(data);    			
    		}
    		read.close();
    	}catch(Exception e){
    		System.out.println("could not open file");
    	}
    	return rowlist;
    }
    
    public void FileIO (String readFile, String writeFile) throws MalformedURLException, IOException {
    	
    	String line = "";
    	try{
    		read = new BufferedReader(new FileReader (readFile));
    		write = new BufferedWriter (new FileWriter (writeFile));
        
    		write.write("whatever, whatelse, idunno, pffft");
    		write.close();
        
    		while((line = read.readLine()) != null){
    			String[] data = line.split(",");
    			//do stuff with data
    			
    		}
    	}catch(Exception e){
    		System.out.println("could not open file");
    	}
    }
    
    
	
	
	
//	public static void main(String[] args) {
//		 
//		ReadCVS obj = new ReadCVS();
//		obj.run();
//	 
//	}
	 
	
	
	
	
}
