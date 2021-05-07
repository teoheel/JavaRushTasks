package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        TreeSet<Integer> byteSet = new TreeSet<>();
        while (inputStream.available() > 0) {
            byteSet.add(inputStream.read());
        }
        inputStream.close();
        for (Integer _byte : byteSet) {
            System.out.print(_byte + " ");
        }
    }
}
