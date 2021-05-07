package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> intArray = new ArrayList();

        for (int i = 0; i < 20; ++i) {
            intArray.add(Integer.parseInt(reader.readLine()));
        }

        ArrayList<Integer> divBy3 = new ArrayList();
        ArrayList<Integer> divBy2 = new ArrayList();
        ArrayList<Integer> notDiv = new ArrayList();

        for (int i = 0; i < intArray.size(); ++i) {
            if ((Integer) intArray.get(i) % 3 == 0 && (Integer) intArray.get(i) % 2 == 0) {
                divBy3.add(intArray.get(i));
                divBy2.add(intArray.get(i));
            } else if ((Integer) intArray.get(i) % 3 == 0 && (Integer) intArray.get(i) % 2 != 0) {
                divBy3.add(intArray.get(i));
            } else if ((Integer) intArray.get(i) % 3 != 0 && (Integer) intArray.get(i) % 2 == 0) {
                divBy2.add(intArray.get(i));
            } else {
                notDiv.add(intArray.get(i));
            }
        }

        printList(divBy3);
        printList(divBy2);
        printList(notDiv);
    }

    public static void printList(List<Integer> list) {
        //напишите тут ваш код
        for (int i = 0; i < list.size(); ++i) {
            System.out.println(list.get(i));
        }
    }
}
