package com.demo.editor;

import java.beans.PropertyEditorSupport;

import org.springframework.util.StringUtils;

public class CustomNameEditor extends PropertyEditorSupport{
	
	@Override
	public void setAsText(String name) throws IllegalArgumentException{
		if(!StringUtils.isEmpty(name)){
			setValue("Mr. "+name);
		}
	}

}
