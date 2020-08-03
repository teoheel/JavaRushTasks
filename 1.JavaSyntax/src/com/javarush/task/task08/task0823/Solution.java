package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //напишите тут ваш код
        char[] chars = s.toCharArray();
        String[] strings = new String[s.length()];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = String.valueOf(chars[i]);
        }

        for (int j = 0; j < strings.length; j++) {
            if (!strings.equals(" ")) {
                strings[0] = strings[0].toUpperCase();
            }
            if (strings[j].equals(" ") && !strings[j + 1].equals(" ")) {
                strings[j + 1] = strings[j + 1].toUpperCase();
            }
        }

        for (String string : strings) {
            System.out.print(string);
        }
    }
}
