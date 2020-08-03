package com.javarush.task.task08.task0815;

import java.util.ArrayList;
import java.util.HashMap;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < 10; i++) {
            map.put(Integer.toString(i), Integer.toString(i));
        }
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int count = 0;
        ArrayList<String> list = new ArrayList<String>();
        list.addAll(map.values());
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(name)) {
                count++;
            }
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
        int count = 0;
        ArrayList<String> list = new ArrayList<String>();
        list.addAll(map.keySet());
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(lastName)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
