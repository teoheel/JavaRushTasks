package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<>();
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        map1.put("1", "1");
        map1.put("2", "2");
        map1.put("3", "3");
        map1.put("4", "4");
        map1.put("5", "5");
        map2.put("1", "1");
        map2.put("2", "2");
        map2.put("3", "3");
        map2.put("4", "4");
        map2.put("5", "5");
        map.putAll(map1);
        map.putAll(map2);
        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
