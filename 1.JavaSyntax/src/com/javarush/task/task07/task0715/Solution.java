package com.javarush.task.task07.task0715;

import java.util.ArrayList;
import java.util.Collections;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<>();
        Collections.addAll(strings, "мама", "мыла", "раму");

        int length = strings.size();

        for (int i = 0; i < length; i++) {
            strings.add(2 * i + 1, "именно");
        }

        for (String string : strings) {
            System.out.println(string);
        }
    }
}
