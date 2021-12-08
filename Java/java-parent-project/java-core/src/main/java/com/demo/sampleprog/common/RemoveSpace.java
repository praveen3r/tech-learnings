package com.demo.sampleprog.common;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class RemoveSpace {

	public static void main(String[] args) {
		String str = "<html>         test</html>";
		String result1 = str.replaceAll("\\s{3,}", " ").trim();
        System.out.println(result1);
		
	}

}
