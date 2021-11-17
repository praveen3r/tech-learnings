package com.demo.jasper;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class TestJasperPDF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				JasperReport jasperReport;
				JasperPrint jasperPrint;
				Map<String, Object> jasperParameter = new HashMap<String, Object>();
				List<CorpUserVO> corpUserList = new ArrayList<CorpUserVO>();
				for(int i=0;i<100;i++){
					CorpUserVO dataBean = new CorpUserVO();
					dataBean.setCorpName("TESTCORP");
					dataBean.setUserId("TESTMAXXXXXXXXX");
					dataBean.setUserName("TESTMAXXXXXXXXX");
					dataBean.setProductCode("Man");
					dataBean.setRole("Maker");
					dataBean.setCreatedDate(new java.sql.Date(12, 3, 2018));
					corpUserList.add(dataBean);
				}
				
				
				try {
					 System.out.println("started1");
					 jasperParameter.put("rptName", "ART_Userdetails_01022018.xls");
					 jasperParameter.put("userName", "PRAVUSER1");
					 jasperParameter.put("rptDate", DateUtil.todayUtilDateTime());
					 //jasperParameter.put("corpName", "TESTREPORT");
					 jasperParameter.put("corpName", "TESTREPORTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTSR");
					 jasperParameter.put("status", "All");
					 TestJasperPDF testExcel = new TestJasperPDF();
					 String path = testExcel.getClass().getClassLoader().getResource("Excel.jrxml").getPath();
					String configPath = URLDecoder.decode(path, "UTF-8");
					jasperReport = JasperCompileManager.compileReport(configPath);
					//JRBeanCollectionDataSource beanColDataSource =new JRBeanCollectionDataSource(corpUserList);
					JRBeanCollectionDataSource beanColDataSource =new JRBeanCollectionDataSource(corpUserList);
					/* Map to hold Jasper report Parameters */
		           /* Map<String, Object> parameters = new HashMap<String, Object>();
		            parameters.put("DS", dataList);*/
		            System.out.println("started2");
					jasperPrint = JasperFillManager.fillReport(jasperReport,jasperParameter,beanColDataSource); 
					JasperExportManager.exportReportToPdfFile(jasperPrint, "F:/sample_report.pdf");
					
					 System.out.println("Done!");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

	}

}
