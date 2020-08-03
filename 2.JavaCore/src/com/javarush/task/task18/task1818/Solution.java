package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileOutputStream outputStream = new FileOutputStream(reader.readLine(), true);
             FileInputStream inputStream1 = new FileInputStream(reader.readLine());
             FileInputStream inputStream2 = new FileInputStream(reader.readLine())) {
            byte[] bytes1 = new byte[inputStream1.available()];
            int count1 = inputStream1.read(bytes1);
            outputStream.write(bytes1, 0, count1);
            byte[] bytes2 = new byte[inputStream2.available()];
            int count2 = inputStream2.read(bytes2);
            outputStream.write(bytes2, 0, count2);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
