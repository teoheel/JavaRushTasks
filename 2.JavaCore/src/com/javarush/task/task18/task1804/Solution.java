package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        reader.close();
        int[] byteArray = new int[256];
        while (inputStream.available() > 0) {
            ++byteArray[inputStream.read()];
        }
        inputStream.close();
        int min = Integer.MAX_VALUE;
        for (int value : byteArray) {
            if (min > value && value > 0) {
                min = value;
            }
        }
        for (int i = 0; i < byteArray.length; i++) {
            if (byteArray[i] == min) {
                System.out.print(i + " ");
            }
        }
    }
}
