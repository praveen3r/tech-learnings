package com.demo.programs;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RemoveOnlyNumbersFromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		remove("Ragu1677");
		removeWithAPI("Ragu167757");
		removeInStreams("Ragu1324");
	}
	
	public static void removeWithAPI(String input) {
		Long start=System.currentTimeMillis();
		input=input.replaceAll("[^A-Za-z]", "");
		System.out.println(System.currentTimeMillis()-start);
		System.out.println(input);
	}

	public static void removeInStreams(String input) {
		Long start=System.currentTimeMillis();
		String output=Arrays.stream(input.split("")).filter(a-> {
			Character ch=new Character(a.charAt(0));
			return !Character.isDigit(ch);
		}).collect(Collectors.joining("")).toString();
		System.out.println(System.currentTimeMillis()-start);
		System.out.println(output);
	}
	
	public static void remove(String input) {
		Long start=System.currentTimeMillis();
		String output="";
		for(int i=0;i<input.length();i++) {
			Character ch=new Character(input.charAt(i));
			if(!Character.isDigit(ch)) {
				output=output+ch.toString();
			}
		}
		System.out.println(System.currentTimeMillis()-start);
		System.out.println(output);
	}
}
