package com.demo.sampleprog.common;

public class SimpleDivision {
    public static void main(String[] args) {
        final long MICROS_PER_DAY = 24 * 60 * 60 * 1000 * 1000;
        final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;
        System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY);

        // computation of constant overflows!
        long MICROS_PER_DAY_= ((int) (24 * 60 * 60 * 1000 * 1000));

        // afterwards widening primitive conversion [JLS 5.1.2]
        final long MICROS_PER_DAY_1= 24L * 60 * 60 * 1000 * 1000;
        final long MILLIS_PER_DAY_= 24L * 60 * 60 * 1000;
        System.out.println(MICROS_PER_DAY_1 / MILLIS_PER_DAY_);

    }
}