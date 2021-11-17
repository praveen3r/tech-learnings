package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.dto.UserVO;

@Controller
@RequestMapping("/demo")
public class DemoController {

	//http://localhost:8080/spring-mvc/demo
	@RequestMapping(method = RequestMethod.GET)
    public String get() {
        return "demo";
    }

	//http://localhost:8080/spring-mvc/demo/withAttributes
	@RequestMapping(method = RequestMethod.GET, value="/withAttributes")
    public String getWithAttributes(Model model) {
		//model.addAttribute("demoAttr", "Hello World");
		UserVO userVO = new UserVO();
		userVO.setFirstName("Raghu");
		model.addAttribute("demoAttr", userVO);
        return "demo";
    }
	
	/*@ModelAttribute //this will add this attribute to add request handler in controllers, i.e all requests to this class. When this 
	 * class is invoked, this method runs first before requestmapping method
	public void addDefaultValue(Model model){
		model.addAttribute("demoAttr", "Hello World");
	}*/
}
