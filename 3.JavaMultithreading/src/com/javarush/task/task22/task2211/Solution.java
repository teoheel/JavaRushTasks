package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Charset windows1251 = Charset.forName("Windows-1251");
        Charset UTF8 = StandardCharsets.UTF_8;
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(args[0]));
             BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(args[1]))) {
            while (inputStream.available() > 0) {
                byte[] buffer = new byte[1000];
                inputStream.read(buffer);
                String s = new String(buffer, windows1251);
                buffer = s.getBytes(UTF8);
                outputStream.write(buffer);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
