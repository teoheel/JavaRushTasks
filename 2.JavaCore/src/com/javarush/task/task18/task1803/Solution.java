package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Самые частые байты
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
        int max = Integer.MIN_VALUE;
        for (int b : byteArray) {
            if (max < b) {
                max = b;
            }
        }
        for (int i = 0; i < byteArray.length; i++) {
            if (byteArray[i] == max) {
                System.out.print(i + " ");
            }
        }
    }
}
