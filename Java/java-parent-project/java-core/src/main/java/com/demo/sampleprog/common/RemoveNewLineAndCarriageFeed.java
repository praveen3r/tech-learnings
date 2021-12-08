package com.demo.sampleprog.common;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class RemoveNewLineAndCarriageFeed {

	public static void main(String[] args) {
		
		String str = "<!DOCTYPE html>\r\n" + 
				"<html xmlns='http://www.w3.org/1999/xhtml'>\r\n" + 
				"\r\n" + 
				"<head>\r\n" + 
				"    <meta charset='utf-8'>\r\n" + 
				"    <!-- utf-8 works for most cases -->\r\n" + 
				"    <meta name='viewport' content='width=device-width'>\r\n" + 
				"    <!-- Forcing initial-scale shouldn&#39;t be necessary -->\r\n" + 
				"    <meta http-equiv='X-UA-Compatible' content='IE=edge'>\r\n" + 
				"    <!-- Use the latest (edge) version of IE rendering engine -->\r\n" + 
				"    <meta name='x-apple-disable-message-reformatting'>\r\n" + 
				"    <!-- Disable auto-scale in iOS 10 Mail entirely -->\r\n" + 
				"    <title>{2}</title>\r\n" + 
				"    <!-- The title tag shows in email notifications, like Android 4.4. -->\r\n";
		
		str = str.replaceAll("(\\r|\\n)", "");
		String result = str.replaceAll(">[\\s\r\n]*<", "><");
        System.out.println(result);
		/*
		 * byte[] actualByte= Base64.getMimeDecoder().decode(str);
		 * System.out.println(new String(actualByte));
		 */
	}

}
