package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Schwarznegger", new Date("JANUARY 1 1980"));
        map.put("Carrey", new Date("FEBRUARY 1 1980"));
        map.put("Willis", new Date("MARCH 1 1980"));
        map.put("Statham", new Date("APRIL 1 1980"));
        map.put("Chan", new Date("MAY 1 1980"));
        map.put("Lundgren", new Date("JULY 1 1980"));
        map.put("Johnson", new Date("AUGUST 1 1980"));
        map.put("Bautista", new Date("SEPTEMBER 1 1980"));
        map.put("Cena", new Date("OCTOBER 1 1980"));

        //напишите тут ваш код
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Date> pair = iterator.next();
            if (pair.getValue().getMonth() > 4 && pair.getValue().getMonth() < 8) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {

    }
}
