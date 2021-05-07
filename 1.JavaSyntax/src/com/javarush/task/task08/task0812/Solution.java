package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integers.add(Integer.parseInt(reader.readLine()));
        }

        int max = 1;
        int maxIf = 1;
        for (int i = 1; i < integers.size(); i++) {
            if (integers.get(i - 1).equals(integers.get(i))) {
                maxIf++;
                if (maxIf > max) {
                    max = maxIf;
                }
            } else {
                maxIf = 1;
            }
        }

        System.out.println(max);
    }
}