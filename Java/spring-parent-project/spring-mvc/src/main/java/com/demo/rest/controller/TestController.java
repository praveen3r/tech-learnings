package com.demo.rest.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test/")
public class TestController {

	//http://localhost:8080/spring-mvc/test/version
	@RequestMapping(value = "version", method = RequestMethod.GET, consumes="application/json", produces="application/json")
	public ResultEntity<String> getVersion() {
		ResultEntity<String> response = new ResultEntity<String>();
		response.setSuccess(true);
		return response;
	}
	
	//http://localhost:8080/spring-mvc/test/version/1
	@RequestMapping(value = "version/{var}", method = RequestMethod.GET)
	public String getVersions(@PathVariable("var") final String var) {
		return var;
	}
	
	//http://localhost:8080/spring-mvc/test/version/1/2
	@RequestMapping(value = "version/{var1}/{var2}", method = RequestMethod.GET)
	public String getVersionss(@PathVariable("var1") final String var1,@PathVariable("var2") final String var2) {
		return var1 + " " + var2;
	}
	
	//http://localhost:8080/spring-mvc/test/version/1/2/3
	@RequestMapping(value = "version/{var1}/{var2}/{var3}", method = RequestMethod.GET)
	public String getVersionsss(@PathVariable Map<String, String> var) {
		return var.get("var1") + " " + var.get("var2") + " " + var.get("var3");
	}
	
	//http://localhost:8080/spring-mvc/test/version
	/*@RequestMapping(value = "version", method = RequestMethod.GET, consumes="application/json", produces="application/json")
	public String getVersion() {
		ResultEntity<String> response = new ResultEntity<String>();
		response.setSuccess(true);
		return "test";
	}*/
	
	//http://localhost:8080/spring-mvc/test/version/1
	@RequestMapping(value = "version/{apiType}", method = RequestMethod.GET, params="myParam=myValue", headers="myHeader=myValue")
	public ResultEntity<String> getVersion1(@PathVariable("apiType") final String apiType,@RequestParam("myParam") String myParam) {
		ResultEntity<String> response = new ResultEntity<String>();
		response.setSuccess(true);
		response.setData(myParam);
		return response;
	}
	
	//http://localhost:8080/spring-mvc/test/version2?myParam=value
	@RequestMapping(value = "version2", method = RequestMethod.GET)
	public String getVersion2(@RequestParam("myParam") String myParam) {
		return myParam;
	}
	
	//http://localhost:8080/spring-mvc/test/version21?myParam1=value1&myParam2=value2
	@RequestMapping(value = "version21", method = RequestMethod.GET)
	public String getVersion2(@RequestParam("myParam1") String myParam1,@RequestParam("myParam2") String myParam2) {
		return myParam1 + " "+myParam2;
	}
	
	//http://localhost:8080/spring-mvc/test/version22?myParam1=value1&myParam2=value2&myParam3=value3
	@RequestMapping(value = "version22", method = RequestMethod.GET)
	public String getVersion23(@RequestParam Map<String,String> myParam) {
		return myParam.get("myParam1") + " "+myParam.get("myParam2") + " "+myParam.get("myParam3");
	}
	
	//http://localhost:8080/spring-mvc/test/version2?myParam1=value1&myParam2=value2&myParam3=value3
	@RequestMapping(value = "version3", method = RequestMethod.GET)
	public ResultEntity<String> getVersion1(@RequestHeader("myHeader") String myHeader) {
		ResultEntity<String> response = new ResultEntity<String>();
		response.setSuccess(true);
		response.setData(myHeader);
		return response;
	}
	
	//http://localhost:8080/spring-mvc/test/version1/matrixVars=Sunil
	/*@RequestMapping(value = "version1/{matrixVars}", method = RequestMethod.GET)
	public ResultEntity<String> getVersion2(@MatrixVariable("matrixVars") String matrixVars){
		ResultEntity<String> response = new ResultEntity<String>();
		response.setSuccess(true);
		response.setData(matrixVars);
		return response;
	}*/
	
	//http://localhost:8080/spring-mvc/test/version1/matrixVars1=Sunil/matrixVars2=Singh
	/*@RequestMapping(value = "version1/{matrixVars1}/{matrixVars2}", method = RequestMethod.GET)
	public ResultEntity<String> getVersion2(@MatrixVariable("matrixVars1") String matrixVars1,
											@MatrixVariable("matrixVars2") String matrixVars2){
		ResultEntity<String> response = new ResultEntity<String>();
		response.setSuccess(true);
		response.setData(matrixVars2);
		return response;
	}*/
	
	//http://localhost:8080/spring-mvc/test/version1/Mike;salary=45000;dept=HR
	/*@RequestMapping(value = "version1/{name}", method = RequestMethod.GET)
	public ResultEntity<String> getVersion2(@PathVariable("name") String name,
									         @MatrixVariable("salary") double salary,
									         @MatrixVariable("dept") String dept
	         ) {
		ResultEntity<String> response = new ResultEntity<String>();
		response.setSuccess(true);
		response.setData(dept);
		return response;
	}*/
	
	//http://localhost:8080/spring-mvc/test/version1/Audi;color=RED,BLACK,WHITE
	/*@RequestMapping(value = "version1/{name}", method = RequestMethod.GET)
	public ResultEntity<String> getVersion2(@PathVariable("name") String name,
											@MatrixVariable("color") String[] color
	         ) {
		ResultEntity<String> response = new ResultEntity<String>();
		response.setSuccess(true);
		response.setData(color[0]);
		return response;
	}*/
	
	//http://localhost:8080/spring-mvc/test/version1/id=1;name=John;
	/*@RequestMapping(value = "version1/{name}", method = RequestMethod.GET)
	public ResultEntity<Map<String, String>> getVersion2(@MatrixVariable Map<String, String> matrixVars){
		ResultEntity<Map<String, String>> response = new ResultEntity<Map<String, String>>();
		response.setSuccess(true);
		response.setData(matrixVars);
		return response;
	}*/
	
	//http://localhost:8080/spring-mvc/test/version1/id=1,2,3;name=John;
	/*@RequestMapping(value = "version1/{name}", method = RequestMethod.GET)
	public ResultEntity<Map<String, Object>> getVersion2(@MatrixVariable Map<String, Object> matrixVars){
		ResultEntity<Map<String, Object>> response = new ResultEntity<Map<String, Object>>();
		response.setSuccess(true);
		response.setData(matrixVars);
		return response;
	}*/
	
	//http://localhost:8080/spring-mvc/test/version1/id=1,2,3;name=John;
	@RequestMapping(value = "version1/{name}", method = RequestMethod.GET)
	public ResultEntity<Map<String, List<String>>> getVersion2(@MatrixVariable Map<String, List<String>> matrixVars){
		ResultEntity<Map<String, List<String>>> response = new ResultEntity<Map<String, List<String>>>();
		response.setSuccess(true);
		response.setData(matrixVars);
		return response;
	}
	
	//http://localhost:8080/spring-mvc/test/version12/12;
	@RequestMapping(value = "version12/{id}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResultEntity<String> getVersion12(@PathVariable String id){
		ResultEntity<String> response = new ResultEntity<String>();
		response.setSuccess(true);
		response.setData(id);
		return response;
	}
	/*//http://localhost:8080/spring-mvc/test/version12/12;
		@RequestMapping(value = "version12/{id}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<ResultEntity<String>> getVersion12(@PathVariable String id){
			ResultEntity<String> response = new ResultEntity<String>();
			response.setSuccess(true);
			response.setData(id);
			ResponseEntity<ResultEntity<String>> response1 = new ResponseEntity<>(response,HttpStatus.OK);
			return response1;
		}*/
}
