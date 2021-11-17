package com.demo.programs;

import java.util.Arrays;
import java.util.Comparator;

public class SortByUpperAndLower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sortString("Ragupathy"));
		System.out.println(sortStringIncludeUpperCase("Ragupathy"));
	}
	
	// Method to sort a string alphabetically 
    public static String sortString(String inputString) 
    { 
        // convert input string to char array 
        char tempArray[] = inputString.toCharArray(); 
          
        // sort tempArray 
        Arrays.sort(tempArray); 
          
        // return new sorted string 
        return new String(tempArray); 
    } 
    
    // Method to sort a string alphabetically 
    public static String sortStringIncludeUpperCase(String inputString) 
    { 
    	// convert input string to Character array 
        Character tempArray[] = new Character[inputString.length()]; 
        for (int i = 0; i < inputString.length(); i++) { 
            tempArray[i] = inputString.charAt(i); 
        }
          
        // sort tempArray 
        // Sort, ignoring case during sorting 
        /*Arrays.sort(tempArray, new Comparator<Character>(){ 
  
            @Override
            public int compare(Character c1, Character c2) 
            { 
                // ignoring case 
                return Character.compare(Character.toLowerCase(c1), 
                                        Character.toLowerCase(c2)); 
            } 
        });*/
          
        //Java 8
        Arrays.sort(tempArray, Comparator.comparing(a->Character.toLowerCase(a)));
        
        // using StringBuilder to convert Character array to String 
        StringBuilder sb = new StringBuilder(tempArray.length); 
        for (Character c : tempArray) 
            sb.append(c.charValue()); 
  
        return sb.toString();  
    } 

}
