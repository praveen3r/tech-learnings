package com.demo.encrypt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URLDecoder;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class TestXLSXFilePoIEncrypt {

	public static void main(String[] args) throws Exception{
		
		TestXLSXFilePoIEncrypt testExcelFilePoIEncrypt = new TestXLSXFilePoIEncrypt();
		String path = testExcelFilePoIEncrypt.getClass().getClassLoader().getResource("ExcelFile.xlsx").getPath();
		String configPath = URLDecoder.decode(path, "UTF-8");
		String projectFolder = configPath.split("target")[0];
	    File encryptedFile = new File(projectFolder + "src/main/resources/" + "ExcelFile-encrypted.xlsx");
	    
	    FileInputStream input = new FileInputStream(new File(configPath));
	    
	    POIFSFileSystem fs = new POIFSFileSystem();
	    //EncryptionInfo info = new EncryptionInfo(fs, EncryptionMode.agile);
	    EncryptionInfo info = new EncryptionInfo(fs);
    
    	Encryptor enc = info.getEncryptor();
    	enc.confirmPassword("pass");
    
    	OPCPackage opc = OPCPackage.open(input);
    	OutputStream os = enc.getDataStream(fs);
    	opc.save(os);
    	opc.close();
    
	    FileOutputStream fos = new FileOutputStream(encryptedFile);
	    fs.writeFilesystem(fos);
	    fos.close();   
	    
	    System.out.println("success");
	}
	
	

}
