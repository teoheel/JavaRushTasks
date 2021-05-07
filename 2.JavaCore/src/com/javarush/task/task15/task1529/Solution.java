package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static CanFly result;

    static {
        //add your code here - добавьте код тут
        reset();
    }

    public static void main(String[] args) {

    }

    public static void reset() {
        //add your code here - добавьте код тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String aircraft = "";
        int passengers = 0;
        try {
            aircraft = reader.readLine();
            if (aircraft.equals("helicopter")) {
                result = new Helicopter();
            } else if (aircraft.equals("plane")) {
                passengers = Integer.parseInt(reader.readLine());
                result = new Plane(passengers);
            } else result = null;
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
