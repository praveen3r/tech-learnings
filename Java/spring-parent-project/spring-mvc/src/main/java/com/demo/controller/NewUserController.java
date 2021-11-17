package com.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.dto.NewUserVO;
import com.demo.dto.SexVO;

@Controller
@RequestMapping("/newUser")
public class NewUserController {

	//http://localhost:8080/spring-mvc/newUser/home
	/*@RequestMapping(method = RequestMethod.GET, value="/home")
    public ModelAndView userHome() {
		ModelAndView modelAndView = new ModelAndView("user/newUser");
		modelAndView.addObject("userVO", new NewUserVO());
		return modelAndView;
		//return new ModelAndView("user/newUser", "userVO", new NewUserVO());
    }*/
		
	//http://localhost:8080/spring-mvc/newUser/home
	@RequestMapping(method = RequestMethod.GET, value="/home")
    public ModelAndView userHome() {
		ModelAndView modelAndView = new ModelAndView("user/newUser");
		NewUserVO userVO = new NewUserVO();
		userVO.setFirstName("raghu");
		userVO.setSexList(Arrays.asList("Male","Female"));
		
		SexVO sexVO = new SexVO();
		sexVO.setCode("M");
		sexVO.setDesc("Male");
		
		SexVO sexVO1 = new SexVO();
		sexVO1.setCode("F");
		sexVO1.setDesc("Female");
		
		List<SexVO> sexVOList = new ArrayList<SexVO>();
		
		sexVOList.add(sexVO1);
		sexVOList.add(sexVO);
		
		userVO.setSexObjList(sexVOList);
		modelAndView.addObject("userVO", userVO);
		return modelAndView;
		//return new ModelAndView("user/newUser", "userVO", new NewUserVO());
    }
	
	/*@RequestMapping(method = RequestMethod.GET, value="/home")
    public String userHome() {
		ModelMap modelMap = new ModelMap();
		NewUserVO userVO = new NewUserVO();
		userVO.setFirstName("raghu");
		userVO.setSexList(Arrays.asList("Male","Female"));
		
		SexVO sexVO = new SexVO();
		sexVO.setCode("M");
		sexVO.setDesc("Male");
		
		SexVO sexVO1 = new SexVO();
		sexVO1.setCode("F");
		sexVO1.setDesc("Female");
		
		List<SexVO> sexVOList = new ArrayList<SexVO>();
		
		sexVOList.add(sexVO1);
		sexVOList.add(sexVO);
		
		userVO.setSexObjList(sexVOList);
		modelMap.addAttribute(userVO);
		//modelAndView.addObject("userVO", userVO);
		return "user/newUser";
		//return new ModelAndView("user/newUser", "userVO", new NewUserVO());
    }*/
	
	@RequestMapping(method = RequestMethod.POST, value="/add")
    public String addUser(@ModelAttribute("userVO") NewUserVO userVO, Model model) {
		System.out.println("fistname " + userVO.getFirstName());
		System.out.println(" lastname " + userVO.getLastName());
		System.out.println(" city " + userVO.getAddress().getCity());
		System.out.println(" mob " + userVO.getMobileNo());
		System.out.println(" DOB " + userVO.getDob());
		System.out.println(" sex " +userVO.getSex());
		model.addAttribute("msg", "User created Successfully");
		return "user/newUser";
    }
	
	/*@RequestMapping(method = RequestMethod.POST, value="/add")
    public String addUser(@ModelAttribute("userVO") NewUserVO userVO, Model model) {
		System.out.println("fistname " + userVO.getFirstName());
		System.out.println(" lastname " + userVO.getLastName());
		System.out.println(" city " + userVO.getAddress().getCity());
		System.out.println(" mob " + userVO.getMobileNo());
		System.out.println(" DOB " + userVO.getDob());
		System.out.println(" sex " +userVO.getSex());
		//model.addAttribute("msg", "User created Successfully");
		return "redirect:newUserSuccess";
    }*/
	
	/*@RequestMapping(method = RequestMethod.POST, value="/add")
    public String addUser(@ModelAttribute("userVO") NewUserVO userVO, Model model) {
		System.out.println("fistname " + userVO.getFirstName());
		System.out.println(" lastname " + userVO.getLastName());
		System.out.println(" city " + userVO.getAddress().getCity());
		System.out.println(" mob " + userVO.getMobileNo());
		System.out.println(" DOB " + userVO.getDob());
		System.out.println(" sex " +userVO.getSex());
		//model.addAttribute("msg", "User created Successfully");
		return "forward:newUserSuccess";
    }*/
	
	/*@RequestMapping(method = RequestMethod.GET, value="/newUserSuccess")
	public ModelAndView redirectedPostToGet(ModelMap model) {
		model.addAttribute("attribute", "redirectWithRedirectPrefix");
	    return new ModelAndView("user/newUserSuccess");
	}*/
	
	/*@RequestMapping(method = RequestMethod.POST, value="/add")
    public RedirectView addUser(@ModelAttribute("userVO") NewUserVO userVO, RedirectAttributes attributes) {
		System.out.println("fistname " + userVO.getFirstName());
		System.out.println(" lastname " + userVO.getLastName());
		System.out.println(" city " + userVO.getAddress().getCity());
		System.out.println(" mob " + userVO.getMobileNo());
		System.out.println(" DOB " + userVO.getDob());
		System.out.println(" sex " +userVO.getSex());
		//model.addAttribute("msg", "User created Successfully");
		attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectAttributes");
	    attributes.addAttribute("attribute", "redirectWithRedirectAttributes");
		return new RedirectView("newUserSuccess");
    }
	
	@RequestMapping(method = RequestMethod.GET, value="/newUserSuccess")
	public ModelAndView redirectedPostToGet(ModelMap model,@ModelAttribute("flashAttribute") Object flashAttribute) {
		model.addAttribute("flashAttribute", flashAttribute);
	    return new ModelAndView("user/newUserSuccess");
	}*/
	
	
	/*@InitBinder
	public void initBind(WebDataBinder binder){
		binder.registerCustomEditor(String.class, "firstName",new CustomNameEditor());
	}*/
	
	/*@InitBinder
	public void initBind(WebDataBinder binder){
		binder.setDisallowedFields(new String[]{"firstName"});
	}
	
	@InitBinder
	public void initBind(WebDataBinder binder){
		DateFormat dateFormat1 = new SimpleDateFormat("d-MM-yyyy");
		CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat1, true);
		binder.registerCustomEditor(Date.class, "dob", orderDateEditor);
	}*/
	
	/*@InitBinder
	public void initBind(WebDataBinder binder){
		binder.registerCustomEditor(String.class, "firstName",new CustomNameEditor());
	}*/
}
