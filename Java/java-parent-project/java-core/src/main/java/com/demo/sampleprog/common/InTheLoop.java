package com.demo.sampleprog.common;

public class InTheLoop {
    public static final int END = Integer.MAX_VALUE;
    public static final int START = END - 100;

    public static void main(String[] args) {
        int count = 0;
        for (int i = START; i <= END; i++)
            count++;
        System.out.println(count);

        int count1 = 0;
        for (long i = START; i <= END; i++)
            count1++;


        //TODO : Never Ending
//        ___ start = _____________________;
//        for (int i = start; i <= start + 1; i++) { }
//        ______ i = ________________________;
//        while (i == i + 1) { }
//        int Integer.MAX_VALUE - 1
//        double Double.POSITIVE_INFINITY // see [IEEE-754]
//        ______ i = __________;
//        while (i != i) { }
//        double Double.NaN // see [JLS 15.21.1]
//        ______ i = ________;
//        while(i != i + 0) { }
//        String â€œfoobarâ€? // see [JLS 15.18.1]
//        _______ i = ______________;
//        _______ j = ______________;
//        while(i <= j && j <= i && i != j) { }
//
    }

}
