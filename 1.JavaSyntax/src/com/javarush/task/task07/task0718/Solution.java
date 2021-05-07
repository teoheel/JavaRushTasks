package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            strings.add(reader.readLine());
        }

        boolean flag = true;

        for (int i = 0; i < strings.size() - 1; i++) {
            for (int j = i + 1; j < strings.size(); j++) {
                if (strings.get(i).length() > strings.get(j).length()) {
                    flag = false;
                }
            }
            if (!flag) {
                System.out.println(i + 1);
                break;
            }
        }
    }
}