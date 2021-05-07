package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            strings.add(reader.readLine());
        }

        int min = strings.get(0).length();

        for (int j = 0; j < strings.size(); j++) {
            if (min > strings.get(j).length()) {
                min = strings.get(j).length();
            }
        }

        for (int n = 0; n < strings.size(); n++) {
            if (strings.get(n).length() == min) {
                System.out.println(strings.get(n));
            }
        }
    }
}
