package com.demo.sampleprog.common;

import java.math.BigDecimal;

public class SimpleSubtraction {
    public static void main(String[] args) {
        System.out.println(2.00 - 1.10);

        // solution #1: poor - still uses binary floating-point!
        System.out.printf("%.2f%n", 2.00 - 1.10);

        // solution #2: use integral types
        System.out.println((200 - 110) + "cents");

        // solution #3: use BigDecimal(String)
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.10")));
    }
}