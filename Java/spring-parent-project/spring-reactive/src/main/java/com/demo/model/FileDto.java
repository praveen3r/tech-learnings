package com.demo.model;

import java.io.Serializable;

import org.springframework.http.codec.multipart.FilePart;

public class FileDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private FilePart file;

	public FilePart getFile() {
		return file;
	}

	public void setFile(FilePart file) {
		this.file = file;
	}
	
	
	
	/*private Object file;

    public Object getFile() {
		return file;
	}

	public void setFile(Object file) {
		this.file = file;
	}*/

	/*public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}*/
}
