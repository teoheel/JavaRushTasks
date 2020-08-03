package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        while (true) {
            try {
                Integer integer = Integer.parseInt(reader.readLine());
                integerArrayList.add(integer);
            } catch (IOException e) {
                if (integerArrayList.size() > 0) {
                    for (Integer integer : integerArrayList) {
                        System.out.println(integer);
                    }
                }
                break;
            } catch (NumberFormatException e) {
                if (integerArrayList.size() > 0) {
                    for (Integer integer : integerArrayList) {
                        System.out.println(integer);
                    }
                }
                break;
            }
        }
    }
}
