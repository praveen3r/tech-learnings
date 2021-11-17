package com.demo.excel;

import java.io.File;
import java.net.URLDecoder;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestPoiExcel {

	public static void main(String[] args) throws Exception{
		TestPoiExcel testExcel = new TestPoiExcel();
		String path = testExcel.getClass().getClassLoader().getResource("Excel.xlsx").getPath();
		String configPath = URLDecoder.decode(path, "UTF-8");
		File file = new File(configPath);
		Workbook workbook = null;
		try{
			workbook = WorkbookFactory.create(file);
		}catch(Exception e){
			e.printStackTrace();
		}
		Sheet sheet = workbook.getSheetAt(0);
		for(Row row : sheet){
			System.out.println("Processing row "+ row.getRowNum());
			for(int index=0;index<row.getPhysicalNumberOfCells();index++){
				Cell cell = (Cell)row.getCell(index);
				System.out.println("Column value "+ cell.getStringCellValue());
			}
		}

	}
}
