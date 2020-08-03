package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            URL aURL = new URL(reader.readLine());
            String query = aURL.getQuery();
            String[] queryArray = query.split("&");
            String parameter = "";
            for (String queryLine : queryArray) {
                parameter = queryLine.replaceAll("=.+$", "");
                System.out.print(parameter + " ");
            }
            System.out.println();
            String value = "";
            for (String queryLine : queryArray) {
                if (queryLine.contains("obj")) {
                    value = queryLine.replaceAll("^.+=", "");
                    try {
                        alert(Double.parseDouble(value));
                    } catch (NumberFormatException e) {
                        alert(value);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
