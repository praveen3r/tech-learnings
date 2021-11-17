package com.demo.decrypt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import com.demo.encrypt.TestTxtFileEncrypt;

public class TestExcelFileDecrypt {

	public static void main(String[] args) throws Exception{
		String key = "This is a secret";
		TestTxtFileEncrypt testFileEncrypt = new TestTxtFileEncrypt();
		String path = testFileEncrypt.getClass().getClassLoader().getResource("ExcelFile-encrypted.xlsx").getPath();
		String configPath = URLDecoder.decode(path, "UTF-8");
		File file = new File(configPath);
		String projectFolder = configPath.split("target")[0];
	    File encryptedFile = new File(projectFolder + "src/main/resources/" + "ExcelFile-decrypted.xlsx");
			
		try {
			fileProcessor(Cipher.DECRYPT_MODE,key,file,encryptedFile);
		     System.out.println("Sucess");
		 } catch (Exception ex) {
		     System.out.println(ex.getMessage());
	             ex.printStackTrace();
		 }
	}
	
	static void fileProcessor(int cipherMode,String key,File inputFile,File outputFile){
		 try {
		       Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
		       Cipher cipher = Cipher.getInstance("AES");
		       cipher.init(cipherMode, secretKey);

		       FileInputStream inputStream = new FileInputStream(inputFile);
		       byte[] inputBytes = new byte[(int) inputFile.length()];
		       inputStream.read(inputBytes);

		       byte[] outputBytes = cipher.doFinal(inputBytes);

		       FileOutputStream outputStream = new FileOutputStream(outputFile);
		       outputStream.write(outputBytes);

		       inputStream.close();
		       outputStream.close();

		    } catch (NoSuchPaddingException | NoSuchAlgorithmException 
	                     | InvalidKeyException | BadPaddingException
		             | IllegalBlockSizeException | IOException e) {
			e.printStackTrace();
	            }
	     }
	
	static void fileReader(int cipherMode,String key,File inputFile,File outputFile){
		 try {
		       Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
		       Cipher cipher = Cipher.getInstance("AES");
		       cipher.init(cipherMode, secretKey);

		       FileInputStream inputStream = new FileInputStream(inputFile);
		       byte[] inputBytes = new byte[(int) inputFile.length()];
		       inputStream.read(inputBytes);

		       byte[] outputBytes = cipher.doFinal(inputBytes);

		       System.out.println( new String(outputBytes, "UTF-8") );

		       inputStream.close();

		    } catch (NoSuchPaddingException | NoSuchAlgorithmException 
	                     | InvalidKeyException | BadPaddingException
		             | IllegalBlockSizeException | IOException e) {
			e.printStackTrace();
	            }
	     }

}
