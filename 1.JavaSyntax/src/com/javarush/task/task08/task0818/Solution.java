package com.javarush.task.task08.task0818;

import java.util.HashMap;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put("Иванов", 500);
        stringIntegerHashMap.put("Петров", 600);
        stringIntegerHashMap.put("Сергеев", 400);
        stringIntegerHashMap.put("Николаев", 450);
        stringIntegerHashMap.put("Андреев", 550);
        stringIntegerHashMap.put("Кириллов", 650);
        stringIntegerHashMap.put("Александров", 590);
        stringIntegerHashMap.put("Алексеев", 300);
        stringIntegerHashMap.put("Владимиров", 490);
        stringIntegerHashMap.put("Борисов", 510);
        return stringIntegerHashMap;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        HashMap<String, Integer> copy = new HashMap<String, Integer>(map);
        for (HashMap.Entry<String, Integer> pair : copy.entrySet()) {
            if (pair.getValue() < 500) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {

    }
}