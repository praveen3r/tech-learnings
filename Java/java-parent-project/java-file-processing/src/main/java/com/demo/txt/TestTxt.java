package com.demo.txt;

import java.io.File;
import java.net.URLDecoder;
import java.util.Scanner;

public class TestTxt {

	public static void main(String[] args) throws Exception {
		TestTxt testTxt = new TestTxt();
		String path = testTxt.getClass().getClassLoader().getResource("TxtFile.txt").getPath();
		String configPath = URLDecoder.decode(path, "UTF-8");
		File file = new File(configPath);
		try(Scanner scanner =  new Scanner(file, "UTF-8")){
			while (scanner.hasNextLine()){
				String rowVal=scanner.nextLine();
				System.out.println("row is "+rowVal);
			}
		}

	}
}
