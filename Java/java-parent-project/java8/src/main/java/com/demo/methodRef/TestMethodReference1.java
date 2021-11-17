package com.demo.methodRef;

import java.util.function.Consumer;

public class TestMethodReference1 {

	public static void main(String[] args) {
		    Util util = new Util();
		    
		    Consumer<String> consumer  = str ->  util.print(str);
		    consumer.accept("Hello"); 
		    

		    Consumer<String> consumer1  = util::print;
		    consumer1.accept("java");
		    
		    util.debug();
		    
		    
		  }
		}
		

class Util{
		  private int count=0;
		  public void print(String s){
		    System.out.println(s);
		    count++;
		  }
		  public void debug(){
		    System.out.println("count:" + count);
		  }
		}
