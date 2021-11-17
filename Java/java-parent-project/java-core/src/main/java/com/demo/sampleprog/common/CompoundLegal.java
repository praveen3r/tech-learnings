package com.demo.sampleprog.common;

public class CompoundLegal {

    public static void main(String str[]) {

        //TODO: Legal

        // x += i; // first statement legal
        // x = x + i; // second statement illegal
        short x = 0;
        int i = 123456;
        x += i; // narrowing primitive conversion [JLS 5.1.3]
        //x = x + i; // won’t compile: “possible loss of precision�?
        // [JLS 15.26.2] says about compound assignment operator:
        // E1 op= E2 <==> E1 = (T) ((E1) op (E2))
        System.out.println("X :-" + x);


        //TODO: Illegal

//        x += i; // first statement illegal
//        x = x + i; // second statement legal
        Object x1 = "object string ";
        String i1 = "real string";
        //x1 += i1; // left-hand side object reference type != String
        x1 = x1 + i1; // is assignment compatible [JLS 5.2]
        // string concatenation is performed [JLS 15.26.2]
        System.out.println("X1 :-" + x1);

    }
}
