package com.demo.sampleprog.common;

import java.util.ArrayList;
import java.util.List;

public class SimpleAddition {
    public static void main(String[] args) {
        System.out.println(12345 + 5432l);

        List<String> l = new ArrayList<String>();
        l.add("Foo");
        System.out.println(l);
        System.out.println(1);

        System.out.println(12345 + 5432L);

    }
}