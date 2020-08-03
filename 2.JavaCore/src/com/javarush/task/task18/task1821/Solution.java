package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(args[0]))) {
            int[] buffer = new int[256];
            int b;
            while ((b = inputStream.read()) != -1) {
                buffer[b]++;
            }
            for (int i = 0; i < buffer.length; i++) {
                if (buffer[i] > 0) {
                    System.out.println((char) i + " " + buffer[i]);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
