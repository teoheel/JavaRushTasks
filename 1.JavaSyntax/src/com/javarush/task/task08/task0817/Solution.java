package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();
        map.put("1", "C");
        map.put("2", "A");
        map.put("3", "A");
        map.put("4", "A");
        map.put("5", "A");
        map.put("6", "D");
        map.put("7", "B");
        map.put("8", "B");
        map.put("9", "B");
        map.put("10", "B");
        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //напишите тут ваш код
        HashMap<String, String> copy = new HashMap<String, String>(map);
        System.out.println();
        for (Map.Entry<String, String> pair1 : copy.entrySet()) {
            String text = pair1.getValue();
            int i = 0;
            for (Map.Entry<String, String> pair2 : map.entrySet()) {
                if (pair2.getValue().equals(text)) {
                    i++;
                }
            }
            if (i >= 2) {
                removeItemFromMapByValue(map, text);
            }
        }
        System.out.println();
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

    }
}
