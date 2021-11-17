package com.demo.programs;

public class StringFormatter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		capitalizeWord("this is ragupathy");
		incrementEachLetter("abcDEzX", 4);
	}
	static void capitalizeWord(String str){  
	    String words[]=str.split("\\s");  
	    String capitalizeWord="";  
	    for(String w:words){  
	        String first=w.substring(0,1);  
	        String afterfirst=w.substring(1);  
	        capitalizeWord+=first.toUpperCase()+afterfirst+" ";  
	    }  
	    System.out.println(capitalizeWord.trim());  
	} 
	
	static void incrementEachLetter(String input,int index) {
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<input.length();i++){
			int ascii=input.charAt(i)+index;
			if(ascii>122 && (input.charAt(i)>96 && input.charAt(i)<=122)) {
				ascii=(ascii%122)+96;
			}
			else if(ascii>90 && (input.charAt(i)>64 && input.charAt(i)<=90)){
				ascii=(ascii%90)+64;
			}
			sb.append((char)ascii);
		}
		System.out.println(sb);
	}

}
