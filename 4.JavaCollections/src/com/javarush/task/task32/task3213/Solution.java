package com.javarush.task.task32.task3213;

import java.io.StringReader;
import java.io.StringWriter;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) {
        try {
            StringWriter stringWriter = new StringWriter();
            int t;
            while ((t = reader.read()) != -1) {
                stringWriter.write((char) t + key);
            }
            return stringWriter.toString();
        } catch (Exception ignored) {
            return "";
        }
    }
}
