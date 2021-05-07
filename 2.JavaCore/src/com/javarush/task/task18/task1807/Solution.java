package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        reader.close();
        int count = 0;
        byte[] byteArr = new byte[inputStream.available()];
        while (inputStream.available() > 0) {
            for (int i = 0; i < byteArr.length; i++) {
                byteArr[i] = (byte) inputStream.read();
            }
        }
        inputStream.close();
        for (byte _byte : byteArr) {
            if (_byte == (byte) ',') {
                count++;
            }
        }
        System.out.println(count);
    }
}
