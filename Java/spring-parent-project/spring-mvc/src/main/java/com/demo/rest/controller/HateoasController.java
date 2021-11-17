package com.demo.rest.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.HateoasVO;
import com.demo.resource.HateoasResource;
import com.demo.resource.HateoasResourceAssembler;


@RestController
@RequestMapping("/hateoas/")
public class HateoasController {

	// http://localhost:8080/spring-mvc/hateoas/rest1
	@RequestMapping(value = "rest1", method = RequestMethod.GET)
	public HateoasResource rest1() {
		HateoasVO hateoasVO = new HateoasVO();
		hateoasVO.setFirstName("first name");
		hateoasVO.setLastName("last name");
		return new HateoasResourceAssembler().toResource(hateoasVO);
	}
	
	@RequestMapping(value = "rest2", method = RequestMethod.GET)
	public HateoasResource rest2() {
		HateoasResource hateoasResource = new HateoasResource();
		hateoasResource.setFirstName("first name");
		hateoasResource.setLastName("last name");
		return hateoasResource;
	}
	
	@RequestMapping(value = "rest31", method = RequestMethod.GET)
	public List<HateoasResource> rest3() {
		List<HateoasResource> hateoasResourcesList = new ArrayList<HateoasResource>();
		
		HateoasResource hateoasResource = new HateoasResource();
		hateoasResource.setFirstName("Sathya");
		hateoasResource.setLastName("last name");
		hateoasResource.add(linkTo(HateoasController.class).slash(hateoasResource.getFirstName()).withSelfRel());
		hateoasResource.add(linkTo(methodOn(HateoasController.class).rest3()).slash(hateoasResource.getLastName()).withRel("lastName"));
		
		HateoasResource hateoasResource1 = new HateoasResource();
		hateoasResource1.setFirstName("Raghu");
		hateoasResource1.setLastName("last name");
		hateoasResource1.add(linkTo(HateoasController.class).slash(hateoasResource1.getFirstName()).withSelfRel());
		
		hateoasResourcesList.add(hateoasResource);
		hateoasResourcesList.add(hateoasResource1);
		
		return hateoasResourcesList;
	}
	
	@RequestMapping(value = "rest4", method = RequestMethod.GET)
	public HateoasResource rest4(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		HateoasResource hateoasResource = new HateoasResource();
		hateoasResource.setFirstName("first name");
		hateoasResource.setLastName("last name");
		hateoasResource.add(linkTo(methodOn(HateoasController.class).rest4(name)).withSelfRel());
		return hateoasResource;
	}
	
	/*@RequestMapping(value = "userPagingList", method = RequestMethod.GET)
	public ResponseEntity<PagedResources<Resource<UserVO>>> getUserPagingList(Pageable pageable, PagedResourcesAssembler<UserVO> assembler) {
		Page<UserVO> response = testAngularService.getUsersList1(new PageRequest(1, 2, Direction.DESC, "userId"));
		return new ResponseEntity<>(assembler.toResource(response), HttpStatus.OK);
	}*/
}
