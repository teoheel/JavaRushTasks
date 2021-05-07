package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> stringArrayList = new ArrayList<String>();

        for (int i = 0; i < 5; i++) {
            stringArrayList.add("text" + (i + 1));
        }

        System.out.println(stringArrayList.size());

        for (int j = 0; j < stringArrayList.size(); j++) {
            System.out.println(stringArrayList.get(j));
        }
    }
}
