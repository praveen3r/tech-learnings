package com.demo.resource;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.demo.dto.HateoasVO;
import com.demo.rest.controller.HateoasController;

public class HateoasResourceAssembler extends ResourceAssemblerSupport<HateoasVO, HateoasResource> {
	  
	public HateoasResourceAssembler() {
	      super(HateoasController.class, HateoasResource.class);
	  }

	  @Override
	  public HateoasResource toResource(HateoasVO entity) {
		  HateoasResource hateoasVO = super.createResourceWithId(entity.getFirstName(), entity);
		  hateoasVO.setFirstName(entity.getFirstName());
		  hateoasVO.setLastName(entity.getLastName());
	      return hateoasVO;
	  }
}
