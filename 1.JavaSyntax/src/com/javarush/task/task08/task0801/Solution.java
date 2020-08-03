package com.javarush.task.task08.task0801;

/* 
HashSet из растений
*/

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        HashSet<String> stringHashSet = new HashSet<>();

        stringHashSet.add("арбуз");
        stringHashSet.add("банан");
        stringHashSet.add("вишня");
        stringHashSet.add("груша");
        stringHashSet.add("дыня");
        stringHashSet.add("ежевика");
        stringHashSet.add("женьшень");
        stringHashSet.add("земляника");
        stringHashSet.add("ирис");
        stringHashSet.add("картофель");

        for (String string : stringHashSet) {
            System.out.println(string);
        }
    }
}
