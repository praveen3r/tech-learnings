package com.demo.sampleprog.common;

public class StringLitterals {
    public static void main(String str[]) {
        String s = null;
        System.out.println(s instanceof String);
        //System.out.println(new StringLitterals().Type2() instanceof String);
    }

    class Type2 {
    }

    class Type3 {
        public void main(String[] args) {
            Type3 t = (Type3) new Object();
        }
    }
}

