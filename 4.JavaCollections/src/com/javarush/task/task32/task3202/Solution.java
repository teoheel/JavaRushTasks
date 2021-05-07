package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter writer = new StringWriter();
        if (is == null) {
            return writer;
        } else {
            try (BufferedInputStream bufferedInputStream = new BufferedInputStream(is, 1024)) {
                int i;
                while ((i = bufferedInputStream.read()) != -1) {
                    writer.write(i);
                }
                return writer;
            }
        }
    }
}