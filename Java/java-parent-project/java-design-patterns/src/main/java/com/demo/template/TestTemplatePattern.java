package com.demo.template;

public class TestTemplatePattern {

	/*
	 * In template pattern sub class decide the steps to run the algorithm
	 */
	public static void main(String[] args) {

		ExcelFile excelFile = new ExcelFile();
		excelFile.readProcessSave();
		/*
		 * excelFile.readData(); excelFile.processData(); excelFile.saveData();
		 */
		
		TxtFile txtFile = new TxtFile();
		txtFile.readProcessSave();
		/*
		 * txtFile.readData(); txtFile.processData(); txtFile.saveData();
		 */
	}

}
