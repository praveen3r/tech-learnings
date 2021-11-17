package com.demo.dto;

import java.util.Date;

import com.demo.utils.CustomDateDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class JsonToJavaDeserializer {

	@JsonDeserialize(using = CustomDateDeserializer.class)
    public Date activeDate;

	public Date getActiveDate() {
		return activeDate;
	}

	public void setActiveDate(Date activeDate) {
		this.activeDate = activeDate;
	}
}
