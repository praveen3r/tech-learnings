package com.demo.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLDecoder;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.monitorjbl.xlsx.StreamingReader;

public class TestLargeFile {

	public static void main(String[] args) throws Exception {
		TestLargeFile testLargeFile = new TestLargeFile();
		String path = testLargeFile.getClass().getClassLoader().getResource("ExcelHugeData.xlsx").getPath();
		String configPath = URLDecoder.decode(path, "UTF-8");
		File file = new File(configPath);
		try (InputStream is = new FileInputStream(file)) {
			Workbook workbook = StreamingReader.builder().open(is);
			DataFormatter dataFormatter = new DataFormatter();
			for (Row row : workbook.getSheetAt(0)) {
				System.out.println(row.getRowNum());
				for (Cell cell : row) {
					String value = dataFormatter.formatCellValue(cell);
				}
			}
		}

	}

}
