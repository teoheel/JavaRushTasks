package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            strings.add(reader.readLine());
        }

        int min = strings.get(0).length();
        int max = strings.get(0).length();
        int result = 0;

        for (int j = 0; j < strings.size(); j++) {
            if (min > strings.get(j).length()) {
                min = strings.get(j).length();
            } else if (max < strings.get(j).length()) {
                max = strings.get(j).length();
            }
        }

        for (int n = 0; n < strings.size(); n++) {
            if (strings.get(n).length() == min) {
                System.out.println(strings.get(n));
                break;
            } else if (strings.get(n).length() == max) {
                System.out.println(strings.get(n));
                break;
            }
        }
    }
}
