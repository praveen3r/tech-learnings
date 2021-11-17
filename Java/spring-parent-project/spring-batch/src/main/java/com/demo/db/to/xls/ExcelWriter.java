package com.demo.db.to.xls;

import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.batch.item.ItemWriter;

import com.demo.entity.Employee;

/*public class ExcelWriter implements ItemWriter<Employee>{

	private final Sheet sheet;
    private Integer currentRowNumber;
    private Integer currentColumnNumber;
    private Row row;
    
    ExcelWriter(Workbook workbook) {
        this.sheet = workbook.createSheet("Books");
        this.currentRowNumber = 0;
        this.currentColumnNumber = 0;
    }
    
    @Override
    public void write(List<? extends Employee> list) {
        list.forEach(this::writeBook);
    }

    private void writeBook(Employee emp) {
        addRow();
        addCell(emp.getFirstName());
        addCell(emp.getLastName());
        addCell(String.valueOf(emp.getAge()));
    }

    private void addRow() {
        row = this.sheet.createRow(currentRowNumber);
        currentRowNumber++;
        currentColumnNumber = 0;
    }

    private void addCell(String value) {
        Cell cell = row.createCell(currentColumnNumber);
        cell.setCellValue(value);
        currentColumnNumber++;
    }

}*/
