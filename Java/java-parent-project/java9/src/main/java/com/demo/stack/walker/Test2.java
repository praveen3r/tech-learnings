package com.demo.stack.walker;

public class Test2 {

	public void test() throws Exception{
		//StackWalker stack = StackWalker.getInstance();
		//StackWalker stack = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
		//StackWalker stack = StackWalker.getInstance(StackWalker.Option.SHOW_HIDDEN_FRAMES);
		//StackWalker stack = StackWalker.getInstance(StackWalker.Option.SHOW_REFLECT_FRAMES);
		//stack.forEach(System.out::println);
		/*StackWalker
		  .getInstance(java.lang.StackWalker.Option.RETAIN_CLASS_REFERENCE)
		  .walk(s -> s.skip(1).limit(1).collect(Collectors.toList()))
		  .forEach(System.out::println);*/
		/*Class<?> callerClass = StackWalker
		        .getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE)
		        .getCallerClass();
		System.out.println(callerClass);*/
		StackWalker stack = StackWalker.getInstance();
		//StackWalker stack = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
		stack.forEach(stackFrame -> {
		 System.out.println(" \n*******************************************\n");
		 System.out.println(" Class name : " + stackFrame.getClassName());
		 System.out.println(" Declaring Class name : " + stackFrame.getDeclaringClass());
		 System.out.println(" File name : " + stackFrame.getFileName());
		 System.out.println(" Bytecode index : " + stackFrame.getByteCodeIndex());
		 System.out.println(" Line number : " + stackFrame.getLineNumber());
		 System.out.println(" Method name : " + stackFrame.getMethodName());
		 System.out.println(" Is method native or not? : " + stackFrame.isNativeMethod());
		 });
		System.out.println(1/0);
	}
}
