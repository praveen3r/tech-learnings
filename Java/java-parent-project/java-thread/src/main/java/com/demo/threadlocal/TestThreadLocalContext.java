package com.demo.threadlocal;

import java.util.Random;

import com.demo.threadlocal.TestThreadLocal.MyRunnable;

public class TestThreadLocalContext {

	public static void main(String[] args) throws Exception{
		ThreadLocalWithUserContext firstUser 
		  = new ThreadLocalWithUserContext("Raghu");
		ThreadLocalWithUserContext secondUser 
		  = new ThreadLocalWithUserContext("Prav");
		new Thread(firstUser).start();
		new Thread(secondUser).start();

	}
}
