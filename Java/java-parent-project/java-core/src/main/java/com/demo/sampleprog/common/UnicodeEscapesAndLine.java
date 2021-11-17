package com.demo.sampleprog.common;

public class UnicodeEscapesAndLine {
    public static void main(String[] args) {
//         \u0022 is the unicode escape for double quote (")
        System.out.println("a\u0022.length() + \u0022b".length());
    }

    public class LinePrinter {
        public void printLine() {
           char c = 0x000A;
           System.out.print(c);
        }
    }
}