package com.demo.jasper;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;

public class TestJasperExcel {

	public static void main(String[] args) {
		JasperReport jasperReport;
		JasperPrint jasperPrint;
		Map<String, Object> jasperParameter = new HashMap<String, Object>();
		List<CorpUserVO> corpUserList = new ArrayList<CorpUserVO>();
		for(int i=0;i<100;i++){
			CorpUserVO dataBean = new CorpUserVO();
			dataBean.setSerialNo(Long.parseLong(String.valueOf(i)));
			dataBean.setCorpName("TESTCORP");
			dataBean.setUserId("TTTTTTTTTTTTTTR");
			dataBean.setUserName("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTM");
			dataBean.setProductCode("MMMMMMMMMMMMMMMMMMMY");
			dataBean.setRole("Checker Level 1");
			dataBean.setCreatedDate(new java.sql.Date(12, 3, 2018));
			corpUserList.add(dataBean);
		}
		
		
		try {
			 System.out.println("started1");
			 jasperParameter.put("rptName", "ART_Userdetails_01022018.xls");
			 jasperParameter.put("userName", "PRAVUSER1");
			 jasperParameter.put("rptDate", DateUtil.todayUtilDateTime());
			 jasperParameter.put("corpName", "TESTREPORTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTSR");
			 jasperParameter.put("status", "All");
			 TestJasperExcel testExcel = new TestJasperExcel();
			 String path = testExcel.getClass().getClassLoader().getResource("Excel.jrxml").getPath();
			String configPath = URLDecoder.decode(path, "UTF-8");
			jasperReport = JasperCompileManager.compileReport(configPath);
			JRBeanCollectionDataSource beanColDataSource =new JRBeanCollectionDataSource(corpUserList);
            System.out.println("started2");
            jasperPrint = JasperFillManager.fillReport(jasperReport,jasperParameter,beanColDataSource); 
            FileOutputStream os = new FileOutputStream(new File("F:/test.xls"));
			JRXlsExporter exporter = new JRXlsExporter();
	        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
	        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(os));
	        SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
	        //configuration.setCollapseRowSpan(true);
	        configuration.setShowGridLines(false);
	        exporter.setConfiguration(configuration);
	        exporter.exportReport();
			
			 System.out.println("Done!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


	}

}
