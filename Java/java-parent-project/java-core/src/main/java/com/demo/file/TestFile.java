package com.demo.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//Files.createFile(Paths.get("D:/Docs/CIB/UNBI/Test/testFile.txt"));
			Files.createFile(Paths.get("c:/softwares/testFile.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
