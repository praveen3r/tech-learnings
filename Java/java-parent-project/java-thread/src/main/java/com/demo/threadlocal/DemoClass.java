package com.demo.threadlocal;

public class DemoClass {

	public void demoContext(){
		Context context = ThreadLocalWithUserContext.userContext.get();
		System.out.println("In demo context " +context.getUserName());
	}
}
