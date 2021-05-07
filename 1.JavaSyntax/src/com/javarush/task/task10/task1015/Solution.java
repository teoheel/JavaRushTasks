package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        ArrayList<String>[] arrayOfStringList = new ArrayList[5];
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("I");
        arrayOfStringList[0] = list1;
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("like");
        arrayOfStringList[1] = list2;
        ArrayList<String> list3 = new ArrayList<>();
        list3.add("to");
        arrayOfStringList[2] = list3;
        ArrayList<String> list4 = new ArrayList<>();
        list4.add("do");
        arrayOfStringList[3] = list4;
        ArrayList<String> list5 = new ArrayList<>();
        list5.add("something.");
        arrayOfStringList[4] = list5;

        return arrayOfStringList;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}