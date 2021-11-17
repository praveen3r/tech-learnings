package com.demo.common;

import java.util.Arrays;
import java.util.stream.Stream;

public class MergeArray {

      
    public static void main (String[] args)  
    { 
        Integer[] a = new Integer[]{1,2,3}; 
        Integer[] b = new Integer[]{4,15,6}; 
      
        Object[] c = concatenateSort(a,b); 
          
  
    System.out.println("Merged object array : "
                       + Arrays.toString(c)); 
    } 
    
    public static <T> Object[] concatenate(T[] a, T[] b) 
    { 
        // Function to merge two arrays of  
        // same type 
        return Stream.of(a, b) 
                     .flatMap(Stream::of) 
                     .toArray(); 
  
        // Arrays::stream can also be used in place 
        // of Stream::of in the flatMap() above. 
    } 
    
    public static <T> Object[] concatenateSort(T[] a, T[] b) 
    { 
        // Function to merge two arrays of  
        // same type 
        return Stream.of(a, b)
                     .flatMap(Stream::of).sorted() 
                     .toArray(); 
  
        // Arrays::stream can also be used in place 
        // of Stream::of in the flatMap() above. 
    } 
}
