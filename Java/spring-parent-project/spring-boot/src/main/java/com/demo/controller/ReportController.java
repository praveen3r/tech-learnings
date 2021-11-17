package com.demo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JasperReport;

@RestController
@RequestMapping(value = "/report/")
@CrossOrigin("*")
public class ReportController extends BaseReportController{

	@Autowired
	JasperReport fileUploadErrorRpt;
	
	@RequestMapping(value = "download", method = RequestMethod.GET)
	public void generateErrorReport(final HttpServletResponse httpResponse,@RequestParam("rptType") String rptType) throws Exception{
		//List<FileUploadResponseDto> fileUploadResponseVOList = resultEntity.getEntityList();
		//generateReportAsExcel(httpResponse,fileUploadErrorRpt, fileUploadResponseVOList,null); 
		generateReportAsExcel(httpResponse,fileUploadErrorRpt, null,null); 
	}
	
}
