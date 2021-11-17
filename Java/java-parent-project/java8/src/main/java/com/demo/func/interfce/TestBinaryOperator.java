package com.demo.func.interfce;

public class TestBinaryOperator {

	public static void main(String[] args) {
		// two operands of the same type, producing a result of the same type.		
		/*BinaryOperator<Integer> adder = (n1, n2) -> n1 + n2;
	      System.out.println(adder.apply(3, 4));*/
		
		/* BinaryOperator<Integer> bi = BinaryOperator.minBy(Comparator.naturalOrder());
	     System.out.println(bi.apply(2, 3));
	     
	     BinaryOperator<Integer> bi = BinaryOperator.maxBy(Comparator.naturalOrder());
	     System.out.println(bi.apply(2, 3));*/
	     
		/*BinaryOperator<Integer> bi = BinaryOperator.minBy(Comparator.reverseOrder());
	     System.out.println(bi.apply(2, 3));
	     
	     BinaryOperator<Integer> bi = BinaryOperator.maxBy(Comparator.reverseOrder());
	     System.out.println(bi.apply(2, 3));*/
	     
	/*	IntBinaryOperator io = (x,y)->x +y;
	    System.out.println(io.applyAsInt(2,3));*/
	    
	    /*DoubleBinaryOperator d = (x,y) -> x*y;
	    System.out.println(d.applyAsDouble(0.23, 0.45));*/
		
		 /*LongBinaryOperator i = (x,y) -> x/y;
		 System.out.println(i.applyAsLong(Long.MAX_VALUE,Long.MAX_VALUE));*/
	    
	}

}
