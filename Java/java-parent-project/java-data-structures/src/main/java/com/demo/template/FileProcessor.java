package com.demo.template;

public abstract class FileProcessor {

	public void readProcessSave() {
		readData();
		processData();
		saveData();
	}
	
	public abstract void readData();
	
	public abstract void processData();
	
	public void saveData() {
		System.out.println("saving to DB");
	}
}
