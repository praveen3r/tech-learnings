package com.demo.string;

import java.io.*;
import java.net.URL;


public class StringFinder {
    static String FILEPATH = "/Text.txt";

    public File readFileFromClasspath() {
        URL fileUrl = getClass().getResource(FILEPATH);
        return new File(fileUrl.getFile());
    }

    public static void main(String[] args) {
        StringFinder stringFinder = new StringFinder();
        stringFinder.searchString();
    }

    void searchString() {
        double count = 0, countBuffer = 0, countLine = 0;
        String lineNumber = "";

        BufferedReader br;
        String inputSearch = "are";
        String line = "";

        try {
            br = new BufferedReader(new FileReader(readFileFromClasspath()));
            try {
                while ((line = br.readLine()) != null) {
                    countLine++;
                    //System.out.println(line);
                    String[] words = line.split(" ");

                    for (String word : words) {
                        if (word.equals(inputSearch)) {
                            count++;
                            countBuffer++;
                        }
                    }

                    if (countBuffer > 0) {
                        countBuffer = 0;
                        lineNumber += countLine + ",";
                    }

                }
                br.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Times found at--" + count);
        System.out.println("Word found at--" + lineNumber);
    }
}