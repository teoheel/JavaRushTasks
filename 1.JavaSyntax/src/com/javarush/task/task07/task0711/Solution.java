package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            strings.add(reader.readLine());
        }

        for (int j = 0; j < 13; j++) {
            String string = strings.get(strings.size() - 1);
            strings.remove(strings.size() - 1);
            strings.add(0, string);
        }

        for (int n = 0; n < strings.size(); n++) {
            System.out.println(strings.get(n));
        }
    }
}
