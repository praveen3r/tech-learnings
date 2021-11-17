package com.demo.threadlocal;

public class ThreadLocalWithUserContext implements Runnable{

	public static ThreadLocal<Context> userContext = new ThreadLocal<>();
	
	private String userName;
	
	public ThreadLocalWithUserContext(String userName) {
		this.userName = userName;
	}
	
	
	@Override
    public void run() {
        userContext.set(new Context(userName));
        DemoClass DemoClass = new DemoClass();
        DemoClass.demoContext();
        System.out.println("thread context for given userName: "
          + userName + " is: " + userContext.get());
    }
}
