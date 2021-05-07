package com.javarush.task.task10.task1019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> integerStringHashMap = new HashMap<>();
        String s, name;
        int count = 0;
        while (true) {
            s = reader.readLine();
            if (s.isEmpty()) {
                break;
            }
            count++;
            int id = Integer.parseInt(s);
            name = reader.readLine();
            if (name.isEmpty()) {
                break;
            }
            integerStringHashMap.put(name, id);
        }

        for (Map.Entry<String, Integer> pair : integerStringHashMap.entrySet()) {
            System.out.println(pair.getValue() + " " + pair.getKey());
        }

        if (count > integerStringHashMap.size()) {
            System.out.println(s);
        }
    }
}
