package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        ArrayList<int[]> arrays = new ArrayList<>();

        int[] array1 = new int[5];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = i + 1;
        }

        int[] array2 = new int[2];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = i + 1;
        }

        int[] array3 = new int[4];
        for (int i = 0; i < array3.length; i++) {
            array3[i] = i + 1;
        }

        int[] array4 = new int[7];
        for (int i = 0; i < array4.length; i++) {
            array4[i] = i + 1;
        }

        int[] array5 = new int[0];

        arrays.add(array1);
        arrays.add(array2);
        arrays.add(array3);
        arrays.add(array4);
        arrays.add(array5);

        return arrays;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
