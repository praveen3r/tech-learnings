package com.demo.func.interfce;

import java.util.function.ObjDoubleConsumer;

public class TestConsumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//accepts a single input argument and returns no result.
		/*Consumer<String> c = (x) -> System.out.println(x.toLowerCase());
	    c.accept("Java");*/
		
		/*Consumer<String> c = (x) -> System.out.println(x.toLowerCase());
		Consumer<String> c1 = (x) -> System.out.println(x + "test");
	    c.andThen(c1).accept("Java");*/
	    
	/*	BiConsumer<String, String> biConsumer = (x, y) -> {
		      System.out.println(x);
		      System.out.println(y);
		    };

		    biConsumer.accept("java", " tutorials");*/
		
	/*	IntConsumer ic = (x)->System.out.println(x);
	    ic.accept(3);*/
	    
	  /*  DoubleConsumer d = (x) -> System.out.println(x*x);
	    d.accept(0.23);*/
		
		/*LongConsumer i = (l) -> System.out.println(l);;
	    i.accept(Long.MAX_VALUE);*/
		
		/*ObjIntConsumer<String> i  = (s,d)->System.out.println(s+d);
	    i.accept("java ",234);*/
		
		/* ObjLongConsumer<String> i  = (s,d)->System.out.println(s+d);
		 i.accept("java ",Long.MAX_VALUE);*/
		
		 ObjDoubleConsumer<String> i  = (s,d)->System.out.println(s+d);
		 i.accept("java ",0.1234);
	}

}
