package com.demo.model;

import javax.validation.constraints.Max;

public class ValidatedClass {

	@Max(10)
	private int bar;

	public int getBar() {
		return this.bar;
	}

	public void setBar(int bar) {
		this.bar = bar;
	}
}
