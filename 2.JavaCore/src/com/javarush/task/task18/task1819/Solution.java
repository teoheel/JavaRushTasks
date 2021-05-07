package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String file1;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream inputStream1 = new FileInputStream(file1 = reader.readLine());
             FileInputStream inputStream2 = new FileInputStream(reader.readLine())) {
            byte[] bytes1 = new byte[inputStream1.available()];
            int count1 = inputStream1.read(bytes1);
            byte[] bytes2 = new byte[inputStream2.available()];
            int count2 = inputStream2.read(bytes2);
            FileOutputStream outputStream = new FileOutputStream(file1);
            outputStream.write(bytes2, 0, count2);
            outputStream.write(bytes1, 0, count1);
            outputStream.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
