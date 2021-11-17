package com.demo;

import com.demo.hello.HelloModules;
import com.util.Display;

public class HelloWorld {
    public static void main(String[] args){
        Display display = new Display();
        display.display();

        HelloModules helloModules= new HelloModules();
        helloModules.sayHello();
    }
}
