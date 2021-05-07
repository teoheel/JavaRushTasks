package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream inputStream = new FileInputStream(reader.readLine());
             FileOutputStream outputStream = new FileOutputStream(reader.readLine())) {
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            byte[] newBuffer = new byte[buffer.length];
            for (int i = 0; i < buffer.length; i++) {
                newBuffer[i] = buffer[buffer.length - 1 - i];
            }
            outputStream.write(newBuffer);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
