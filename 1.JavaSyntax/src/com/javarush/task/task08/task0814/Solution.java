package com.javarush.task.task08.task0814;

import java.util.ArrayList;
import java.util.HashSet;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        //напишите тут ваш код
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < 20; i++) {
            set.add(i + 1);
        }
        return set;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {
        //напишите тут ваш код
        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
        for (int integer : set) {
            integerArrayList.add(integer);
        }

        set.clear();

        for (int i = 0; i < integerArrayList.size(); ) {
            if (integerArrayList.get(i) > 10) {
                integerArrayList.remove(i);
            } else {
                i++;
            }
        }

        for (int i = 0; i < integerArrayList.size(); i++) {
            set.add(integerArrayList.get(i));
        }

        return set;
    }

    public static void main(String[] args) {

    }
}
