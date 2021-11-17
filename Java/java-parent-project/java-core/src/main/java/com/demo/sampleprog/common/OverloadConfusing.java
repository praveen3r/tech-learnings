package com.demo.sampleprog.common;

public class OverloadConfusing {

    public OverloadConfusing(Object o) {
        System.out.println("Object");
    }

    public OverloadConfusing(double[] d) {
        System.out.println("double array");
    }

    public static void main(String[] args) {
        new OverloadConfusing(null);

        // overloading process operates in two phases [JLS 15.12.2.5]
        new OverloadConfusing((Object) null);

    }
}
