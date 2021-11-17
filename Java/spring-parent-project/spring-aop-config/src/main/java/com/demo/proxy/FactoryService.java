package com.demo.proxy;

import com.demo.Car;

public class FactoryService {
	public Object getBean(String beanType){
		Object obj= null;
		if(beanType.equals("car")){
			obj = new CarProxy();
		}
		return obj;
	}
}
