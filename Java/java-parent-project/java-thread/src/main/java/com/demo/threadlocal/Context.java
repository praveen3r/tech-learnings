package com.demo.threadlocal;

public class Context {

	private String userName;
	 
    public Context(String userName) {
        this.userName = userName;
    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
    
    
}
