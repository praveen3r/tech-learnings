package com.demo.model;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class ValueDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private String id;
	
	//private MultipartFile file;
	
	private Object file;

    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }

	public Object getFile() {
		return file;
	}

	public void setFile(Object file) {
		this.file = file;
	}

	/*public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}*/
}
