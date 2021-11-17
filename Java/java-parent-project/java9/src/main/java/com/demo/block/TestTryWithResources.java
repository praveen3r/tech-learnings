package com.demo.block;

import java.io.FileOutputStream;

public class TestTryWithResources {

	public static void main(String[] args) throws Exception{
		FileOutputStream fileStream=new FileOutputStream("javatpoint.txt");  
        try(fileStream){  
             String greeting = "Welcome to javaTpoint.";      
                byte b[] = greeting.getBytes();       
                fileStream.write(b);      
                System.out.println("File written");           
        }catch(Exception e) {  
            System.out.println(e);  
        }       
	}

}
