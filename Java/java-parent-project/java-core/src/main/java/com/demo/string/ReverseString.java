package com.demo.string;

import java.lang.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

// Class of ReverseString
class ReverseString {
    public static void main(String[] args) {

        String input = "GeeksforGeeks";

        //TODO : Way 1 Converting String into Bytes
        // getBytes() method to convert string
        // into bytes[].
        byte[] strAsByteArray = input.getBytes();
        byte[] result = new byte[strAsByteArray.length];
        // Store result in reverse order into the
        // result byte[]
        for (int i = 0; i < strAsByteArray.length; i++)
            result[i] = strAsByteArray[strAsByteArray.length - i - 1];
        System.out.println(new String(result));

        //TODO : Way 2 Using built in reverse() method of the StringBuilder class

        StringBuilder input1 = new StringBuilder();
        // append a string into StringBuilder input1
        input1.append(input);
        // reverse StringBuilder input1
        input1 = input1.reverse();
        // print reversed String
        System.out.println(input1);

        //TODO : Way 3 Converting String to character array
        char[] try1 = input.toCharArray();
        for (int i = try1.length - 1; i >= 0; i--)
            System.out.print(try1[i]);


        //TODO : Way 4 Convert the input string into character array by using the toCharArray()
        char[] temparray = input.toCharArray();
        int left, right = 0;
        right = temparray.length - 1;

        for (left = 0; left < right; left++, right--) {
            // Swap values of left and right
            char temp = temparray[left];
            temparray[left] = temparray[right];
            temparray[right] = temp;
        }

        for (char c : temparray)
            System.out.print(c);
        System.out.println();

        //TODO : Way 5 Using ArrayList object
        char[] hello = input.toCharArray();
        List<Character> trial1 = new ArrayList<Character>();

        for (char c : hello)
            trial1.add(c);

        Collections.reverse(trial1);
        ListIterator li = trial1.listIterator();
        while (li.hasNext())
            System.out.print(li.next());

    }
}