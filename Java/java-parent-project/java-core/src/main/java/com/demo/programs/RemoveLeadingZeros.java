package com.demo.programs;

public class RemoveLeadingZeros {

	public static void main(String[] args) {
		removeZero("00034340");
		removeZeroUsingRegex("00034340");
		removeZeroUsingSubString("00034340");
	}
	
	public static void removeZero(String str) 
    { 
        // Count leading zeros 
        int i = 0; 
        while (i < str.length() && str.charAt(i) == '0') 
            i++; 
  
        // Convert str into StringBuffer as Strings 
        // are immutable. 
        StringBuffer sb = new StringBuffer(str); 
  
        // The  StringBuffer replace function removes 
        // i characters from given index (0 here) 
        sb.replace(0, i, ""); 
  
        System.out.println(sb.toString());
    } 
	
	public static void removeZeroUsingRegex(String input) {
		System.out.println(input.replaceFirst("^0+(?!$)", ""));
	}
	
	static void removeZeroUsingSubString(String input) {
		int i=0;
		while(i<input.length()&&input.charAt(i)=='0') {
			i++;
		}
		System.out.println(input.substring(i));
	}
}
