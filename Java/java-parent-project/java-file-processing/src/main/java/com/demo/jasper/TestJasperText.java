package com.demo.jasper;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRTextExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleTextReportConfiguration;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;

public class TestJasperText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JasperReport jasperReport;
		JasperPrint jasperPrint;
		Map<String, Object> jasperParameter = new HashMap<String, Object>();
		List<CorpUserVO> corpUserList = new ArrayList<CorpUserVO>();
		for (int i = 0; i < 100; i++) {
			CorpUserVO dataBean1 = new CorpUserVO();
			// dataBean1.setCorpName("TESTREPORTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTSR");
			dataBean1.setUserId("TESTUSER1");
			dataBean1.setUserName("TESTUSER1");
			dataBean1.setProductCode("Man");
			dataBean1.setRole("Checker-Level 1");
			dataBean1.setCreatedDate(new java.sql.Date(12, 3, 2018));
			corpUserList.add(dataBean1);
		}
		try {
			System.out.println("started1");
			jasperParameter.put("rptName", "ART_Userdetails_01022018.xls");
			jasperParameter.put("userName", "PRAVUSER1");
			jasperParameter.put("rptDate", DateUtil.todayUtilDateTime());
			jasperParameter.put("corpName", "TESTREPORT");
			// jasperParameter.put("corpName",
			// "TESTREPORTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTSR");
			jasperParameter.put("status", "All");
			TestJasperPDF testExcel = new TestJasperPDF();
			 String path = testExcel.getClass().getClassLoader().getResource("Excel.jrxml").getPath();
			String configPath = URLDecoder.decode(path, "UTF-8");
			jasperReport = JasperCompileManager.compileReport(configPath);
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(corpUserList);
			/* Map to hold Jasper report Parameters */
			/*
			 * Map<String, Object> parameters = new HashMap<String, Object>();
			 * parameters.put("DS", dataList);
			 */
			System.out.println("started2");
			jasperPrint = JasperFillManager.fillReport(jasperReport, jasperParameter, beanColDataSource);
			JRTextExporter exporter = new JRTextExporter();
			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			FileOutputStream os = new FileOutputStream(new File("F:/test.txt"));
			exporter.setExporterOutput(new SimpleWriterExporterOutput(os));

			SimpleTextReportConfiguration configuration = new SimpleTextReportConfiguration();
			configuration.setCharWidth(4f);
			configuration.setCharHeight(19f);
			exporter.setConfiguration(configuration);

			exporter.exportReport();

			System.out.println("Done!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
