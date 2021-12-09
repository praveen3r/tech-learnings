package com.demo.string;

import org.apache.commons.lang3.StringUtils;

public class StringPadding {
	public static void main(String[] args) {
		String str = "123456";
		String newStr = padLeftZerosUsingStringFormat(str, 8);
		System.out.println(newStr);
	}
	
	public static String padLeftZerosUsingStringBuilder(String inputString, int length) {
	    if (inputString.length() >= length) {
	        return inputString;
	    }
	    StringBuilder sb = new StringBuilder();
	    while (sb.length() < length - inputString.length()) {
	        sb.append('0');
	    }
	    sb.append(inputString);

	    return sb.toString();
	}
	
	public static String padLeftZerosUsingStringFormat(String inputString, int length) {
		return String.format("%1$" + length + "s", inputString).replace(' ', '0');
		//return null;
	}
	
	public static String padLeftZerosUsingCommonsLang(String inputString, int length) {
		return StringUtils.leftPad(inputString, length, "0");
	}
}
