package com.demo.controller;

import java.io.OutputStream;
import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRTextExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleTextReportConfiguration;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;

public class BaseReportController {

	/*
	 * protected void addHeaderParams(Map<String, Object> parameters, final ReportVO
	 * reportVO){ parameters.put("userName", reportVO.getUserId());
	 * parameters.put("rptDate", DateUtil.todayUtilDateTime());
	 * parameters.put("corpName", reportVO.getCorpName());
	 * if(StringUtils.isNotEmpty(reportVO.getReportName()))
	 * parameters.put("rptName", reportVO.getReportName());
	 * if(StringUtils.isNotEmpty(reportVO.getStatusVal())) parameters.put("status",
	 * reportVO.getStatusVal()); if(StringUtils.isNotEmpty(reportVO.getStartDate()))
	 * parameters.put("fromDate",
	 * DateUtil.convertUtilDate(reportVO.getStartDate(),"dd/MM/yyyy"));
	 * if(StringUtils.isNotEmpty(reportVO.getEndDate())) parameters.put("toDate",
	 * DateUtil.convertUtilDate(reportVO.getEndDate(), "dd/MM/yyyy"));
	 * if(reportVO.getFromDate() != null) parameters.put("fromDate",
	 * reportVO.getFromDate()); if(reportVO.getToDate() != null)
	 * parameters.put("toDate", reportVO.getToDate()); if(reportVO.getCorporate() !=
	 * null && reportVO.getCorporate().getContactName() != null)
	 * parameters.put("contactPerson", reportVO.getCorporate().getContactName());
	 * if(reportVO.getCorporate() != null && reportVO.getCorporate().getPhoneNo() !=
	 * null) parameters.put("phoneNo", reportVO.getCorporate().getPhoneNo());
	 * if(reportVO.getCollectionType() != null) parameters.put("colType",
	 * reportVO.getCollectionType());
	 * if(StringUtils.isNotEmpty(reportVO.getProductCode()))
	 * parameters.put("prodName", reportVO.getProductCode());
	 * if(StringUtils.isNotEmpty(reportVO.getProductCodeVal()))
	 * parameters.put("prodName", reportVO.getProductCodeVal());
	 * if(StringUtils.isNotEmpty(reportVO.getPymtStatus()))
	 * parameters.put("pymtStatus", reportVO.getPymtStatus());
	 * if(StringUtils.isNotEmpty(reportVO.getCorpId())) parameters.put("corpId",
	 * reportVO.getCorpId());
	 * 
	 * }
	 */

	protected JasperPrint getJasperPrintObj(final JasperReport jasperReport, final Collection<?> beanCollection,
			Map<String, Object> parameters) throws Exception {
		final JRDataSource dataSource;
		if (null == beanCollection)
			dataSource = new JREmptyDataSource();
		else
			dataSource = new JRBeanCollectionDataSource(beanCollection);
		return JasperFillManager.fillReport(jasperReport, parameters, dataSource);

	}

	/**
	 * this method return all excel report.,
	 * 
	 * @param response
	 * @param jasperReport
	 * @param beanCollection
	 */
	protected void generateReportAsExcel(final HttpServletResponse response, final JasperReport jasperReport,
			final Collection<?> beanCollection, Map<String, Object> parameters) throws Exception {

		final JasperPrint jasperPrint = getJasperPrintObj(jasperReport, beanCollection, parameters);
		response.setContentType("application/vnd.ms-excel");
		final OutputStream os = response.getOutputStream();
		JRXlsExporter exporter = new JRXlsExporter();
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(os));
		SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
		configuration.setShowGridLines(false);
		exporter.setConfiguration(configuration);
		exporter.exportReport();

	}

	/**
	 * this method return all pdf report.,
	 * 
	 * @param response
	 * @param jasperReport
	 * @param beanCollection
	 */
	protected void generateReportAsPDF(final HttpServletResponse response, final JasperReport jasperReport,
			final Collection<?> beanCollection, Map<String, Object> parameters) throws Exception {

		final JasperPrint jasperPrint = getJasperPrintObj(jasperReport, beanCollection, parameters);
		response.setContentType("application/pdf");
		final OutputStream os = response.getOutputStream();
		final JRPdfExporter exporter = new JRPdfExporter();
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(os));
		exporter.exportReport();

	}

	/**
	 * this method return all txt report.,
	 * 
	 * @param response
	 * @param jasperReport
	 * @param beanCollection
	 */
	protected void generateReportAsText(final HttpServletResponse response, final JasperReport jasperReport,
			final Collection<?> beanCollection, Map<String, Object> parameters, float charWidth, float charHeight)
			throws Exception {

		final JasperPrint jasperPrint = getJasperPrintObj(jasperReport, beanCollection, parameters);
		response.setContentType("text/plain");
		final OutputStream os = response.getOutputStream();
		JRTextExporter exporter = new JRTextExporter();
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleWriterExporterOutput(os));

		SimpleTextReportConfiguration configuration = new SimpleTextReportConfiguration();
		configuration.setCharWidth(charWidth);
		configuration.setCharHeight(charHeight);
		exporter.setConfiguration(configuration);

		exporter.exportReport();

	}

}
