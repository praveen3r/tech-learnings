package com.demo.file;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil {

	public static void copyFile(final String sourceFileLoc,final String destinationFileLoc) throws Exception{
		
		final Path sourcePath      = Paths.get(sourceFileLoc);
		final Path destinationPath = Paths.get(destinationFileLoc);
		
	    Files.copy(sourcePath, destinationPath);
	}
	
	public static void moveFile(final String sourceFileLoc, final String destinationFileLoc) throws Exception{

		final Path sourcePath = Paths.get(sourceFileLoc);
		final Path destinationPath = Paths.get(destinationFileLoc);
			
		Files.move(sourcePath, destinationPath);
		
	}
	
	/*
	 * public static void createFile(MultipartFile file, final String fileName,final
	 * String path) throws Exception{ String filePath = "D:" + "/"+ fileName;
	 * file.transferTo(new File(filePath)); }
	 */
	
	public static OutputStream getFileOutputStream(final String path) throws Exception{
		return Files.newOutputStream(Paths.get(path));
	}
	
	public static InputStream getFileInputStream(final String path, final String fileName) throws Exception{
		String filePath = path + "/"+ fileName;
		return Files.newInputStream(Paths.get(filePath));
	}
}
